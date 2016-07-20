package com.jiakaiyang.elf.java.statistics.group;

import com.jiakaiyang.elf.java.common.utils.InstanceUtils;
import com.jiakaiyang.elf.java.statistics.condition.ConditionContract;

import java.util.*;

/**
 * 对一组数据（表现为一个java对象的集合）根据条件Condition进行分组。用户直接使用该类进行分组操作。该类是一个API提供类。具体的实现并不在该类里
 */
public class SimpleDataGrouper<T> implements GrouperContract<T>{

    public static final String KEY_ACCEPT = "accept";

    public static final String KEY_NOT_ACCEPT = "not_accept";


    public Map<Object, Collection> groupToMap(Collection<T> rawData, String groupFieldName) {
        Map<Object, Collection> result = new HashMap<Object, Collection>();

        Iterator<T> iterator = rawData.iterator();
        while (iterator.hasNext()){
            T entity = iterator.next();
            Object key = InstanceUtils.getInstanceFieldValue(entity, groupFieldName);

            Collection collection;
            if(result.containsKey(key)){
                collection = result.get(key);
                collection.add(entity);
            }else {
                collection = new HashSet();
                collection.add(entity);
                result.put(key, collection);
            }
        }
        return result;
    }

    public Map<Object, Collection> groupToMap(Collection<T> rawData, ConditionContract<T> acceptConditionImpl) {
        Map<Object, Collection> result = new HashMap<Object, Collection>();

        Iterator<T> iterator = rawData.iterator();
        Collection acceptCollection = new HashSet();
        Collection notAcceptCollection = new HashSet();
        while (iterator.hasNext()){
            T entity = iterator.next();
            if(acceptConditionImpl.accept(entity)){
                acceptCollection.add(entity);
            }else{
                notAcceptCollection.add(entity);
            }
        }

        result.put(KEY_ACCEPT, acceptCollection);
        result.put(KEY_NOT_ACCEPT, notAcceptCollection);
        return result;
    }

    public List<Collection> groupToList(Collection<T> rawData, String groupFieldName) {
        Map<Object, Collection> mapResult = groupToMap(rawData, groupFieldName);
        List<Collection> result = new ArrayList<Collection>(mapResult.values());
        return result;
    }

    public List<Collection> groupToList(Collection<T> rawData, ConditionContract<T> acceptConditionImpl) {
        Map<Object, Collection> mapResult = groupToMap(rawData, acceptConditionImpl);
        List<Collection> result = new ArrayList<Collection>(mapResult.values());
        return result;
    }

    public Collection<Collection> groupToCollection(Collection<T> rawData, String groupFieldName) {
        Map<Object, Collection> mapResult = groupToMap(rawData, groupFieldName);
        return mapResult.values();
    }

    public Collection<Collection> groupToCollection(Collection<T> rawData, ConditionContract<T> acceptConditionImpl) {
        Map<Object, Collection> mapResult = groupToMap(rawData, acceptConditionImpl);
        return mapResult.values();
    }
}
