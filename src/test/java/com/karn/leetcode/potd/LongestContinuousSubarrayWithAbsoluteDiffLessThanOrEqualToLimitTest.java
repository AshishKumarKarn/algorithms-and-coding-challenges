package com.karn.leetcode.potd;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimitTest {

    LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit obj = new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit();

    @Test
    public void test1() {
        int[] nums = {1,5,6,7,8,10,6,5,6};
        int limit = 4;
        assertEquals(5, obj.longestSubarray(nums, limit));
    }
    @Test
    public void test2() {
        int[] nums = {10,1,2,4,7,2};
        int limit = 5;
        assertEquals(4  , obj.longestSubarray(nums, limit));
    }
    @Test
    public void test3() {
        int[] nums = {24,12,71,33,5,87,10,11,3,58,2,97,97,36,32,35,15,80,24,45,38,9,22,21,33,68,22,85,35,83,92,38,59,90,42,64,61,15,4,40,50,44,54,25,34,14,33,94,66,27,78,56,3,29,3,51,19,5,93,21,58,91,65,87,55,70,29,81,89,67,58,29,68,84,4,51,87,74,42,85,81,55,8,95,39};
        int limit = 87;
        assertEquals(25  , obj.longestSubarray(nums, limit));
    }
}