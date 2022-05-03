package com.karn.javatricks;

import java.util.Arrays;

public class Sort0_1 {
    public static void main(String[] args) {
        int[] arr={1,1,1,1,1,1,1,1,0,0,0,1,1,0,1};
        int count_0=0;
        for (int a:arr) {
            if(a==0){
                count_0++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(i<=count_0){
                arr[i]=0;
            }else{
                arr[i]=1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
