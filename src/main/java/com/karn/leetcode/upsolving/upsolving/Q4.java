package com.karn.leetcode.upsolving.upsolving;

import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/total-characters-in-string-after-transformations-ii/description/
public class Q4 {
    private static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
        System.out.println(new Q4().lengthAfterTransformations("azbk",25, list));//134217728
    }
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[] count = new long[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        long[][] dp = new long[count.length][count.length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = i + nums.get(i); j > i; j--) {
                dp[i][j % dp.length]++;
            }
        }

        for (int i = 1; i <= t; i <<= 1) {
            if ((t & i) != 0) { // transform
                long[] next = new long[count.length];
                for (int a = 0; a < count.length; a++) {
                    if (count[a] <= 0) {
                        continue;
                    }
                    for (int b = 0; b < count.length; b++) {
                        next[b] = (next[b] + count[a] * dp[a][b]) % MOD;
                    }
                }
                count = next;
            }


            long[][] next = new long[dp.length][dp.length];
            for (int a = 0; a < dp.length; a++) {
                for (int b = 0; b < dp.length; b++) {
                    if (dp[a][b] <= 0) {
                        continue;
                    }
                    for (int c = 0; c < dp.length; c++) {
                        next[a][c] = (next[a][c] + dp[a][b] * dp[b][c]) % MOD;
                    }
                }
            }
            dp = next;
        }

        long res = 0;
        for (long i : count) {
            res += i;
        }
        return (int) (res % MOD);
    }
}
