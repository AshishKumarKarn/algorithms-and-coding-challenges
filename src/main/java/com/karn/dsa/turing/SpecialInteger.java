package com.karn.dsa.turing;

import java.util.Arrays;

public class SpecialInteger {

    public static void main(String[] args) {
        int[] array={0,4,0,1,4,5,6};
        int result=specialInteger(array);
        System.out.println(result);
    }

    private static int specialInteger(int[] array) {
        if(array.length==0){
            return -1;
        }
        Arrays.sort(array);
        int count=0;
        for (int i = array.length-1; i >-1 ; i--) {
            if(count<=array[i]){
                count++;
            }
        }
        return count;
    }
}
