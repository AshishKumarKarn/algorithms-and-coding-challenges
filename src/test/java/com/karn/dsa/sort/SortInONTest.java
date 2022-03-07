package com.karn.dsa.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortInONTest {

    SortInON object=new SortInON();
    @Test
    public void sortTest1() {
        int[] nums={17,22,24,9};
        object.sort(nums);
        int[] expected={9,17,22,24};
        Assert.assertArrayEquals(expected, nums);
    }
    @Test
    public void sortTest2() {
        int[] nums={0,1,17,9};
        object.sort(nums);
        int[] expected={0,1,9,17};
        Assert.assertArrayEquals(expected, nums);
    }
    @Test
    public void sortTest3() {
        int[] nums={0,4,3,2,1};
        object.sort(nums);
        int[] expected={0,1,2,3,4};
        Assert.assertArrayEquals(expected, nums);
    }
    @Test
    public void sortTest4() {
        int[] nums={256,243,222,1};
        object.sort(nums);
        int[] expected={1,222,243,256};
        Assert.assertArrayEquals(expected, nums);
    }
}