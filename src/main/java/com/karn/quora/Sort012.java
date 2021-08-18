package com.karn.quora;

import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
        int[] array = {1, 2, 0, 1, 2, 1, 1, 1, 1, 2, 2, 0, 0};
        System.out.printf("unsorted array %s %n", Arrays.toString(array));
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                count0++;
            } else if (array[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }
        System.out.println( count0+" "+count1+" "+count2);
        int i = 0;
        while (count0 > 0) {
            array[i] = 0;
            i++;
            count0--;
        }
        while (count1 > 0) {
            array[i] = 1;
            i++;
            count1--;
        }
        while (count2 > 0) {
            array[i] = 2;
            i++;
            count2--;
        }
        System.out.printf("sorted array   %s", Arrays.toString(array));
    }
}
