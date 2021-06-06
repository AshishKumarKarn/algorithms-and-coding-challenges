package com.karn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _3Sum {
    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        System.out.println(new _3Sum().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        //nlog(n)
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        //n^2
        Map<String, String> memory = new HashMap<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> solution = new ArrayList<>(3);
                    solution.add(nums[i]);
                    solution.add(nums[j]);
                    solution.add(nums[k]);
                    //i,j,k are already sorted, so no need to re-sort to make key unique
                    if (memory.put(solution.toString(), "value") == null) {
                        result.add(solution);
                    }
                    j++;
                }
                if ((nums[i] + nums[j] + nums[k]) < 0) {
                    j++;
                } else {
                    --k;
                }
            }
        }

        return result;
    }
}
