package com.karn.leetcode.leetcode75contest;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {

        // [10,100,30,11,21,33]
        //from right to left
        //start from index 3 i.e. 11 check if you'd select 21 or 33 as these will land you to last stair
        //and keep decrementing by 1
        //[10,100,30,33,21,33] i at index 2
        //[10,100,51,33,21,33]
        //[10,133,51,33,21,33]
        //[61,133,51,33,21,33]
        //ans min(61,133)= 61

        for (int i = cost.length - 3; i >-1; i-- ) {
            cost[i] += Math.min(cost[i+1] , cost[i + 2]);
        }
        return Math.min(cost[0],cost[1]);
    }
}
