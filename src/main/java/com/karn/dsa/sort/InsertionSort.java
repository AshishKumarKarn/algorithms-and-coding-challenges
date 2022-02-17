package com.karn.dsa.sort;

import java.util.Arrays;

//O(n^2)
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {3, 5, 2, 1, 6, 8};
        System.out.println("Before sorting " + Arrays.toString(array));
        insertionSort(array);
        System.out.println("After sorting " + Arrays.toString(array));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    shift(arr, j, i);
                    break;
                }
            }
        }

    }

    private static void shift(int[] arr, int j, int i) {
        int last = arr[j];
        for (int k = j + 1; k <= i; k++) {
            int current = arr[k];
            arr[k] = last;
            last = current;
        }
        arr[j] = last;
    }
}
