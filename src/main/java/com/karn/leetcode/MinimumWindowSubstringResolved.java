package com.karn.leetcode;

import java.util.*;

public class MinimumWindowSubstringResolved {

    public static void main(String[] args) {
        MinimumWindowSubstringResolved instance = new MinimumWindowSubstringResolved();
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        System.out.println(instance.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        if(s.equals(t)) return s;
        int sLen = s.length();
        int tLen = t.length();
        String result = "";

        if (sLen < tLen) return result;

        int[] tArr = new int[58];//for both upper and lower case
        for (int i = 0; i < tLen; i++) {
            tArr[t.charAt(i)-'A']++;
        }
        int[] window = new int[58];
        for (int i = 0; i < tLen; i++) {
            window[s.charAt(i)-'A']++;
        }
        int i = 0;
        int j = tLen;
        int minLength = Integer.MAX_VALUE;
        outer: while(i<=(sLen-tLen)){
            while(!doesWindowContainAllChars(window, tArr)){
                if(j==sLen){
                    int cI = s.charAt(i)-'A';
                    window[cI]--;
                    while(i<(sLen-tLen)&&tArr[cI]==0){
                        i++;
                        cI = s.charAt(i)-'A';
                        window[cI]--;
                    }
                    if(i>=sLen-tLen) return result;
                    int temp = j;
                    j = i + tLen;
                    for (int k = j; k < temp ; k++) {
                        window[s.charAt(k)-'A']--;
                    }
                    if(!doesWindowContainAllChars(window, tArr)){
                        i++;
                        window[s.charAt(i)-'A']--;
                    }
                    continue outer;
                }
                window[s.charAt(j)-'A']++;
                j++;

            }
            if(doesWindowContainAllChars(window,tArr)){
                if(minLength>(j-i)){
                    minLength = (j-i);
                    result = s.substring(i,j);
                }
                window[s.charAt(i)-'A']--;
                i++;
            }else{
                int cI = s.charAt(i)-'A';
                window[cI]--;
                while(i<(sLen-tLen)&&tArr[cI]==0){
                    i++;
                    cI = s.charAt(i)-'A';
                    window[cI]--;
                }
                int temp = j;
                j=i+tLen;
                for (int k = j+1; k <= temp; k++) {
                    window[s.charAt(k)-'A']--;
                }
            }
        }
        return result;

    }

    private boolean doesWindowContainAllChars(int[] window, int[] tArr) {//constant time complexity
        for (int i = 0; i < 58; i++) {
            if(window[i]<tArr[i]){
                return false;
            }
        }
        return true;
    }


}
