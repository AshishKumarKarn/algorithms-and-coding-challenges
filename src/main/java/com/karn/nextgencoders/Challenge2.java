package com.karn.nextgencoders;

import java.util.Arrays;

public class Challenge2 {
    public static void main(String[] args) {
        System.out.println(solve("Aishwarya","u"));
    }
    private static String solve(String str,String ch){
        int[] charArray = new int[128];
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            charArray[chars[i]]=charArray[chars[i]]+1;
        }
        int MAX = -1;
        int index=-1;
        for(int i = 0; i < chars.length; i++){
            if(charArray[chars[i]]>MAX){
                MAX=charArray[chars[i]];
                index=i;
            }
        }
        return str.replaceAll(String.valueOf(chars[index]),ch);
    }
}
