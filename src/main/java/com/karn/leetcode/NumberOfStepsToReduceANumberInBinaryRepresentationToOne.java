package com.karn.leetcode;

public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    public static void main(String[] args) {
        String s = "1111110011101010110011100100101110010100101110111010111110110010";
        System.out.println(new NumberOfStepsToReduceANumberInBinaryRepresentationToOne().numSteps(s));
    }
    int left;
    int right;
    public int numSteps(String s) {
        left=1;
        char[] arr = s.toCharArray();
        int[] digits = new int[arr.length+1];
        right = digits.length -1;
        for(int i=1;i<=right;i++){
            digits[i]=arr[i-1]-'0';
        }
        int count=0;
        while(left<right){

            if(digits[right]==0){
                count++;
                shiftRight(digits);
            }else{
                count += addOne(digits);
            }
        }
        return count;
    }
    private void shiftRight(int[] digits){
        right--;
    }
    private int addOne(int[] digits){
        int count=1;
        for(int i=right;i>=left;i--){
            if(digits[i]==0){
                digits[i]=1;
                return count;
            }
            count++;
            right--;
        }
        digits[left-1]=1;
        left--;
        return count;
    }
}
