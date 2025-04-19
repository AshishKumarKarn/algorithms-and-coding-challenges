package com.karn.leetcode.lc1922;

public class Solution {
    int mod = (int) (1e9) + 7;

    public static void main(String[] args) {
        System.out.println(new Solution().countGoodNumbers(1));
    }

    public int countGoodNumbers(long n) {
        int oddCount = (int) ((n / 2) % mod);
        int evenCount = (int) ((n + 1) / 2);
        int oddMultiplier = 4;
        int evenMultiplier = 5;
        int oddResult = (int) (Math.pow(oddMultiplier, oddCount) % mod);
        int evenResult = (int) (Math.pow(evenMultiplier, evenCount) % mod);
        return (int) (((long) oddResult * evenResult) % mod);
    }
}
