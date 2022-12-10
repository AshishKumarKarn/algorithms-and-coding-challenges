package com.karn.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class NextPermutationTest {

    NextPermutation instance=new NextPermutation();
    @Test
    public void test1() {
        int[] array={1,4,6,6,3,2};
        instance.nextPermutation(array);
        System.out.println(Arrays.toString(array));
    }
}