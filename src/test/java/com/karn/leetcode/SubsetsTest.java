package com.karn.leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SubsetsTest {
    Subsets subsets  = new Subsets();

    @Test
    public void subsets() {
        int[] arr={1,2,3};
        List<List<Integer>> subsets1 = subsets.subsets(arr);
        System.out.println(subsets1);

    }
}