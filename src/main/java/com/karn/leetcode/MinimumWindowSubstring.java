package com.karn.leetcode;

public class MinimumWindowSubstring {


    public String minWindow(String s, String t) {

        String result = "";
        if(t.length()>s.length()) return result;
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = t.length(); i < s.length()- t.length()+1; ) {
            String substring = s.substring(i, j);
             //System.out.println(substring);
            if (contains(substring, t)) {
                // System.out.println(substring);
                if (substring.length() < min) {
                    min = substring.length();
                    result = substring;
                }
                i++;
            } else {
                if(j < s.length()){
                    j++;
                }else{
                    i++;
                }
            }
        }
        return result;
    }

    //O(m+n)
    private boolean contains(String a, String b) {
        int[] aArr = new int[52];
        char[] aChars = a.toCharArray();
        for (char aChar : aChars) {
            int i = aChar - 'a';
            if (i < 0) {
                i = aChar - 'A' + 25;
            }
            aArr[i]++;

        }
        int[] bArr = new int[52];
        char[] bChars = b.toCharArray();
        for (char bChar : bChars) {
            int i = bChar - 'a';
            if (i < 0) {
                i = bChar - 'A' + 25;
            }

            bArr[i]++;

        }
        int count = 0;
        for (int i = 0; i < 52; i++) {
            if(aArr[i]>0&&bArr[i]>0&&aArr[i] >= bArr[i]){
                count+=bArr[i];
            }
        }
        return count == b.length();
    }
}
