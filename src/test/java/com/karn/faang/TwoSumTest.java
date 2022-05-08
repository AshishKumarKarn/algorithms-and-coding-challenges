package com.karn.faang;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {

    private TwoSum twoSum = new TwoSum();

    @Test
    public void testCase1(){
        int[] input={1,3,7,5,2};
        int target = 9;
        int[] result = twoSum.twoSum(input,target);
        Assert.assertArrayEquals(new int[]{2,4}, result);
    }

}