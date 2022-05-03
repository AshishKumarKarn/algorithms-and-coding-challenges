package com.karn.youtube.onlinehowtocode;

public class CheckIfAnOriginalStringExistsGivenTwoEncodedStrings {
    public static void main(String[] args) {
        // int ch = 'z';
        // System.out.println(ch);
        //"112s"
        //"g841"
        System.out.println(new CheckIfAnOriginalStringExistsGivenTwoEncodedStrings()
                .possiblyEquals("i18n", "internationalization"));
    }

    public boolean possiblyEquals(String s1, String s2) {
        return dfs(s1.toCharArray(), s2.toCharArray(), 0, 0, 0, new Boolean[s1.length()+1][s2.length()+1][2001]);
    }

    private boolean dfs(char[] s1, char[] s2, int i, int j, int diff, Boolean[][][] dp) {
        if(i == s1.length && j == s2.length) {
            return diff == 0;
        }

        if(dp[i][j][diff+1000] != null)
            return dp[i][j][diff+1000];

        // if both i and j are at the same location and chars are same then simply increment both pointers
        if(i < s1.length && j < s2.length && diff == 0 && s1[i] == s2[j]) {
            if(dfs(s1, s2, i+1, j+1, diff, dp)) {
                return dp[i][j][diff+1000] = true;
            }
        }

        // if s1[i] is literal and diff > 0 then increment i and decrement diff by 1
        if(i < s1.length && !Character.isDigit(s1[i]) && diff > 0 && dfs(s1, s2, i+1, j, diff-1, dp)) {
            return dp[i][j][diff+1000] = true;
        }

        // if s2[j] is literal and diff < 0 then increment j and increment diff by 1
        // as we are done with the current jth char
        if(j < s2.length && !Character.isDigit(s2[j]) && diff < 0 && dfs(s1, s2, i, j+1, diff+1, dp)) {
            return dp[i][j][diff+1000] = true;
        }

        // wildcard matching in s1
        // if s1 contains l123
        // then need to check with val as 1 then val as 12 and val as 123
        //k<i+4 because, max diff can b i to i+3, see constraint 3
        for(int k = i, val = 0; k < i + 4 && k < s1.length && Character.isDigit(s1[k]); k++) {
            val = val * 10 + s1[k] -'0';
            if(dfs(s1, s2, k+1, j, diff-val, dp)) {
                return dp[i][j][diff+1000] = true;
            }
        }

        // wildcard matching in s2
        // if s2 contains l123
        // then need to check with val as 1 then val as 12 and val as 123
        for(int k = j, val = 0; k < j + 4 && k < s2.length && Character.isDigit(s2[k]); k++) {
            val = val * 10 + s2[k] -'0';
            if(dfs(s1, s2, i, k+1, diff+val, dp)) {
                return dp[i][j][diff+1000] = true;
            }
        }

        return dp[i][j][diff+1000] = false;
    }
}
