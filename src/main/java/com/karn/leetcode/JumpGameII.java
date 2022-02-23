package com.karn.leetcode;

import java.util.Arrays;

public class JumpGameII {

    public int jump(int[] nums) {
        if(nums.length<=1){
            return 0;
        }

        memory = new int[nums.length];
        int result = checkMinJump(nums,0, 0, 0);
        System.out.println(Arrays.toString(memory));
        return result;
    }

    private int[] memory;
    private int checkMinJump(int[] nums,int previousPosition, int currentPosition, int previousJump) {

        //reached final position, calculate jump diff and add with previousJump
        if(currentPosition == nums.length-1){
            //memory[previousPosition] = previousJump;
            return previousJump;
        }
        if(memory[currentPosition]!=0){
            return memory[currentPosition];
        }

        //if current pos val = 0, it's not possible to move forward from here
        if(nums[currentPosition]==0){
            return Integer.MAX_VALUE;
        }

        int jump = nums[currentPosition];
        int range = Math.min((currentPosition + jump), nums.length-1);
        int min = Integer.MAX_VALUE;
        for (int i = range; i > currentPosition ; i--) {
            int minJump = checkMinJump(nums, currentPosition, i, 1+previousJump);
            if(minJump<min){
                min = minJump;
            }
        }
        memory[currentPosition] = min;
        return min;
    }
}
