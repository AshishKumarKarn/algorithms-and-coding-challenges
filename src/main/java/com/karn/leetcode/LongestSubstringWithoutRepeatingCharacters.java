package com.karn.leetcode;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters()
                .lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int length1 = s.length();
        if (length1 < 2) {
            return length1;
        }
        int maxSize = 0;
        StringBuilder sb = new StringBuilder(String.valueOf(s.charAt(0)));
        for (int i = 1; i < length1; i++) {
            if (sb.toString().contains(String.valueOf(s.charAt(i)))) {
                sb = new StringBuilder(sb.substring(sb.toString().indexOf(String.valueOf(s.charAt(i))) + 1));
            }
            maxSize = Math.max(sb.append(s.charAt(i)).length(), maxSize);
        }
        return maxSize;
    }
}
