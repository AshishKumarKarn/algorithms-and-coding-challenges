package com.karn.youtube.errichto.lecture2;


import java.util.BitSet;

/**
 * Problem Statement:
 * You are given N = 10^7 numbers, each between 0 and 10^9.
 * How many different values appear in the given sequence?
 *
 * Set -> O(n*log(n)) x
 * Boolean -> visited[10^9] => 1 GB memory x
 * bitSet[10^9+1] visited => 128 MB memory GOOD TO GO
 *
 * @author Ashish Karn (reference Youtube Errichto)
 * */
public class DifferentNumbers {

    public static void main(String[] args) {
        int[] arr={1,3,2,1,2,3,1,3,6,67,3,4};//can be a huge array from some input file
        System.out.println(method1(arr));
        System.out.println(method2(arr));

    }

    private static int method1(int[] arr) {
        BitSet bitSet = new BitSet(1000_000_000+1);
        for (int element : arr) {
            bitSet.set(element);
        }
        //cardinality returns number of bit set to true
        //it's another iteration
        return bitSet.cardinality();
    }

    private static int method2(int[] arr) {
        int count =0;
        BitSet bitSet=new BitSet(1000_000_000+1);
        for (int element: arr) {
            if(!bitSet.get(element)){
                bitSet.set(element);
                count++;
            }
        }
        return count;
    }
}