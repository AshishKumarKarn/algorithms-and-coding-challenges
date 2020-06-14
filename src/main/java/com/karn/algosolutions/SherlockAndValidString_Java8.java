package com.karn.algosolutions;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Ashish Karn
 * <p>
 * <b> sherlock and valid string solution in java </b>
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
public class SherlockAndValidString_Java8 {
    public static void main(String[] args) {
        System.out.println(isValid("abc"));
    }

    public static String isValid(String s) {
        Map<Long, Long> counts = s.chars()
                .mapToObj(t -> (char) t)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        switch (counts.size()) {
            case 1:
                return "YES";
            case 2:
                Iterator<Long> it = counts.keySet().iterator();
                return (Math.abs(it.next() - it.next()) == 1 && (counts.values().stream()
                        .anyMatch(i -> i == 1))) ? "YES" : "NO";
            default:
                return "NO";
        }
    }
}
