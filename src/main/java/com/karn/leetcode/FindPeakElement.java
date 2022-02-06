package com.karn.leetcode;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums={1,9};
        System.out.println(new FindPeakElement().findPeakElement(nums));
    }
    public int findPeakElement(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        if(nums.length==1){
            return 0;
        }
        return findPeak(nums, 0, nums.length - 1);
    }

    private int findPeak(int[] nums, int i, int j) {
        if (i > j) {
            return -1;
        }
        if (i >= 0 && i <= nums.length - 1) {
            if (isPeak(nums, i)) {
                return i;
            }
        }
        if (j >= 0 && j <= nums.length - 1) {
            if (isPeak(nums, j)) {
                return j;
            }
        }
        int mid = (i + j) / 2;
        if (isPeak(nums, mid)) {
            return mid;
        }
        return Math.max(findPeak(nums, i, mid - 1), findPeak(nums, mid + 1, j));
    }

    private boolean isPeak(int[] nums, int i) {
        if(i>0&&i<nums.length-1){
            return nums[i] > nums[i - 1] && nums[i] > nums[i + 1];
        }else if(i==0){
            return nums[i] > nums[i + 1];
        }else if(i==nums.length-1){
            return nums[i] > nums[i - 1];
        }
        return false;
    }
}