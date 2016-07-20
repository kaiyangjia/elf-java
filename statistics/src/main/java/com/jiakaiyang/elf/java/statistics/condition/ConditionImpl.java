package com.jiakaiyang.elf.java.statistics.condition;

/**
 * 条件的实现类，也是各种条件的基类
 */
public class ConditionImpl<T> implements ConditionContract<T> {

    public boolean accept(T data) {
        return false;
    }
}
