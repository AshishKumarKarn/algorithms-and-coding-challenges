package com.karn.leetcode;

import java.util.Date;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new Date().getTime()-24*60*60*1000);

        //System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));
    }
    public int longestPalindrome(String s) {
        int maxLength = 1;
        for(int i=0;i<s.length();i++){
            int len1 = calculatePalindromeOdd(s,i);
            int len2 = calculatePalindromeEven(s,i);
            maxLength = Math.max(Math.max(len1,len2), maxLength);

        }
        return maxLength;
    }
    private int calculatePalindromeOdd(String s, int i){
        int len=0;
        int l=i,r=i;
        while(l>=0&&r<s.length()){
            if(s.charAt(l)!=s.charAt(r)){
                break;
            }
            if(l==r){
                len++;
            }else{
                len+=2;
            }

            l--;
            r++;
        }
        return len;
    }
    private int calculatePalindromeEven(String s, int i){
        int len=0;
        int l=i,r=i+1;
        while(l>=0&&r<s.length()){
            if(s.charAt(l)!=s.charAt(r)){
                break;
            }
            len+=2;
            l--;
            r++;
        }
        return len;
    }
}
