package com.karn.algosolutions;

public class FindIfStringHasOnlyUniqueCharacters {
    public static void main(String[] args) {
        System.out.println(isUnique("Ajhis"));
    }
    private static boolean isUnique(String str){
        boolean[] chars=new boolean[128];
        char[] charsArray = str.toCharArray();
        for (int i = 0; i < charsArray.length; i++) {
            if(chars[charsArray[i]]){
                return false;
            }
            chars[charsArray[i]] = true;
        }
        return true;
    }
}
