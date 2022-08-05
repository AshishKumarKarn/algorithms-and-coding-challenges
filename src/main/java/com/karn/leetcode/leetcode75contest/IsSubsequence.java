package com.karn.leetcode.leetcode75contest;

import java.util.HashSet;
import java.util.Set;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        Set<Character> tchars = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            tchars.add(t.charAt(i));
        }
        for (int i = 0, j = 0; i < s.length(); i++) {
            char search = s.charAt(i);
            if (!tchars.contains(search)) {
                return false;
            }
            while (j < t.length() && search != t.charAt(j)) {
                j++;
            }
            if (j == t.length()) {
                return false;
            }
            j++;
        }
        return true;
    }
}
