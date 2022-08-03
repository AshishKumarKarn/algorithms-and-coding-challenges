package com.karn.leetcode.leetcode75contest;

import java.util.Arrays;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int suffixSum=0;
        int prefixSum=0;
        for (int num : nums) {
            suffixSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if(prefixSum==suffixSum-nums[i]){
                return i;
            }
            prefixSum += nums[i];
            suffixSum -= nums[i];
        }
        return -1;
    }
}
