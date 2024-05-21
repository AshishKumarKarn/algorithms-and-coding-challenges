package com.karn.leetcode;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6};
        System.out.println(new CombinationSum().combinationSum(arr, 10));
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        return combinationSumSolver(candidates, target, candidates.length - 1, new ArrayList<>(), new LinkedList<>());
    }

    private List<List<Integer>> combinationSumSolver(int[] candidates, int target, int i, List<List<Integer>> results, LinkedList<Integer> subResult) {

        if (target < 0) {//backtrack
            subResult.removeLast();
            return results;
        }
        if (target == 0) {
            results.add(new LinkedList<>(subResult));
            return results;
        }
        if (i < 0) {
            return results;
        }
        if (candidates[i] <= target) {
            subResult.add(candidates[i]);
            combinationSumSolver(candidates, target - candidates[i], i , results, subResult);
            subResult.removeLast();
            combinationSumSolver(candidates, target, i - 1, results, subResult);

        } else {
            combinationSumSolver(candidates, target, i - 1, results, subResult);
        }
        return results;
    }
}
