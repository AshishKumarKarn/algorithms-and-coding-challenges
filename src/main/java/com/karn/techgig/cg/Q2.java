package com.karn.techgig.cg;

import java.util.*;

public class Q2 {

    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(countMaxNonSequentialSubarrays(arr));
        }
    }
    public static int countMaxNonSequentialSubarrays(int[] arr) {
        HashMap<Integer, Set<Integer>> sumOccurrences = new HashMap<>();
        int maxCount=0;

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                Set<Integer> existingIndexes = sumOccurrences.getOrDefault(sum, new HashSet<>());
                if(!existingIndexes.contains(i)&&!existingIndexes.contains(j)){
                    existingIndexes.add(i);
                    existingIndexes.add(j);
                }
                sumOccurrences.put(sum, existingIndexes);
            }
        }
        for (Map.Entry<Integer, Set<Integer>> integerSetEntry : sumOccurrences.entrySet()) {
            maxCount = Math.max(maxCount, integerSetEntry.getValue().size());
        }
        return maxCount/2;
    }
}
/*

7
2 4 4 6 8 10 10

3

6
2 4 5 2 4 1

3
 */