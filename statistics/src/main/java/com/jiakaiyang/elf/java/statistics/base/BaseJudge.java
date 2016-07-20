package com.jiakaiyang.elf.java.statistics.base;

import java.util.Collection;

import com.jiakaiyang.elf.java.common.utils.InstanceUtils;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * 判断基本类型
 */
public class BaseJudge<T> implements Judge<T>{
    @Setter @Getter
    private T standard;
    @Getter @Setter
    private Collection<T> standardCollection;
    //用于比较对象大小所依据的对象的成员名称
    @Getter @Setter
    private String judgeField;

    public BaseJudge(){}

    public BaseJudge(T standard) {
        this.standard = standard;
    }

    public BaseJudge(T standard, String judgeField){
        this.standard = standard;
        this.judgeField = judgeField;
    }

    public BaseJudge(Collection<T> standardCollection) {
        this.standardCollection = standardCollection;
    }

    public BaseJudge(Collection<T> standardCollection, String judgeField) {
        this.standardCollection = standardCollection;
        this.judgeField = judgeField;
    }

    public boolean largerThanStandard(T a) {
        return largerThan(a, standard);
    }

    public boolean smallerThanStandard(T a) {
        return smallerThan(a, standard);
    }

    public boolean equalWithStandard(T a) {
        return equalWith(a, standard);
    }

    public boolean inStandard(T a){
        return in(a, standardCollection);
    }


    public boolean largerThan(T a, T b) {
        if(a instanceof Comparable
                && a instanceof Comparable){
            Comparable comparableA = (Comparable) a;
            Comparable comparableB = (Comparable) b;

            int result = comparableA.compareTo(comparableB);

            return result > 0;
        }else{
            if(StringUtils.isNotBlank(judgeField)){
                Object aValue = InstanceUtils.getInstanceFieldValue(a, judgeField);
                Object bValue = InstanceUtils.getInstanceFieldValue(b, judgeField);

                BaseJudge valueBaseJudge = new BaseJudge();
                return valueBaseJudge.largerThan(aValue, bValue);
            }
        }
        return false;
    }


    /**
     * 判断a是否比b小
     * @param a
     * @param b
     * @return
     */
    public boolean smallerThan(T a, T b) {
        if(equalWith(a, b)){
            return false;
        }
        return largerThan(b, a);
    }

    /**
     * 判断a,b是否想等。如果judgeField存在的话,优先判断a,b的judgeField属性值是否相等
     * @param a
     * @param b
     * @return
     */
    public boolean equalWith(T a, T b) {
        if(StringUtils.isNotBlank(judgeField)){
            return new EqualsBuilder()
                    .append(InstanceUtils.getInstanceFieldValue(a, judgeField)
                    ,InstanceUtils.getInstanceFieldValue(b, judgeField))
                    .isEquals();
        }else{
            if(a != null && b != null){
                return a.equals(b);
            }else if(a == null && b == null){
                return true;
            }else{
                return false;
            }
        }
    }

    public boolean in(T a, Collection<T> b) {
        if(b == null || a == null){
            return false;
        }

        return b.contains(a);
    }
}
