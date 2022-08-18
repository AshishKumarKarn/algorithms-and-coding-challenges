package com.karn.leetcode.leetcode75contest;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinCostClimbingStairsTest {
    MinCostClimbingStairs object =new MinCostClimbingStairs();
    @Test
    public void test1() {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        assertEquals(6, object.minCostClimbingStairs(cost));
    }
    @Test
    public void test2() {
        int[] cost = {0,0,1,1};
        assertEquals(1, object.minCostClimbingStairs(cost));
    }

    @Test
    public void test3() {
        int[] cost = {10,15,20};
        assertEquals(15, object.minCostClimbingStairs(cost));
    }
}