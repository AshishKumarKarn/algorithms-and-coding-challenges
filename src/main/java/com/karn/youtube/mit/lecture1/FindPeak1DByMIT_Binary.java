package com.karn.youtube.mit.lecture1;

public class FindPeak1DByMIT_Binary {
    // a|b|c|d|e|f|g|h|i  a->i are numbers
    // d is peak iff d>c && d>e
    //Find if peak exists
    //if there is then only one peak exists
    //don't consider edge case

    public static void main(String[] args) {
//        int[] arr = {1, 8, 5, 4, 3, 2, 1};//true
//        int[] arr = {7, 6, 5, 4, 3, 2, 1};//false
        int[] arr = {7, 8, 9, 10, 11, 2, 1};//true

        System.out.println(doesPeakExist(arr, 0, arr.length - 1));
    }

    private static boolean doesPeakExist(int[] arr, int i, int j) {
        int m = (i + j) / 2;
        if (m + 1 > arr.length - 1 || m - 1 < 0) {
            return false;
        }
        if (arr[m] < arr[m - 1]) {
            //peak exists in left side
            return doesPeakExist(arr, 0, m);
        } else if (arr[m] < arr[m + 1]) {
            //peak exists in right side
            return doesPeakExist(arr, m + 1, arr.length - 1);
        } else if (arr[m] == arr[m - 1] && arr[m] == arr[m + 1]) {
            return true;
        }
        System.out.printf("peak at index %d %n", m);
        return true;
    }
}
