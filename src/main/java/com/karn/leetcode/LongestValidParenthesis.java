package com.karn.leetcode;

import java.util.Stack;

public class LongestValidParenthesis {
    public static void main(String[] args) {
        System.out.println(new LongestValidParenthesis().longestValidParentheses("(())))()()()"));
    }
    public int longestValidParentheses(String s) {
        int maxCount=0;
        if(s.equals("")){
            return maxCount;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        int lastAddIndex = 0;
        int lastPopCount = 0;
        for(int i=1;i<s.length();){
            while(i<s.length()&&!stack.isEmpty()&&stack.peek()!=s.charAt(i)&&s.charAt(i)==')'){
                stack.pop();
                if(lastPopCount>0) {
                    maxCount = (lastPopCount-1)*Math.max(maxCount, (i - lastAddIndex + 1));
                }else{
                    maxCount = Math.max(maxCount, (i - lastAddIndex + 1));
                }
                i++;
                lastAddIndex--;
                lastPopCount+=2;
            }
            lastPopCount--;
            if(lastPopCount<=0){
                lastPopCount =0;
            }
            if(i<s.length()){
                stack.push(s.charAt(i));
            }else{break;}
            lastAddIndex = i;
            i++;
        }
        return maxCount;
    }
}
