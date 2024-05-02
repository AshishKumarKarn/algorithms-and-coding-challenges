package com.karn.cses.dp;

import java.util.Scanner;

public class CoinCombination1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int target = sc.nextInt();
            int[] coins = new int[n];
            for (int i = 0; i < n; i++) {
                coins[i] = sc.nextInt();
            }
            solution(coins, target);
        }
    }
    private static int m = 1000000007;

    private static void solution(int[] coins, int target) {
        int[] dp=new int[target+1];

        dp[0]=1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j]<=i){
                    dp[i]=(dp[i]+dp[i-coins[j]])%m;
                }
            }
        }
        System.out.println(dp[target]);
    }

}
