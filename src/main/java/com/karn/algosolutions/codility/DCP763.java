package com.karn.algosolutions.codility;


import java.util.*;

/**
 * Good morning! Here's your coding interview problem for today.
 *
 * This problem was asked by Google.
 *
 * Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.
 *
 * For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
 *
 * 10 = max(10, 5, 2)
 * 7 = max(5, 2, 7)
 * 8 = max(2, 7, 8)
 * 8 = max(7, 8, 7)
 * Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.
 * */
public class DCP763 {
    public static void main(String[] args) {
        int[] arr = {10,5,2,7,8,7};
        List<Integer> ints = Arrays.asList(10,5,2,7,8,7);
        long count = ints.stream().filter(a->a==7).count();
        System.out.println(count);

        int k = 3;
        printMaxSubArray(arr, k);
    }
    private static void printMaxSubArray(int[] arr, int k ){
        Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            heap.add(arr[i]);
        }
        for (int i = k,j=0; i < arr.length; i++,j++) {
            System.out.println(heap.peek());
            heap.add(arr[i]);
            heap.remove(arr[j]);
        }
        System.out.println(heap.peek());

    }
}
