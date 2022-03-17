package com.karn.leetcode;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = new int[]{2, 3};
        int amount = 7;
        int i = new CoinChange().coinChange(coins, amount);

        System.out.println(i);
    }


    public int coinChange(int[] coins, int amount) {
       if(amount==0) return 0;

       int[][] dp=new int[coins.length+1][amount+1];

        for (int i = 0; i <=coins.length ; i++) {
            for (int j = 0; j <= amount; j++) {
                if(i==0){
                    dp[i][j]=10_00000;
                }else if(j==0){
                    dp[i][j]=0;
                }else if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        return dp[coins.length][amount]==10_00000?-1:dp[coins.length][amount];
    }

}
