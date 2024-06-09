package com.karn.faang.gfg;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LongestSubArrayWithSumK {

    public static int lenOfLongSubarr(int[] A, int N, int K){
        int i=0;
        int j=1;
        int sum = A[i];
        int result = 0;
        while(i<N&&j<N){
            while(j<N&&sum<K){
                sum += A[j];
                j++;
            }
            if(sum==K){
                result = Math.max(result, (j-i));
            }
            while(i<j&&sum>K){
                sum -= A[i];
                i++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr= {-13, 0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6};
        int K = 15;
        System.out.println(lenOfLongSubarr(arr, 17, K));
    }
}
