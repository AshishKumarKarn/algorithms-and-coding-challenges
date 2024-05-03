package com.karn.leetcode;

public class InterleavingStrings {
    public static void main(String[] args) {
        InterleavingStrings interleavingStrings = new InterleavingStrings();
        //should be true
        System.out.println(interleavingStrings.isInterleave("aabcc",
                "dbbca",
                "aadbbcbcac"));

        System.out.println(interleavingStrings.isInterleave("a",
                "",
                "a"));


                //should be false
        System.out.println(interleavingStrings.isInterleave("bcda",
                "abc",
                "adcbacb"));
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if((s1.length()+s2.length())!=s3.length()) return false;
        dp=new Boolean[s1.length()+1][s2.length()+1];
        return check(s1,s2,s3,s1.length()-1,s2.length()-1,s3.length()-1);
    }
    Boolean[][] dp;
    private boolean check(String s1, String s2, String s3,int l1,int l2, int l3){
        if(l1<0&&l2<0){
            return true;
        }

        if(l1<0){
            return s2.substring(0,l2+1).equals(s3.substring(0,l3+1));
        }
        if(l2<0){
            return s1.substring(0,l1+1).equals(s3.substring(0,l3+1));
        }
        if((l1==0&&l2==0)){
            return dp[l1][l2]=s3.charAt(0)==s1.charAt(0)||s3.charAt(0)==s2.charAt(0);
        }
        if(dp[l1][l2]!=null){
            return dp[l1][l2];
        }

        boolean secondCharMatching = s2.charAt(l2) == s3.charAt(l3);
        boolean firstCharMatching = s1.charAt(l1) == s3.charAt(l3);
        if(firstCharMatching && secondCharMatching){
            return dp[l1][l2]=check(s1,s2,s3,l1-1,l2,l3-1)||check(s1,s2,s3,l1,l2-1,l3-1);
        }
        if(firstCharMatching){
            return dp[l1][l2]=check(s1,s2,s3,l1-1,l2,l3-1);
        }
        if(secondCharMatching){
            return dp[l1][l2]=check(s1,s2,s3,l1,l2-1,l3-1);
        }

        return dp[l1][l2]=false;
    }
}
