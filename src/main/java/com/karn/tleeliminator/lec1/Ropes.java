package com.karn.tleeliminator.lec1;

import java.util.Scanner;
//https://codeforces.com/edu/course/2/lesson/6/2/practice/status
public class Ropes {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] ropes = new int[n];
            for (int i = 0; i < n; i++) {
                ropes[i] = sc.nextInt();
            }
            double solution = maximumSizeOfKRopes(ropes, k);
            System.out.println(solution);
        }
    }

    private static double maximumSizeOfKRopes(int[] ropes, int k) {
        double left = 1;
        double right = (1e8);
        for (int i = 0; i < 100; i++) {
            double mid = left + (right-left)/2;
            if(isPossibleToCutKRopes(mid, k, ropes)){
                left = mid ;
            }else{
                right = mid;
            }
        }
        return left;
    }

    private static boolean isPossibleToCutKRopes(double mid, int k, int[] ropes) {
        int count=0;
        for (int i = 0; i < ropes.length; i++) {
            count += (ropes[i]/mid);
        }
        return count>=k;
    }
}
