package com.karn.leetcode.leetcode75contest;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FindPivotIndexTest {
    FindPivotIndex object = new FindPivotIndex();

    @Test
    public void test1() {
        int[] input = {1,7,3,6,5,6};
        System.out.println(Arrays.toString(input));
        System.out.println(object.pivotIndex(input));
    }
    @Test
    public void test2() {
        int[] input = {2,1,-1};
        System.out.println(object.pivotIndex(input));
    }
    @Test
    public void test3() {
        int[] input = {1,1,1};
        System.out.println(object.pivotIndex(input));
    }
}