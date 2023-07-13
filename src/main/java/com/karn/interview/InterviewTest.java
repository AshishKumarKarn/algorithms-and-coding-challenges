package com.karn.interview;

public class InterviewTest {
    public static void main(String[] args) {
        int[] arr={1,2,-3};
        System.out.println(checkBalanced(arr));
    }
    private static boolean checkBalanced(int[] arr){
        int len=100;
        int[] index = new int[len];
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                continue;
            }
            if(arr[i]>0){
                index[arr[i]]++;
            }else{
                index[-arr[i]]--;
            }
        }
        for (int i = 0; i < len; i++) {
            if(index[i]!=0){
                return false;
            }
        }

        return true;
    }
}
