package com.karn.dsa.interview.techgig;

import java.util.*;

public class CandidateCode {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases > 0) {
            int r1 = 0, r2 = 0;
            int target = sc.nextInt();
            int len = sc.nextInt();
            int[] arr = new int[len];
            Map<Integer, Integer> indexWithItemPrice = new HashMap<>(len + 1, 1);
            for (int i = 0; i < len; i++) {
                arr[i] = sc.nextInt();
                indexWithItemPrice.put(i, arr[i]);
            }
            Arrays.sort(arr);
            int min = Integer.MAX_VALUE;
            for (int i = 0, j = len - 1; i < j; ) {
                int sum = arr[i] + arr[j];
                int cursorI = i;
                int cursorJ = j;
                if (sum > target) {
                    j--;
                } else {
                    if ((target - sum) < min) {
                        r1 = indexWithItemPrice.entrySet().stream().filter(a -> a.getValue() == arr[cursorI]).findAny().get().getKey() + 1;
                        int index1 = r1 - 1;
                        indexWithItemPrice.remove(index1);
                        r2 = indexWithItemPrice.entrySet().stream().filter(a -> a.getValue() == arr[cursorJ]).findAny().get().getKey() + 1;
                        indexWithItemPrice.put(index1, arr[cursorI]);
                        if (target == sum) {
                            break;
                        }
                        min = (target - sum);
                    }
                    i++;
                }
            }
            if (r1 < r2)
                System.out.println(r1 + " " + r2);
            else
                System.out.println(r2 + " " + r1);
            testCases--;
        }

    }
}