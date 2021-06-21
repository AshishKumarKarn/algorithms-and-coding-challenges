package com.karn.youtube.errichto.lecture2;

import java.util.BitSet;

/**
 * You are given N<=1000, each with some weight w[i]. Is there a subset with total
 * weight exactly W?
 * constraint: W <= 10^6
 * Example : array-> {2,4,7,8} w=14 should return true
 *
 * @author Ashish Karn (referenced Youtube Errichto)
 */
public class Knapsack {
    public static void main(String[] args) {
        int[] array = {2, 4, 7, 8};
        int w = 14;

        System.out.println(solution(array, w));
    }

    private static boolean solution(int[] array, int w) {
        int n = array.length;
        boolean[] can = new boolean[w+1];
        can[0]=true;
        for (int id = 0; id < n; id++) {
            for (int i = w; i >= array[id]; i--) {
                if (can[i - array[id]]) {
                    can[i] = true;
                }
            }
        }
        return can[w];
    }

    private static boolean solutionUsingBitSet(int[] array, int w) {
        int n = array.length;
        BitSet can = new BitSet(w + 1);
        can.set(0);
        for (int id = 0; id < n; id++) {
            for (int i = w; i >= array[id]; i--) {
                if (can.get(i - array[id])) {
                    can.set(i);
                }
            }
        }
        return can.get(w);
    }
}
