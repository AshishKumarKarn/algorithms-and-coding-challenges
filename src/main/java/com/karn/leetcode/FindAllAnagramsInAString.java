package com.karn.leetcode;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindAllAnagramsInAString {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new FileInputStream("findAllAnagrams.txt"));
        String s = sc.next();
        String p = sc.next();
        long startTime = System.currentTimeMillis();
        System.out.println(new FindAllAnagramsInAString()
                .findAnagrams(s, p));
        System.out.printf("time taken is %s ms", System.currentTimeMillis() - startTime);
    }

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        char[] chars = p.toCharArray();
        Arrays.sort(chars);
        boolean areAanagram = false;
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            if (areAanagram) {
                if (s.charAt(i-1) == s.charAt(i+p.length()-1)) {
                    result.add(i);
                } else {
                    areAanagram = false;
                }
                continue;
            }
            areAanagram = areAanagram(s.substring(i, i + p.length()), chars);
            if (areAanagram) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean areAanagram(String substring, char[] p) {
        if (substring.length() != p.length) {
            return false;
        }
        char[] chars = substring.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length; i++) {
            if (p[i] != chars[i]) {
                return false;
            }
        }
        return true;
    }
}
