package com.karn.algosolutions;

public class OpenText2 {
    public static void main(String[] args) {
        String str = "abccde";
        int[] cost = {012345};

        System.out.println(solution(str, cost));
    }

    private static int solution(String S, int[] C) {
        if (S.length() == 0) {
            return 0;
        }
        String[] strs = S.split("");
        String prChar = strs[0];
        int cost = 0;
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].equalsIgnoreCase(prChar)) {
                cost = cost + Math.min(C[i - 1], C[i]);
            }
        }
        return cost;
    }
}
