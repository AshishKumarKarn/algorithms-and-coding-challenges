package com.karn.codeforces.cp31.eighthundred;

import java.util.Scanner;

/**
 @link <a href="https://codeforces.com/problemset/problem/1903/A">HalloumiBoxes</a>
 *
 */
public class HalloumiBoxes {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t>0){
                int n = sc.nextInt();
                int k = sc.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i]=sc.nextInt();
                }
                if(k==1&&hasDecreasingElement(arr)){
                    System.out.println("NO");
                }else{
                    System.out.println("YES");
                }
                t--;
            }
        }
    }

    private static boolean hasDecreasingElement(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<arr[i-1]){
                return true;
            }
        }
        return false;
    }
}
