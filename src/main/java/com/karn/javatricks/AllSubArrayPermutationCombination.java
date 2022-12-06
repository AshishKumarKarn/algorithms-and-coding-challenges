package com.karn.javatricks;

import java.util.ArrayList;
import java.util.List;

public class AllSubArrayPermutationCombination {
    public static void main(String[] args) {
        long fact = calculateFactorial(15);
        System.out.println(fact);
        int[] arr={1,2,3};
        int num = 0;
        List<List<Integer>> result=new ArrayList<>();
        for (int i = 0; i < (1 << arr.length); i++) {
            List<Integer> subResult=new ArrayList<>();
            for (int j = 0; j < arr.length;j++) {
                if((i&(1<<j))!=0){
                    subResult.add(arr[j]);
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
