package com.karn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums,0,result);
        return result;
    }

    private void permute(int[] nums, int index,List<List<Integer>> result){
        if(index>=nums.length){
            List<Integer> subResult=new ArrayList<>();
            for (int i:nums){
                subResult.add(i);
            }
            result.add(subResult);
        }
        for(int i=index;i<nums.length;i++){
            swap(nums,i,index);
            permute(nums,index+1,result);
            swap(nums,i,index);
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
