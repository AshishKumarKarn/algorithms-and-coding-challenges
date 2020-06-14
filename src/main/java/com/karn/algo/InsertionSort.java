package com.karn.algo;

import java.util.Arrays;

/**
 * @author Ashish Karn
 *
 *
 * */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {23, 5, 2, 55, 233, 21, 53, 65};

        for (int j = (array.length - 1); j >= 0; j--) {
            boolean swapped = false;
            for (int i = 0; i < j; i++) {
                if (array[i] > array[i + 1]) {
                    swapped = swap(array, i);
                }
                //   System.out.println(Arrays.toString(array));
            }
            if (!swapped)
                break;
        }
        System.out.println(Arrays.toString(array));
    }

    private static boolean swap(int[] array, int i) {
        int temp = array[i];
        array[i] = array[i + 1];
        array[i + 1] = temp;
        return true;
    }
}
