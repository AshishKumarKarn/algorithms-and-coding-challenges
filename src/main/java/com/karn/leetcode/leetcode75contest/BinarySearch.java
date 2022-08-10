package com.karn.leetcode.leetcode75contest;

public class BinarySearch {
    public int search(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }
    private int binarySearch(int[] nums,int start,int end,int target){
        if(end<start){
            return -1;
        }
        int mid=(end+start)/2;
        if(nums[mid]==target){
            return mid;
        }else if(nums[mid]>target){
            return binarySearch(nums,start,mid-1,target);
        }else{
            return binarySearch(nums,mid+1,end,target);
        }
    }
}
