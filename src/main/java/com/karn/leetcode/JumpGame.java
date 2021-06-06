package com.karn.leetcode;

import java.util.HashMap;
import java.util.Map;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{2,3,1,1,4}));
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        return canJump(nums, 0, nums.length - 1);
    }

    private final Map<String, Integer> memory = new HashMap<>();

    private boolean canJump(int[] nums, int currentPosition, int target) {
        if (memory.get("Found") != null) {
            return true;
        }
        if (currentPosition == target) {
            memory.put("Found", 1);
            return true;
        }
        if (currentPosition > target) {
            return false;
        }
        if (nums[currentPosition] == 0) {
            return false;
        }
        int pos;
        for (int i = nums[currentPosition]; i > 0; --i) {
            if (nums[currentPosition] >= (target - currentPosition)) {
                pos = target;
            } else {
                pos = currentPosition + i;
            }
            if (canJump(nums, pos, target)) {
                return true;
            }
        }
        return false;
    }
}