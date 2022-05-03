package com.karn.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrappingRainWaterTest {

    TrappingRainWater trappingRainWater = new TrappingRainWater();

    @Test
    public void test1() {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Assert.assertEquals(6, trappingRainWater.trap(heights));
    }
    @Test
    public void test2() {
        int[] heights = {0, 1, };
        Assert.assertEquals(0, trappingRainWater.trap(heights));
    }
    @Test
    public void test3() {
        int[] heights = {2, 0, 2};
        Assert.assertEquals(2, trappingRainWater.trap(heights));
    }

    @Test
    public void test4() {
        int[] heights = {4, 2, 3};
        Assert.assertEquals(1, trappingRainWater.trap(heights));
    }


}