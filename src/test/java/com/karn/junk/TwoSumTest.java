package com.karn.junk;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumTest {

    private final TwoSum instance = new TwoSum();
    @Test
    public void test1 () {
        int[] array={2,3,4,19,8,10};
        int target = 11;
        assertArrayEquals(new int[]{1,4}, instance.twoSum(array, target));
    }
    @Test
    public void test2 () {
        int[] array={2,3,4,19,8,10};
        int target = 29;
        assertArrayEquals(new int[]{3,5}, instance.twoSum(array, target));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test3 () {
        int[] array={2,3,4,19,8,10};
        int target = 39;
        instance.twoSum(array, target);
    }

}