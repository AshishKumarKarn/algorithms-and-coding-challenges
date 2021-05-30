package com.karn.algosolutions;

public class FindFirstPositiveAbsentInteger {


    public static void main(String[] args) {
        int[] arr = new int[]{3, 7, 2, 1112, 1, 0, -1};//ans should be 4
        System.out.println(solve(arr));
    }

    /**
     * Finds first positive integer in array with Big O(n) time complexity
     */
    private static int solve(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0)
                total |= (1 << arr[i]);
        }
        String binary = 0 + Integer.toBinaryString(total);
        int solution = 0;
        for (int i = binary.length() - 1; i > 0; i--) {
            if (binary.charAt(i) == '0')
                break;
            ++solution;
        }
        return solution;
    }

}
