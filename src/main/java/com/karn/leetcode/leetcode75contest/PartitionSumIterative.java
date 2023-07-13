package com.karn.leetcode.leetcode75contest;

import java.util.Collections;
import java.util.stream.Stream;

public class PartitionSumIterative {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        dp = new int[target + 1][nums.length + 1];
        return canPartition(nums, target, nums.length);
    }

    private int[][] dp;

    //0 is not visited (defalut)
//1 is true
//2 is false
    public boolean canPartition(int[] nums, int target, int n) {


        for (int i = 0; i < target + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if(j==0){
                    dp[i][j]=2;
                }else if(i==0){
                    dp[i][j]=1;
                }
            }
        }
        //	dp[0][0]=1;
        for (int i = 1; i < target + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(nums[j-1]>i){
                    dp[i][j]=2;
                }else{
                    dp[i][j]=((dp[i][j-1]==1)||(dp[i-nums[j-1]][j]==1))?1:2;
                }
            }
        }
        return dp[target][n]==1;
    }
}
