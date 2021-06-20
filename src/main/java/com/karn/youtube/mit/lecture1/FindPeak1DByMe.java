package com.karn.youtube.mit.lecture1;

public class FindPeak1DByMe {

    // a|b|c|d|e|f|g|h|i  a->i are numbers
    // d is peak iff d>c && d>e
    //Find if peak exists

    public static void main(String[] args) {
        int[] arr = {1, 1, 7, 7, 5, 6, 6};
        System.out.println(doesPeakExist(arr));
    }

    private static boolean doesPeakExist(int[] arr) {
        if (arr.length == 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr.length <= 2) {
                return true;
            }
            if (i == 0 && arr[0] > arr[1]) {
                return true;
            } else if (i > 0) {
                if (i == arr.length - 1 && arr[i] > arr[i-1]) {
                    return true;
                } else if (i < arr.length - 1) {
                    if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                        return true;
                    }
                }

            }
        }
        return false;
    }
}
