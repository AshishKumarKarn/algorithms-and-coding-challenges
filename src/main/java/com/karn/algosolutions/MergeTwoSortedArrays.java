package com.karn.algosolutions;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 5, 6, 8};
        int[] arr2 = {2, 4, 5, 7, 8, 9};
        System.out.printf("Merged Array %s %n", Arrays.toString(merge(arr1, arr2)));

    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int k = arr1.length + arr2.length;
        int[] merged = new int[k];
        int i = 0, j = 0, l = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                merged[l] = arr1[i];
                i++;
                l++;
            } else {
                merged[l] = arr2[j];
                l++;
                j++;
            }
        }
        while (i < arr1.length) {
            merged[l] = arr1[i];
            i++;
            l++;
        }
        while (j < arr2.length) {
            merged[l] = arr2[j];
            j++;
            l++;
        }
        return merged;
    }
}
