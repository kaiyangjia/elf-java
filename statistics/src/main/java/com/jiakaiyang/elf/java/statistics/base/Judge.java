package com.jiakaiyang.elf.java.statistics.base;

import java.util.Collection;

/**
 * 对数据进行计算并判断
 */
public interface Judge<T> {

    /**
     * 如果 a 大于 b，返回true；否则返回false
     * @param a
     * @param b
     * @return
     */
    public boolean largerThan(T a, T b);



    public boolean smallerThan(T a, T b);


    /**
     * 判断a 和 b是否相等,相等返回true,否则返回false
     * @param a
     * @param b
     * @return
     */
    public boolean equalWith(T a, T b);


    public boolean in(T a, Collection<T> b);
}
