package com.karn.algosolutions;

import java.util.*;

/**
 * @author Ashish Karn
 * <p>
 * Sherlock considers a string to be valid if all characters of the string appear
 * the same number of times. It is also valid if he can remove just 1 character at
 * 1 index in the string, and the remaining characters will occur the same number of
 * times. Given a string s , determine if it is valid. If so, return YES, otherwise
 * return NO.
 * <p>
 * Input - aabbccddeefghi
 * Output - NO
 * Input - abcdefghhgfedecba
 * Output - YES
 * Input - abc
 * Output - YES
 * Input - abcdde
 * Output - YES
 * Input - abcddee
 * Output - No
 */
public class SherlockAndValidString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isValid(s));
    }

    private static String isValid(String s) {
        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        map = GetFrequencyOfCharacters.getFrequencyOfCharacters(charArray, map);
        Collection<Integer> values = map.values();
        Set<Integer> set = new HashSet<>();
        for (Integer value : values) {
            set.add(value);
        }
        Integer[] val = set.toArray(new Integer[0]);
        if (set.size() > 2) {
            return "NO";
        } else if (set.size() == 2) {
            int a = Collections.frequency(values, val[0]);
            int b = Collections.frequency(values, val[1]);
            if (a > 1 && b > 1) {
                return "NO";
            }
            return "YES";
        } else {
            return "YES";
        }
    }
}