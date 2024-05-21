package com.karn.junk;

import java.util.Arrays;

public class RotateArray {

        public static void rotateLeft(int[] arr, int positions) {
            int n = arr.length;
            positions = positions % n;
            for (int i = 0; i < positions; i++) {
                int temp = arr[0];
                for (int j = 0; j < n - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[n - 1] = temp;
            }
        }

        public static void main(String[] args) {
            int[] array = {1, 2, 3, 4, 5};
            int rotateBy = 1;
            System.out.println("Original Array: " + Arrays.toString(array));
            rotateLeftNew(array, rotateBy);
            System.out.println("Array after rotating left by " + rotateBy + " positions: " + Arrays.toString(array));
        }

    public static void rotateLeftNew(int[] arr, int positions) {
        int n = arr.length;
        positions = positions % n;
        int[] temp=new int[positions];
        for (int i = 0; i < positions; i++) {
            temp[i]=arr[i];
        }
        for (int i = positions,j=0; i < n; i++) {
            arr[j++]=arr[i];
        }
        for (int i = n-positions,j=0; i < n ; i++) {
            arr[i]=temp[j++];
        }
    }


}
