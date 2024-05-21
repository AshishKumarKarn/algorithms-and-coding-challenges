package com.karn.leetcode;

import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        Arrays.sort(arr);
        System.out.println(new CombinationSum2().combinationSum2(arr, 30));
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        return solution(candidates, target,candidates.length-1,new ArrayList<>(), new LinkedList<>());
    }
    private List<List<Integer>> solution(int[] candidates, int target, int i, List<List<Integer>> result, LinkedList<Integer> subResult){
        if(target<0){
            return result;
        }
        if(target==0){
            result.add(subResult);
            return result;
        }
        if(i<0) return result;
        if(target>=candidates[i]){
            subResult.add(candidates[i]);
            solution(candidates, target-candidates[i],i-1,result, subResult);
            subResult.removeLast();//backtrack
            solution(candidates, target,i-1,result, subResult);
        }else{
            solution(candidates, target,i-1,result, subResult);
        }
        return result;
    }
}
