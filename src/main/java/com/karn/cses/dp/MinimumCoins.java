package com.karn.cses.dp;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumCoins {

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

    public static void solution(int[] coins, int target) {
        int[][] dp = new int[coins.length+1][target+1];
        Arrays.fill(dp[0], MAX);
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.min(1 + dp[i][j-coins[i-1]],dp[i-1][j]);
                }
            }
        }

        if(dp[coins.length][target]>=MAX) {
            System.out.println(-1);
        }else {
            System.out.println(dp[coins.length][target]);
        }
    }
    private static final int MAX = 20000000;
/*
    static int[][] mem;
    private static int m = 1000000007;

    public static int solution(int[] coins, int target, int cursor) {
        if (target == 0) {
            return 0;
        }
        if(cursor == 0){
            if(target%coins[0]==0){
                return target/coins[0];
            }else{
                return MAX;
            }
        }


        if (cursor < 0 || target < 0) {
            return MAX;
        }
        if (mem[cursor][target] != -1) return mem[cursor][target];
        if (target >= coins[cursor]) {

            return mem[cursor][target] = (Math.min((1 + solution(coins, target - coins[cursor], cursor))%m,
                    (solution(coins, target, cursor - 1)%m)))%m;
        } else {
            return mem[cursor][target] = solution(coins, target, cursor - 1)%m;
        }
    }*/
}
