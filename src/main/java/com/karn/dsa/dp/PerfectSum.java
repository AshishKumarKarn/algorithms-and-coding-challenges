package com.karn.dsa.dp;

public class PerfectSum {
    static int mod = 1000000007;

    public int perfectSum(int arr[], int n, int sum) {


        //System.out.println(zeros+" & init is"+init);
        int[][] dp = new int[n][sum + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    if (j == 0 && arr[0] == 0) {
                        dp[i][j] = 2;
                    } else if (j == 0 || j == arr[0]) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    int nt = dp[i - 1][j];
                    int t = 0;
                    if (arr[i] <= j) {
                        t = dp[i - 1][j - arr[i]];
                    }
                    dp[i][j] = (nt + t) % mod;
                }
            }
        }
        return dp[n - 1][sum];
    }
}
