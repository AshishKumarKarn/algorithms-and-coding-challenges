package com.karn.dsa.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeSortTest {
    MergeSort object = new MergeSort();


    @Test
    public void testMerge1() {
        int[] array = {1,4,3,2,5};
        object.mergeSort(array);
        int[] expected = {1,2,3,4,5};
        Assert.assertArrayEquals(expected,array);
    }
}