package com.karn.leetcode;


import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    Map<String, Integer> memory = new HashMap<>();

    public int rob(int[] nums) {
        return robMax(0,nums.length-1,nums);
    }

    private int robMax(int i, int j, int[] nums) {
        int result=0;
        if(i>j||i> nums.length-1||j<0){
            return result;
        }
        String key = i + "_" + j;
        if (memory.containsKey(key)) {
            return memory.get(key);
        }
        if(j-i==1){
            result = Math.max(nums[i],nums[j]);
            memory.put(key, result);
            return result;
        }
        if(j-i==0){
            result = nums[i];
            memory.put(key, result);
            return result;
        }
        result = Math.max(robMax(i,j-1,nums),nums[j]+robMax(i,j-2,nums));
        memory.put(key, result);
        return result;
    }

}
