package com.karn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("23"));
    }

    private static Map<Integer, String> numPad = new HashMap<>();

    static {
        numPad.put(2, "abc");
        numPad.put(3, "def");
        numPad.put(4, "ghi");
        numPad.put(5, "jkl");
        numPad.put(6, "mno");
        numPad.put(7, "pqrs");
        numPad.put(8, "tuv");
        numPad.put(9, "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> stringList = new ArrayList<>();
        //base condition
        if (digits == null || digits.trim().length() == 0) return stringList;

        char[] chars = digits.toCharArray();
        for (char c : chars) {
            stringList.add(numPad.get(c - 48));
        }

        List<String> result = new ArrayList<>();
        int length = digits.length();
        //abc-> def=> ad bd cd ae be de af bf cf===9
        //abc-> def-> ghi => adg adh adi bdg bdh bdi cdg cdh cdi aeg aeh aei beg
        //beh bei ceg ceh cei afg afh afi bfg bfh bfi cfg cfh cfi===27
        if (length == 4) {
            String[] str1 = stringList.get(0).split("");
            String[] str2 = stringList.get(1).split("");
            String[] str3 = stringList.get(2).split("");
            String[] str4 = stringList.get(3).split("");
            for (String element : str1) {
                for (String item : str2) {
                    for (String value : str3) {
                        for (String s : str4) {
                            result.add(element + item + value + s);
                        }
                    }
                }
            }

        } else if (length == 3) {
            String[] str1 = stringList.get(0).split("");
            String[] str2 = stringList.get(1).split("");
            String[] str3 = stringList.get(2).split("");
            for (String s : str1) {
                for (String value : str2) {
                    for (String item : str3) {
                        result.add(s + value + item);
                    }
                }
            }

        } else if (length == 2) {
            String[] str1 = stringList.get(0).split("");
            String[] str2 = stringList.get(1).split("");

            for (String s : str1) {
                for (String value : str2) {
                    result.add(s + value);
                }
            }
        } else if (length == 1) {
            String str = stringList.get(0);
            result = Arrays.asList(str.split("").clone());
        }
        return result;
    }
}
