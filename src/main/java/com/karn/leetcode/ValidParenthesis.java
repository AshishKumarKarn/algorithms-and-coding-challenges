package com.karn.leetcode;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(new ValidParenthesis().isValid("{{[]}}"));
    }
    Stack<String> bucket=new Stack<>();
    public boolean isValid(String s) {
        String[] str=s.split("");
        for(int i=0;i<str.length;i++){
            if(str[i].equals("{")||str[i].equals("(")||str[i].equals("[")){
                bucket.push(str[i]);
            }else{
                String last=bucket.pop();
                if(!str[i].equals(getAntibody(last))){
                    return false;
                }
            }
        }
        return bucket.size() == 0;
    }
    private String getAntibody(String s){
        if(s.equals("["))
            return "]";
        if(s.equals("{"))
            return "}";
        if(s.equals("("))
            return ")";
        return null;
    }
}
