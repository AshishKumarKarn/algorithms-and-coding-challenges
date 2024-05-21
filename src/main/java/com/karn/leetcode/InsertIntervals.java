package com.karn.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{0, 5}, {8, 9}};
        int[] newIntervals = {3, 4};
        System.out.println(Arrays.deepToString(new InsertIntervals().insert(intervals, newIntervals)));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();
        if (intervals.length == 0) {
            result.add(newInterval);
            return result.toArray(new int[][]{});
        }
        int[] sums = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int sum = intervals[i][0] + intervals[i][1];
            sums[i] = sum;
        }
        int newSum = newInterval[0] + newInterval[1];
        int index = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (newSum >= sums[i]) {
                index = i + 1;
            }
        }
        for (int i = 0; i < intervals.length; i++) {
            if (i == index) {
                result.add(newInterval);
            }
            result.add(intervals[i]);
        }
        return result.toArray(new int[][]{});
    }

}
