package com.karn.algosolutions;

import java.util.Arrays;

import static java.lang.Math.min;

public class Facebook_IntersectingIntegers {
    public static void main(String[] args) {
        int[] arr1 = {3, 4, 14, 5, 6, 8, 8, 11, 2300};
        int[] arr2 = {2, 3, 5, 7, 6, 11, 2300};
        System.out.printf("Elements intersecting are %s %n",
                Arrays.toString(findIntersections(arr1, arr2)));
    }

    private static int[] findIntersections(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0, j = 0, k = 0;
        int[] result = new int[min(arr1.length, arr2.length)];
        while (i < arr1.length && j < arr2.length) {
            if(arr1[i]==arr2[j]){
                result[k]=arr1[i];
                k++;
                i++;j++;
            }else if(arr1[i]>arr2[j]){
                j++;
            }else{
                i++;
            }
        }
        return result;
    }


    //works for lower digits only
//    private static int[] findIntersections(int[] arr1, int[] arr2) {
//        int[] result = new int[min(arr1.length, arr2.length)];
//        int total1 = 0;
//        for (int i = 0; i < arr1.length; i++) {
//            total1 |= 1 << arr1[i];
//        }
//        int total2 = 0;
//        for (int i = 0; i < arr2.length; i++) {
//            total2 |= 1 << arr2[i];
//        }
//        total1 &= total2;
//        String bin = Integer.toBinaryString(total1);
//        System.out.println(bin);
//        for (int i = bin.length() - 1, k = 0, count = 0; i >= 0; count++) {
//            if (bin.charAt(i) == '1') {
//                result[k] = count;
//                k++;
//            }
//            i--;
//        }
//        return result;
//    }
}
