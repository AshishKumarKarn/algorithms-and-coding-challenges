package com.karn.youtube.errichto.lecture1;


//This is just a demo program to understand bitwise operators
//Time complexity is O((2^N)*N) However this problem can be solved in O(2^N)

/**
 * Problem Statement:
 * You are given N numbers. Check if there is a sub-set of them with
 * the sum equal to target value S
 * <p>
 * Condition : N< 20
 * Input: {1, 4, 3}
 * Solutions as S->answer : 0-> true 1-> true 2-> false 3-> true 4-> true 5-> true 6-> false 7-> true
 * 8-> true 9-> false 10-> false 11-> false 12-> false 13-> false 14-> false 19-> false.....
 *
 * @author Ashish (reference Errichto from Youtube)
 */
public class FindSumOfSubArrayPresentOrNot {

    public static void main(String[] args) {
        int[] arr = {1, 4, 3};
        int S = 5;
        System.out.println(solution(arr, S));
    }

    private static boolean solution(int[] arr, int s) {
        for (int mask = 0; mask < (1 << arr.length); mask++) {
            long sum_of_this_subset = 0;
            for (int i = 0; i < arr.length; i++) {
                if ((mask & (1 << i)) == 0) {
                    sum_of_this_subset += arr[i];
                }
            }
            if (sum_of_this_subset == s) {
                return true;
            }
        }
        return false;
    }
}
