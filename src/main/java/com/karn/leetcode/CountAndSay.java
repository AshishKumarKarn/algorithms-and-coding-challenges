package com.karn.leetcode;

public class CountAndSay {
    public String countAndSay(int n) {

        StringBuilder sb=new StringBuilder();
        sb.append("1");
        if(n==1){
            return sb.toString();
        }
        return countAndSay(n,sb);
    }
    private String countAndSay(int n,StringBuilder sb){
        if(n==0){
            return sb.toString();
        }
        StringBuilder temp=new StringBuilder();
        String[] currentStrings = sb.toString().split("");
        String digit = currentStrings[0];
        int count=0;
        for(int i=0;i<currentStrings.length;i++){
            if(!currentStrings[i].equals(digit)){
                temp.append(count);
                temp.append(digit);
                digit = currentStrings[i];
                count=1;
            }else{
                count++;
            }
            if(i== currentStrings.length-1){
                temp.append(count);
                temp.append(currentStrings[i]);
            }
        }
        return countAndSay(n-1,temp);
    }
}
