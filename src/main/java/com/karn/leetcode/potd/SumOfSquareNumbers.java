package com.karn.leetcode.potd;

public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int left=0; int right =(int) Math.sqrt(c);
        while(left<=right){
            int total = left*left+right*right;
            if(total == c) return true;
            if(total>c){
                right--;
            }else{
                left++;
            }
        }
        return false;
    }
}
