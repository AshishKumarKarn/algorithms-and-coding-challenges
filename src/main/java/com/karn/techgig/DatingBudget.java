package com.karn.techgig;

import java.util.Arrays;
import java.util.Scanner;

public class DatingBudget {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int budget = sc.nextInt();
        int len1 = sc.nextInt();
        int len2 = sc.nextInt();

        int[] arr1 = new int[len1];
        for (int i = 0; i < len1; i++) {
            arr1[i] = sc.nextInt();
        }

        int[] arr2 = new int[len2];
        for (int i = 0; i < len2; i++) {
            arr2[i] = sc.nextInt();
        }


        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (arr1[0] + arr2[0] > budget) {
            System.out.println(-1);
            return;
        }

        int res1 = -1;
        int res2 = -1;
        loop1:
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int total = arr1[i] + arr2[j];
                if (total <= budget) {
                    res1 = total;
                    break loop1;
                }
            }
        }

        loop2:
        for (int j = len2 - 1; j >= 0; j--) {
            for (int i = len1 - 1; i >= 0; i--) {
                int total = arr1[i] + arr2[j];
                if (total <= budget) {
                    res2 = total;
                    break loop2;
                }
            }
        }
        System.out.println(Math.max(res1, res2));
    }

}
