package com.karn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Todo unresolved
public class WordBreakII {

    public static void main(String[] args) {
        List<String> strings = new WordBreakII().wordBreak("pineapplepenapple", Arrays
                .asList("apple", "pen", "applepen", "pine", "pineapple"));
        System.out.println(strings);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakSolver(s, wordDict, 0,0, new StringBuilder(), new ArrayList<>());
    }

    private List<String> wordBreakSolver(String s, List<String> wordDict, int i,int c, StringBuilder builder, List<String> list) {

        if (c == s.length()) {
            if(i==0) {
                list.add(builder.toString().trim());
            }
            return list;
        }
        for (int j = c; j < s.length(); j++) {
            String word = s.substring(c, j+1);
            if (wordDict.contains(word)) {
                builder.append(word);
                builder.append(" ");
                wordBreakSolver(s, wordDict,c, j+1, builder, list);
            }
        }


        return list;
    }
}
