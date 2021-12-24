package com.karn.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParenthesis_22 {
    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis_22().generateParenthesis(4));
    }

    private static final String LEFT = "(";
    private static final String RIGHT = ")";

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            return Collections.singletonList(LEFT + RIGHT);
        }
        return generateCompleteParenthesis(n);
    }

    private List<String> generateCompleteParenthesis(int n) {
        List<String> result=new ArrayList<>();
        StringBuilder sb=new StringBuilder(LEFT);
        int mobileParenthesis=((2*n)-2);
        for (int i = 0; i < mobileParenthesis; i++) {
                sb.append(LEFT);
        }
        sb.append(RIGHT);
        result.add(sb.toString());

        return null;

    }
}
