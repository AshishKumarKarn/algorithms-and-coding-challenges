package com.karn.leetcode;

import java.util.*;

public class LongestConsecutiveSequence {

    private final Set<Integer> numSet=new HashSet<>();
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        for (int num : nums) {
            numSet.add(num);
        }
        int maxSeq=0;
        for (int num : nums) {
            //if the number is start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int size = 0;//value of current number
                while (numSet.contains(currentNum)){
                    size++;
                    currentNum++;
                }
                if(size>maxSeq){
                    maxSeq=size;
                }
            }
        }
        return maxSeq;
    }

}
