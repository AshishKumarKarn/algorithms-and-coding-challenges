package com.karn.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BurstBalloons_312 {

    public int maxCoins(int[] nums) {
        memoization = new HashMap<>(nums.length+1,1);
        return maxCoins(nums, 0);
    }

    private Map<String, Integer> memoization;

    public int maxCoins(int[] nums, int result) {
        String key = Arrays.toString(nums);
        Integer sol = memoization.get(key);
        if (sol != null) {
            return sol;
        }
        if (nums.length == 2) {
            sol = result + (nums[0] * nums[1]) + Math.max(nums[0], nums[1]);
            memoization.put(key, sol);
            return sol;
        }
        if (nums.length == 1) {
            sol = nums[0];
            return sol;
        }
        if (nums.length == 0) {
            return result;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int[] arr = new int[nums.length - 1];
            for (int k = 0, j = 0; k < nums.length; k++) {
                if (k != i) {
                    arr[j] = nums[k];
                    j++;
                }
            }
            Integer maxCoins = memoization.get(Arrays.toString(arr));
            if(maxCoins==null){
                maxCoins = maxCoins(arr, 0);
                memoization.put(Arrays.toString(arr), maxCoins);
            }
            if (i == 0) {
                sol = ((nums[0] * nums[1])) + maxCoins;
            } else if (i == nums.length - 1) {
                sol = (nums[nums.length - 2] * nums[nums.length - 1]) + maxCoins;
            } else {
                sol = (nums[i - 1] * nums[i] * nums[i + 1]) + maxCoins;
            }
            if (sol > max) {
                max = sol;
            }
        }
        memoization.put(key, max);
        return max;
    }
}
