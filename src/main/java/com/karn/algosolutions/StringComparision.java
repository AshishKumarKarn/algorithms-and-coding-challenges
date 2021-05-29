package com.karn.algosolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringComparision {
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "ashishkumarkarnandprateekhedaandabhishekgupta";
        List<String> words = Arrays.asList(word1, word2);
        List<Integer> words_ints = new ArrayList<>();
        for (String word : words) {
            int length = word.length();
            int word_int = 0;
            for (int i = 0; i < length; ++i) {
                word_int |= (1 << (word.charAt(i) - 'a'));
            }
            words_ints.add(word_int);
            // System.out.printf("%s is word_int", Integer.toBinaryString(word_int));
            //  System.out.println();
        }
        for (int i = 0; i < words_ints.size() - 1; i++) {
            for (int j = i + 1; j < words_ints.size(); j++) {
                if ((words_ints.get(i) & words_ints.get(j)) != 0) {
                    System.out.println("common characters found");
                    return;
                }

            }
        }
        System.out.println("Common characters not found");
    }
}