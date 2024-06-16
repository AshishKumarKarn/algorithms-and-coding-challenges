package com.karn.leetcode;

import java.util.Arrays;

//Leetcode 945
public class MinimumIncrementToMakeArrayUnique {


    //BRUTE FORCE
    public int minIncrementForUnique1(int[] nums) {
        int[] arr = new int[1_00_0000];
        int moves = 0;
        for (int num : nums) {
            while (arr[num] != 0) {
                num++;
                moves++;
            }
            arr[num] = 1;
        }
        return moves;
    }

    //SORTING
    public int minIncrementForUnique2(int[] nums) {
        int moves = 0;
        Arrays.sort(nums);
        for (int i = 0, j = 1; j < nums.length; i++, j++) {
            if (nums[i] - nums[j] >= 0) {
                int increment = (nums[i] - nums[j]) + 1;
                nums[j] += increment;
                moves += increment;
            }
        }
        return moves;
    }

    public int minIncrementForUnique(int[] nums) {
        int moves = 0;
        int max = 0;
        for (int i : nums) {
            max = Math.max(i, max);
        }
        int arrSize = max + 10_0001;
        int[] arr = new int[arrSize];
        for (int i : nums) {
            arr[i]++;
        }
        for (int i = 0; i < arrSize; i++) {
            if(arr[i]>1){
                int increment = arr[i]-1;
                arr[i+1] += increment;
                moves += increment;
            }
        }
        return moves;
    }
}
