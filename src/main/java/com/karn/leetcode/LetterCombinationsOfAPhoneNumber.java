package com.karn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("23"));
    }

    private static final String[] NUM_PAD = new String[10];

    static {
        NUM_PAD[2] = "abc";
        NUM_PAD[3] = "def";
        NUM_PAD[4] = "ghi";
        NUM_PAD[5] = "jkl";
        NUM_PAD[6] = "mno";
        NUM_PAD[7] = "pqrs";
        NUM_PAD[8] = "tuv";
        NUM_PAD[9] = "wxyz";
    }

    public List<String> letterCombinations(String digits) {
        List<String> stringList = new ArrayList<>();
        //base condition
        if (digits == null || digits.trim().length() == 0) return stringList;

        char[] chars = digits.toCharArray();
        for (char c : chars) {
            stringList.add(NUM_PAD[c - 48]);
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
            for (int i = 0; i < str1.length; i++) {
                for (int j = 0; j < str2.length; j++) {
                    for (int k = 0; k < str3.length; k++) {
                        for (int l = 0; l < str4.length; l++) {
                            result.add(str1[i] + str2[j] + str3[k] + str4[l]);
                        }
                    }
                }
            }
            return result;
        } else if (length == 3) {
            String[] str1 = stringList.get(0).split("");
            String[] str2 = stringList.get(1).split("");
            String[] str3 = stringList.get(2).split("");
            for (int i = 0; i < str1.length; i++) {
                for (int j = 0; j < str2.length; j++) {
                    for (int k = 0; k < str3.length; k++) {
                        result.add(str1[i] + str2[j] + str3[k]);
                    }
                }
            }
            return result;
        } else if (length == 2) {
            String[] str1 = stringList.get(0).split("");
            String[] str2 = stringList.get(1).split("");

            for (int i = 0; i < str1.length; i++) {
                for (int j = 0; j < str2.length; j++) {
                    result.add(str1[i] + str2[j]);
                }
            }
            return result;
        } else {
            return Arrays.asList(stringList.get(0).split("").clone());
        }
    }
}