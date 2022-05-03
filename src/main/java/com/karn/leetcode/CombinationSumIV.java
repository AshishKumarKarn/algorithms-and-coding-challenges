package com.karn.leetcode;

import java.util.Arrays;

public class CombinationSumIV {

    public static void main(String[] args) {
        int[] nums={1,2,3};
        int target=4;
        System.out.println(new CombinationSumIV().combinationSum4(nums,target));
     //   System.out.println(Arrays.deepToString(dp));
    }
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        dp[0]=1;
        for (int i = 0; i < nums.length; i++) {
            dp[i]=nums[i];
        }
        for (int i = nums.length-1; i <= target; i++) {
            dp[i]+=sumNums(nums,dp,i);
        }
        return dp[target];
    }

    private int sumNums(int[] nums, int[] dp,int i) {
        return Arrays.stream(nums).map(a->dp[i-a]).sum();
    }
}
