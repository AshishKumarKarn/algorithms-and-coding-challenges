package com.karn.leetcode.leetcode75contest;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = cost.length - 3; i >-1; i-- ) {
            cost[i] += Math.min(cost[i+1] , cost[i + 2]);
        }
        return Math.min(cost[0],cost[1]);
    }
}