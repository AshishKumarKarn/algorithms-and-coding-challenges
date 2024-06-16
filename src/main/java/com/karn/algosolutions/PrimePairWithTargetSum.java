package com.karn.algosolutions;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimePairWithTargetSum {

    public static ArrayList<Integer> getPrimes(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] arr = new int[n+1];
        Arrays.fill(arr, -1);
        // -1 is unvisited, 0 is prime , 1 denotes non-prime
        for (int i = 2; i*i < arr.length; i++) {
            if (arr[i] == -1) {
                arr[i] = 0;
                for (int j = i * i; j < arr.length;j+=i) {
                    arr[j] = 1;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (arr[i] == -1) {
                arr[i] = 0;
            }
        }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == 0 && arr[n - i] == 0) {
                result.add(i);
                result.add(n - i);
                return result;
            }
        }
        result.add(-1);
        result.add(-1);
        return result;
    }
}
