package com.karn.leetcode;

import java.util.Arrays;

public class _3SumClosest {
    public static void main(String[] args) {
        int[] nums = {0,0,0};
        System.out.println(threeSumClosest(nums, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int diff, result = target;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int currentSum = (nums[i] + nums[j] + nums[k]);
                diff = (target - currentSum) >= 0 ?
                        (target - currentSum) :
                        (currentSum - target);
                if (target > currentSum) {
                    j++;
                } else {
                    k--;
                }
                if (min > diff) {
                    min = diff;
                    result = currentSum;
                    if (diff == 0) {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
