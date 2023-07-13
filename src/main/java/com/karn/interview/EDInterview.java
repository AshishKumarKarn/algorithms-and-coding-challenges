package com.karn.interview;

/**
 *
 * Input: arr = [3,1,0]
 * Output: false
 *
 * Input: arr = [1,3,4]
 * Output: false
 *
 * Input: arr = [0,3,2,1]
 * Output: true
 *
 * Input: arr = [0,3,3,1]
 * Output: false
 *
 * Input: arr = [0,3,4,2,3,1]
 * Output: false
 *
 *
 *
 */


public class EDInterview {
    public static void main(String[] args) {
        int[] arr = {3,1,0};
        hasPeak(arr);
        arr = new int[]{1,3,4};
        hasPeak(arr);
        arr = new int[]{0,3,2,1};
        hasPeak(arr);
        arr = new int[]{0,3,3,1};
        hasPeak(arr);
        arr = new int[]{0,3,4,2,3,1};
        hasPeak(arr);


    }
    private static void hasPeak(int[] arr){
        int peakCount = 0;
        for (int i = 1; i < arr.length-1; i++) {
            if(arr[i]>arr[i-1]&&arr[i]>arr[i+1]){
                peakCount++;
            }
        }
        if(peakCount==1){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }

}
