package com.karn.leetcode;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
//        [4,5,6,7,0,1,2]
//        0
//                [4,5,6,7,0,1,2]
//        3[4,5,6,7,8,1,2,3]
//8
//                [1]
//        0
        int[] nums = {4,5,6,7,8,1,2,3};
        int target = 8;
        System.out.println(new SearchInRotatedSortedArray().search(nums, target));
    }

    public int search(int[] nums, int target) {
        return binarySearchAdvanced(0, nums.length - 1, nums, target);
    }

    private int binarySearchAdvanced(int i, int j, int[] nums, int target) {
        if (i > j) {
            return -1;
        }
        if (nums[i] == target) {
            return i;
        }
        if (nums[j] == target) {
            return j;
        }

        int mid = (i + j) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        //search right half
        return Math.max(binarySearchAdvanced(mid + 1, j, nums, target), binarySearchAdvanced(i, mid - 1, nums, target));
    }
}