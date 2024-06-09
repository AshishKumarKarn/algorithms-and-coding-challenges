package com.karn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString {
    public static void main(String[] args) {
        List<String> strs = Arrays.asList("");
        String encode = new EncodeDecodeString().encode(strs);
        System.out.println(encode);
        System.out.println(new EncodeDecodeString().decode(encode));

    }
    public String encode(List<String> strs) {
        StringBuilder encoded =new StringBuilder();
        for(int i=0;i<strs.size();i++){
            encoded.append(strs.get(i).length());
            encoded.append("_");
            encoded.append(strs.get(i));
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        char[] chars = str.toCharArray();
        int i=0;
        while(i<chars.length){
            int j=i;
            while(chars[j]!='_'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            String s = str.substring(j+1,j+len+1);
            result.add(s);
            i=j+len+1;
        }
        return result;
    }
}
