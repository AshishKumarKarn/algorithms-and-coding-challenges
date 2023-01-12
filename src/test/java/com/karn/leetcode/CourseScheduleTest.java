package com.karn.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class CourseScheduleTest {

    CourseSchedule cs=new CourseSchedule();
    @Test
    public void test1() {
        int[][] prerequisites={{0,1},{1,2},{0,2}};
        System.out.println(cs.canFinish(3,prerequisites));
    }
}