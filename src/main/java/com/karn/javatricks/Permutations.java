package com.karn.javatricks;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        long fact = calculateFactorial(15);
        System.out.println(fact);
        int[] arr={1,2,3};
        int num = 0;
        List<List<Integer>> result=new ArrayList<>();
        for (int i = 1; i < (1 << arr.length); i++) {
            List<Integer> subResult=new ArrayList<>();
            for (int j = 1,k=1; j < arr.length;j<<=1, k++) {
                if((j&i)==1){
                    subResult.add(arr[k]);
                }
            }
            result.add(subResult);
        }
        System.out.println(result);

        // 0 0 0
        // 0 0 1
        // 0 1 0
        // 0 1 1
        // 1 0 0
        // 1 0 1
        // 1 1 0
        // 1 1 1
    }

    private static long calculateFactorial(int i) {
        if(i==1){
            return 1;
        }
        return i * calculateFactorial(i-1);
    }
}
