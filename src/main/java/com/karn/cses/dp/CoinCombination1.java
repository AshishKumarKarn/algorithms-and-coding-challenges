package com.karn.cses.dp;

import java.util.Arrays;
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

    private static void solution(int[] coins, int target) {
        int[][] dp=new int[coins.length+1][target+1];

        for (int j = 0; j < target+1; j++) {
            dp[0][j]=MAX;
        }
        for (int i = 0; i < coins.length + 1; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i < coins.length+1; i++) {
            for (int j = 1; j < target+1; j++) {
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    int result;
                    if((dp[i][j-coins[i-1]])>=MAX&&(dp[i-1][j]>=MAX)){
                        result = MAX;
                    }else if((dp[i][j-coins[i-1]])>=MAX){
                        result = dp[i-1][j];
                    }else if((dp[i-1][j]>=MAX)){
                        result = dp[i][j-coins[i-1]];
                    }else{
                        result = dp[i][j-coins[i-1]] + dp[i-1][j];
                    }
                    dp[i][j] = result;
                }
            }
        }
        boolean found = dp[coins.length][target] < MAX;
        if(found) {
            System.out.println((int)Math.pow(2,dp[coins.length][target]));
        }else{
            System.out.println(-1);
        }
    }
    private static final int MAX = 100000000;
}
