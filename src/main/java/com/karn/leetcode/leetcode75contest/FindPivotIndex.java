package com.karn.leetcode.leetcode75contest;

import java.util.Arrays;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum=0;
        int left=0;
        for (int num : nums) {
            sum += num;
        }
        int right = sum;
        for (int i = 0; i < nums.length; i++) {
            if(left==right-nums[i]){
                return i;
            }
            left += nums[i];
            right -= nums[i];
        }
        return -1;
    }
}
