package com.karn.algosolutions;

/**
 * This problem was asked by Stripe.
 * <p>
 * Given an array of integers, find the first missing positive integer in
 * linear time and constant space. In other words, find the lowest positive
 * integer that does not exist in the array. The array can contain duplicates
 * and negative numbers as well.
 * <p>
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 * <p>
 * You can modify the input array in-place.
 */
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
