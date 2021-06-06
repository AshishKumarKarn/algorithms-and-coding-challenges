package com.karn.leetcode;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{2, 11, 11, 15}, 22)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<String, Integer> indexMemory = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMemory.put(nums[i] + "-" + i, i);
        }
        Arrays.sort(nums);
        int[] solution = new int[2];
        for (int i = 0, j = nums.length - 1; i < j; ) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                solution[0] = nums[i];
                solution[1] = nums[j];
                break;
            }
            if (sum > target) {
                j--;
            }
            if (sum < target) {
                i++;
            }
        }
        System.out.println(indexMemory);
        ArrayList<Map.Entry<String, Integer>> arrayList = new ArrayList<>(indexMemory.entrySet());
        for (int i = 0; i < arrayList.size() ; i++) {
            if (arrayList.get(i).getKey().startsWith(solution[0] + "-")) {
                solution[0] = arrayList.get(i).getValue();
            }
        }
        for (int j = arrayList.size() - 1;  j >= 0;  j--) {
            if (arrayList.get(j).getKey().startsWith(solution[1] + "-")) {
                solution[1] = arrayList.get(j).getValue();
            }
        }
        return solution;
    }
}
