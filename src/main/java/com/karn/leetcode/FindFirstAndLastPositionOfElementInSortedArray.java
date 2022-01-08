package com.karn.leetcode;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 2;//5,6
        //for (int target = 1; target < 24 ; target++) {
        System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray()
                .searchRange(nums, target)));
        //}

    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        }
        int found = binarySearch(nums, target, 0, nums.length - 1);
        int x = found, i = found, y = found, j = found;
        if (found > -1) {
            while (true) {
                if (i >= 0 && nums[i] == target) {
                    x = i;
                    i--;
                }
                if (j < nums.length && nums[j] == target) {
                    y = j;
                    j++;
                }
                if ((i < 0 || nums[i] < target) && (j >= nums.length || nums[j] > target)) {
                    break;
                }

            }
        }
        return new int[]{x, y};
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        if (right < left) {
            return -1;
        }
        int midIndex = (right + left) / 2;
        if (nums[midIndex] == target) {
            return midIndex;
        }
        if (target < nums[midIndex]) {
            //search in left side
            return binarySearch(nums, target, left, midIndex - 1);
        } else {
            return binarySearch(nums, target, midIndex + 1, right);
        }
    }
}
