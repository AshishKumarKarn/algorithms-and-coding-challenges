package com.karn.leetcode.leetcode75contest;


import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            Integer existingCount = frequencyMap.getOrDefault(aChar, 0);
            frequencyMap.put(aChar, ++existingCount);
        }

        int maxOdd = 0;
        Character c = null;
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            Integer value = entry.getValue();
            if (value % 2 != 0 && value > maxOdd) {
                maxOdd = value;
                c = entry.getKey();
            }
        }
        frequencyMap.remove(c);
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            Integer value = entry.getValue();
            if (value % 2 == 0) {
                maxOdd += value;
            } else {
                maxOdd = maxOdd + value - 1;
            }
        }
        return maxOdd;
    }
}
