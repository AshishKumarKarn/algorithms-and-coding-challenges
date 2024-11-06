package com.karn.codeforces.random;

import java.util.Scanner;

public class Quintomania {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t>0){
                int n = sc.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i]=sc.nextInt();
                }
                System.out.println(solve(arr));
                t--;
            }
        }
    }

    private static String solve(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - arr[i - 1]);
            if(!(diff==5||diff==7)){
                return "NO";
            }
        }
        return "YES";
    }

}
