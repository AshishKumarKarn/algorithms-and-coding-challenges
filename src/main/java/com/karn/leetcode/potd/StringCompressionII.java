package com.karn.leetcode.potd;

public class StringCompressionII {

    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        char prev = word.charAt(0);
        int count = 1;
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)==prev&&count<9){
                count++;
            }else{
                comp.append(count).append(prev);
                prev = word.charAt(i);
                count=1;
            }
        }
        comp.append(count).append(prev);
        return comp.toString();
    }
}
