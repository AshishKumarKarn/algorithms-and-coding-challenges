package com.karn.algosolutions;

import java.util.Arrays;
//TODO: UNRESOLVED
public class SumAndTarget {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 6, 9, 5};
        int target = 3;
        boolean solution = findSumEqualsTarget(target, arr, arr.length - 1,false);
        System.out.println((solution));
    }

    private static boolean findSumEqualsTarget(int target, int[] arr, int i,boolean solution) {
        if (i < 0) {
            return solution;
        }
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return solution;
        }
        boolean solutionf=false;
        if (arr[i] > target) {
            solutionf = findSumEqualsTarget(target, arr, i - 1, solution);
        }
        solutionf= findSumEqualsTarget(target - arr[i], arr, i-1, solution)
                || findSumEqualsTarget(target, arr, i - 1, solution);
        return solutionf;
    }
}
