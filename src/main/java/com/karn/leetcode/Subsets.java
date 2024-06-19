package com.karn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int mask = 0; mask < (1<<nums.length); mask++) {
            List<Integer> subArr = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if((mask&(1<<j))>0){
                    subArr.add(nums[j]);
                }
            }
            result.add(subArr);
        }
        return result;
    }
}
