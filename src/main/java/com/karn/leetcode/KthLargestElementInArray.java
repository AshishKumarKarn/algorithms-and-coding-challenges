package com.karn.leetcode;

import java.util.Arrays;

public class KthLargestElementInArray {

    public static void main(String[] args) {
        int[] arr={3,2,3,1,2,4,5,5,6};
        System.out.println(new KthLargestElementInArray().findKthLargest(arr,4));
    }
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            int h=1;
            if(k==1&&nums.length>0){
                return nums[nums.length-1];
            }
            if(k>nums.length){
                return -1;
            }
            for(int i=nums.length-1;i>0;i--){
                // System.out.println("Element is "+nums[i]);
                if(nums[i-1]<nums[i]){
                    h++;
                    // System.out.println("slope ");
                    if(h==k){
                        // System.out.println("done ");
                        return nums[i-1];
                    }
                }
            }
            return -1;
        }
}
