package com.jiakaiyang.elf.java.statistics.condition;

import com.jiakaiyang.elf.java.statistics.base.BaseJudge;

import java.util.Collection;

/**
 * 条件的代理类，负责对条件相关操作的调用
 */
public class BaseCondition<T> extends ConditionImpl<T> {
    public final byte TYPE_LARGER = 0;

    public final byte TYPE_SMALLER = 1;

    public final byte TYPE_EQUAL = 2;

    public final byte TYPE_IN = 3;

    //条件的类型
    private byte type;
    private T standard;
    private Collection<T> standardCollection;
    private BaseJudge<T> mJudge;


    public BaseCondition(byte type, T standard) {
        this.type = type;
        mJudge = new BaseJudge<T> (standard);
    }


    public BaseCondition(byte type, Collection<T> standardCollection) {
        this.type = type;
        this.standardCollection = standardCollection;
        mJudge = new BaseJudge<T>(standardCollection);
    }

    @Override
    public boolean accept(T data) {
        switch (type){
            case TYPE_LARGER:
                return mJudge.largerThanStandard(data);
            case TYPE_SMALLER:
                return mJudge.smallerThanStandard(data);
            case TYPE_EQUAL:
                return mJudge.equalWithStandard(data);
            case TYPE_IN:
                return mJudge.inStandard(data);
        }
        return false;
    }
}
