package com.jiakaiyang.elf.java.statistics.condition;

/**
 * 数据的条件，对数据的一种判定，数据可以满足某一个条件，也可能不满足，而且只能是这两中情况
 */
public interface ConditionContract<T> {

    /**
     * 数据书否满足某个条件
     * @param data 数据
     * @param <T>
     * @return
     */
    public boolean accept(T data);
}
