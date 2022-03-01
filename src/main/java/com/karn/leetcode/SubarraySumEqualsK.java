package com.karn.leetcode;

import java.util.*;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1, -1, 0};
        //[1,3,4,5,-1,5]
        //4

        //-1,0,1
        //[1,-1,0] [0] [1,-1]
        System.out.println(new SubarraySumEqualsK().subarraySum(nums, 0));
    }

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        Map<Integer, Integer> memory = new HashMap<>();
        memory.put(0, 1);
        for (int num : nums) {
            sum += num;
            //don't add element before querying for current required value
            if (memory.containsKey((sum - k))) {
                result += memory.get((sum - k));
            }
            Integer lastValue = memory.put(sum, 1);
            if (lastValue != null) {
                memory.put(sum, (1 + lastValue));
            }
        }
        return result;
    }
}
