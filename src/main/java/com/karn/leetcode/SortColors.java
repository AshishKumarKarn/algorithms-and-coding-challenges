package com.karn.leetcode;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums=new int[]{0,1,2,0,1,2};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void sortColors(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[i]){
                    nums[j]=nums[i]+nums[j];
                    nums[i]=nums[j]-nums[i];
                    nums[j]=nums[j]-nums[i];
                }
            }
        }
    }
}
