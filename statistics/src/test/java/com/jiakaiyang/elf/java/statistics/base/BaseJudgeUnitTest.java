package com.jiakaiyang.elf.java.statistics.base;

import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * 单元测试类
 */
public class BaseJudgeUnitTest {

    /**
     * 针对原始类型以及string的测试
     */
    @Test
    public void largerThanPrimitive_isRight(){
        BaseJudge baseJudge = new BaseJudge<Integer>(5);
        boolean result = baseJudge.largerThanStandard(6);
        assertTrue(result);

        result = baseJudge.largerThanStandard(4);
        assertFalse(result);

        baseJudge = new BaseJudge<String>("b");
        result = baseJudge.largerThanStandard("c");
        assertTrue(result);

        result = baseJudge.largerThanStandard("a");
        assertFalse(result);

        baseJudge = new BaseJudge<String>("30");
        result = baseJudge.largerThanStandard("35");
        assertTrue(result);

        result = baseJudge.largerThanStandard("25");
        assertFalse(result);


        baseJudge = new BaseJudge<String>("30ab");
        result = baseJudge.largerThanStandard("35");
        assertTrue(result);

        result = baseJudge.largerThanStandard("30ac");
        assertTrue(result);

        result = baseJudge.largerThanStandard("30aa");
        assertFalse(result);
    }


    /**
     * 针对引用类型的测试
     */
    @Test
    public void largerThanInObj_isRight(){
        TestPersion john = new TestPersion("John", 17, "32");
        TestPersion paul = new TestPersion("Paul", 16, "32");
        TestPersion george = new TestPersion("George", 15, "32");
        TestPersion ringo = new TestPersion("Ringo", 16, "32");
        TestPersion martin = new TestPersion("Martin", 30, "32");

        Set<TestPersion> boys = new HashSet<TestPersion>();
        boys.add(john);
        boys.add(paul);
        boys.add(george);
        boys.add(ringo);

        TestBand theBeatles = new TestBand("The Beatles", 4, boys);

        BaseJudge baseJudge = new BaseJudge<TestPersion>(ringo, "age");
        boolean result = baseJudge.largerThanStandard(john);
        assertTrue(result);
        result = baseJudge.largerThanStandard(george);
        assertFalse(result);
        result = baseJudge.equalWithStandard(paul);
        assertTrue(result);

        baseJudge = new BaseJudge<TestPersion>(boys, "age");
        result = baseJudge.inStandard(paul);
        assertTrue(result);
        result = baseJudge.inStandard(martin);
        assertFalse(result);
    }

    class TestPersion{
        private String name;
        private int age;
        private String classCode;

        public TestPersion(String name, int age, String classCode) {
            this.name = name;
            this.age = age;
            this.classCode = classCode;
        }
    }

    class TestBand{
        private String name;
        private int count;
        private Collection<TestPersion> students;

        public TestBand(String name, int count, Collection<TestPersion> students) {
            this.name = name;
            this.count = count;
            this.students = students;
        }
    }
}
