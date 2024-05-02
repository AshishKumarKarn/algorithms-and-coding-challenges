package com.karn.leetcode;

public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(10));
    }
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=1;
        dp[3]=2;
        dp[4]=4;

        int max = Integer.MIN_VALUE;
        for(int i=5;i<n+1;i++){
            for(int j=1;j*j<=i;j++){
                max = Math.max(max, i*(j));
            }
            dp[i]=max;
        }
        return dp[n];
    }
}
