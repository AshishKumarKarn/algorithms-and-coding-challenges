package com.karn.leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length<1){
            return "";
        }
        String first = strs[0];
        String second;
        for(int i=1;i<strs.length;i++){
            boolean flipped=false;
            if(first.length()>strs[i].length()){
                second = first;
                first=strs[i];
                flipped=true;
            }else{
                second = strs[i];
            }
            for(int j=0;j<first.length()&&j<second.length();j++){
                if(first.charAt(j)!=second.charAt(j)&&j>0){
                    if(flipped)
                        first=first.substring(0,j);
                    else
                        first=second.substring(0,j);
                }else if(first.charAt(j)!=second.charAt(j)&&j==0){
                    return "";
                }
            }
        }
        return first;
    }
}
