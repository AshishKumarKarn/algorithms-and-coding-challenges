package com.karn.interview;

import java.util.Arrays;

/**
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: nums = [0,1,3,0,4,_,_,_]
 * */
public class EDInterview2 {
/**
 *
 * select count(*), country from customer group by country
 *
 *
 * */
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int target = 3;
        operate(nums,target);
        System.out.println(Arrays.toString(nums));
    }
    public static void operate(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==target){
                swap(i,arr,target);
            }
        }
    }
    private static void swap(int t, int[] arr,int target){
        for (int i = t+1; i < arr.length; i++) {
            if(arr[i]!=target){
                int temp = arr[t];
                arr[t]=arr[i];
                arr[i]=temp;
                break;
            }
        }
    }
}
