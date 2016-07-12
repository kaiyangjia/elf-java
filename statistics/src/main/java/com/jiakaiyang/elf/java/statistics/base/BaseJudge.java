package com.jiakaiyang.elf.java.statistics.base;

import java.util.Collection;

/**
 * 判断基本类型
 */
public class BaseJudge<T> implements Judge<T>{
    private T standard;
    private Collection<T> standardCollection;
    //用于比较对象大小所依据的对象的成员名称
    private String judgeField;

    public BaseJudge(T standard) {
        this.standard = standard;
    }

    public BaseJudge(Collection<T> standardCollection) {
        this.standardCollection = standardCollection;
    }

    public boolean largerThanStandard(T a) {
        return largerThan(a, standard);
    }

    public boolean smallerThanStandard(T a) {
        return smallerThan(a, standard);
    }

    public boolean equalWithStandard(T a) {
        return smallerThan(a, standard);
    }

    public boolean inStandard(T a){
        return in(a, standardCollection);
    };


    public boolean largerThan(T a, T b) {
        if(a instanceof Comparable
                && a instanceof Comparable){
            Comparable comparableA = (Comparable) a;
            Comparable comparableB = (Comparable) b;

            int result = comparableA.compareTo(comparableB);

            return result > 0;
        }else{

        }
        return false;
    }

    public boolean smallerThan(T a, T b) {
        return false;
    }

    public boolean equalWith(T a, T b) {
        return false;
    }

    public boolean in(T a, Collection<T> b) {
        return false;
    }
}
