package com.karn.leetcode;

public class PrintLCS {
    public static void main(String[] args) {
        String s1="acbcf";
        String s2="abcdaf";
        System.out.println(printLCS(s1,s2));
    }

    public static String printLCS(String s1,String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp=new int[m+1][n+1];
        for (int i = 1; i < m+1 ; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println("LCS LENGTH >> "+dp[m][n]);

        //printing
        StringBuilder sb=new StringBuilder();
        int i=m,j=n;
        while(i>0&&j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;j--;
            }else{
                if(dp[i-1][j]>dp[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }

        return sb.reverse().toString();
    }
}
