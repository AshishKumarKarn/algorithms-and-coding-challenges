package com.karn.leetcode.potd;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public int longestSubarray(int[] nums, int limit) {
        if (nums.length == 1) {
            return 1;
        }
        Map<Integer,Integer> map=null;
        Map<Integer,Integer> topTen =
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        int winMin;
        int winNextMinInd;
        int winMax;
        int max = 0;
        for (int i = 0; i < nums.length; ) {
            int j = i;
            winMin = winMax = nums[i];
            winNextMinInd = -1;
            while (j < nums.length) {
                if (winMin > nums[j]) {
                    winMin = nums[j];
                }
                if (winMax < nums[j]) {
                    winMax = nums[j];
                }
                if (winNextMinInd == -1 && nums[j] > nums[i]) {
                    winNextMinInd = j;
                }
                int diff = winMax - winMin;
                if (diff <= limit) {
                    max = Math.max(max, j - i + 1);
                    j++;
                } else {
                    break;
                }
            }
            if (j == nums.length) {
                break;
            } else if (winNextMinInd != -1) {
                i = winNextMinInd;
            } else {
                i++;
            }
        }
        return max;
    }
}
