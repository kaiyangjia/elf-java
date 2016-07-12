package com.jiakaiyang.elf.java.statistics.base;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 单元测试类
 */
public class BaseJudgeUnitTest {

    @Test
    public void largerThan_isRight(){
        BaseJudge baseJudge = new BaseJudge(5);
        boolean result = baseJudge.largerThanStandard(6);
        assertTrue(result);

        result = baseJudge.largerThanStandard(4);
        assertFalse(result);
    }
}
