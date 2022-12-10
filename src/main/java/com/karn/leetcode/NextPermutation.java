package com.karn.leetcode;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        boolean slopeFound = false;
        int changeFromIndex = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                slopeFound = true;
                changeFromIndex = i;
                break;
            }
        }
        if (slopeFound) {
            findMinAndSwapElements(changeFromIndex, nums);
            int[] rightArray = new int[nums.length - (changeFromIndex)];

            for (int i = changeFromIndex, j = 0; i < nums.length; i++, j++) {
                rightArray[j] = nums[i];
            }
            Arrays.sort(rightArray);
            for (int i = changeFromIndex, j = 0; i < nums.length; i++, j++) {
                nums[i] = rightArray[j];
            }
        } else {
            Arrays.sort(nums);
        }

    }

    private void findMinAndSwapElements(int ind, int[] nums) {
        int minLimit = nums[ind - 1];
        int min = Integer.MAX_VALUE;
        int j = 0;
        for (int i = ind; i < nums.length; i++) {
            if (nums[i] > minLimit && nums[i] < min) {
                min = nums[i];
                j = i;
            }
        }
        int temp = nums[j];
        nums[ind - 1] = temp;
        nums[j] = minLimit;
    }
}