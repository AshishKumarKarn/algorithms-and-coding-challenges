package com.karn.leetcode.leetcode75contest;

import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionSumIterativeTest {

    PartitionSumIterative partitionSumIterative = new PartitionSumIterative();
    @Test
    public void canPartition() {
        int[] arr={1,2,5};
        boolean res = partitionSumIterative.canPartition(arr);
        assertFalse(res);
    }
}