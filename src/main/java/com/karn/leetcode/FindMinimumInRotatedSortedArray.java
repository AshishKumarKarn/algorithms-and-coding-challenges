package com.karn.leetcode;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums={4,5,1,2,3};
        System.out.println(new FindMinimumInRotatedSortedArray()
        .findMin(nums));
    }
    public int findMin(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int min = Integer.MAX_VALUE;

    private int binarySearch(int[] nums, int i, int j) {
        if (i > j) {
            return min;
        }
        if (nums[i] < min) {
            min = nums[i];
        }
        if (nums[j] < min) {
            min = nums[i];
        }
        int mid = (i + j) / 2;
        if (nums[mid] < min) {
            min = nums[mid];
        }
        int result = Math.min(binarySearch(nums, i, mid - 1), binarySearch(nums, mid + 1, j));
        if (result < min) {
            min = result;
        }
        return min;
    }
}
