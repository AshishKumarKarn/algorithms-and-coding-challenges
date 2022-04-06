package com.karn.leetcode;

public class TwoSumII_InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] result=new int[2];
        for (int i = 0,j=numbers.length-1; i < j;) {
            if(numbers[i]+numbers[j]==target){
                result[0]=i;
                result[1]=j;
                break;
            }else if(numbers[i]+numbers[j]>target){
                j--;
            }else{
                i++;
            }
        }
        return result;
    }
}
