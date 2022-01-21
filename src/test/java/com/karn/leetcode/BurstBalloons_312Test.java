package com.karn.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class BurstBalloons_312Test {

    private BurstBalloons_312 burstBalloons = new BurstBalloons_312();
    @Test
    public void testCase1() {
        int[] nums = {3,1,5,8};
        Assert.assertEquals(167,burstBalloons.maxCoins(nums));
    }
    @Test
    public void testCase2() {
        int[] nums = {1,2};
        Assert.assertEquals(4,burstBalloons.maxCoins(nums));
    }
    @Test
    public void testCase3() {
        int[] nums = {3,1,2};
        Assert.assertEquals(15,burstBalloons.maxCoins(nums));
    }
    @Test
    public void testCase4() {
        int[] nums = {9};
        Assert.assertEquals(9,burstBalloons.maxCoins(nums));
    }
    @Test
    public void testCase5() {
        int[] nums = {9,76,64,21,97,60};
        Assert.assertEquals(1086136,burstBalloons.maxCoins(nums));
    }
    @Test
    public void testCase6() {
        int[] nums = {1,1,1,1};
        Assert.assertEquals(4,burstBalloons.maxCoins(nums));
    }
    @Test
    public void testCase7() {
        int[] nums = {35,16,83,87,84,59,48,41};
        Assert.assertEquals(1583373,burstBalloons.maxCoins(nums));
    }

    @Test
    public void testCase8() {
        int[] nums = {3,2,7,5,4};
        Assert.assertEquals(282,burstBalloons.maxCoins(nums));
    }


    @Test
    public void testCase9() {
        int[] nums = {2,7,8,5};
        Assert.assertEquals(365,burstBalloons.maxCoins(nums));
    }

    @Test
    public void testCase10() {
        int[] nums = {2,7,8};
        Assert.assertEquals(136,burstBalloons.maxCoins(nums));
    }

    @Test
    public void testCase11() {
        long startTime = System.currentTimeMillis();
        int[] nums = {8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2,5};
        Assert.assertEquals(3630,burstBalloons.maxCoins(nums));
        System.out.println(System.currentTimeMillis()-startTime);
    }

    @Test
    public void testCase12() {
        int[] nums = {8,0,1};
        Assert.assertEquals(16,burstBalloons.maxCoins(nums));
    }
//    @Test
//    public void testCase13() {
//        long startTime = System.currentTimeMillis();
//        int[] nums = {8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2,5,8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2,5};
//        Assert.assertEquals(3630,burstBalloons.maxCoins(nums));
//        System.out.println(System.currentTimeMillis()-startTime);
//    }
}