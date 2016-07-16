package com.jiakaiyang.elf.java.statistics.group;

import com.jiakaiyang.elf.java.statistics.base.ConditionImpl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 分组操作的接口，约束分组行为的协议
 */
public interface GrouperContract<T> {

    /**
     * 把一个集合分组,集合中对象的成员groupFieldName值相等的划分为一组,分组的结果放在一个map中,map的
     * kay是groupFieldName对应的值
     * @param rawData 分组前的数据源
     * @param groupFieldName 用于分组的对象成员的名称
     * @return
     */
    public Map<Object, Collection> groupToMap(Collection<T> rawData, String groupFieldName);


    /**
     * 把一个集合按照给定的条件分组,满足条件的分为一组,不满足的分为一组
     * 分组的结果以一个map的形式返回,满足的kay是KEY_ACCEPT,不满足的key是KEY_NOT_ACCEPT
     * @param rawData 分组前的数据源
     * @param acceptConditionImpl 接受的条件
     * @return
     */
    public Map<Object, Collection> groupToMap(Collection<T> rawData, ConditionImpl<T> acceptConditionImpl);


    /**
     * 把一个集合分组,集合中对象的成员groupFieldName值相等的划分为一组
     * 分组的结果存在在一个List里面
     * @param rawData 分组前的数据源
     * @param groupFieldName 用于分组的对象成员的名称
     * @return
     */
    public List<Collection> groupToList(Collection<T> rawData, String groupFieldName);



    /**
     * 把一个集合按照给定的条件分组,满足条件的分为一组,不满足的分为一组
     * 分组的结果以一个list的形式返回
     * @param rawData 分组前的数据源
     * @param acceptConditionImpl 接受的条件
     * @return
     */
    public List<Collection> groupToList(Collection<T> rawData, ConditionImpl<T> acceptConditionImpl);



    /**
     * 把一个集合分组,集合中对象的成员groupFieldName值相等的划分为一组
     * 分组的结果存在在一个Collection里面
     * @param rawData 分组前的数据源
     * @param groupFieldName 用于分组的对象成员的名称
     * @return
     */
    public Collection<Collection> groupToCollection(Collection<T> rawData, String groupFieldName);



    /**
     * 把一个集合按照给定的条件分组,满足条件的分为一组,不满足的分为一组
     * 分组的结果以一个Collection的形式返回
     * @param rawData 分组前的数据源
     * @param acceptConditionImpl 接受的条件
     * @return
     */
    public Collection<Collection> groupToCollection(Collection<T> rawData, ConditionImpl<T> acceptConditionImpl);

}
