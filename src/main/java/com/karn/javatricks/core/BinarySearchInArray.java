package com.karn.javatricks.core;

import java.util.Arrays;

public class BinarySearchInArray {
    public static void main(String[] args) {
        int[] array={1,2,4,6,8,99,122};
        System.out.println(-Arrays.binarySearch(array, 9)-1);
    }
}
