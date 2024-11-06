package com.karn.codeforces.cp31.eighthundred;

import java.util.Scanner;

/**
 * @link <a href="https://codeforces.com/contest/1901/problem/A">Line Trip</a>
 * */
public class LineTrip {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int test = sc.nextInt();
            while(test>0){
                int n = sc.nextInt();
                int x = sc.nextInt();
                int[] array = new int[n];
                for (int i = 0; i < n; i++) {
                    array[i] = sc.nextInt();
                }
                System.out.println(solve(array,x));
                test--;
            }
        }
    }

    private static int solve(int[] array,int x) {
        int prev = 0;
        int max = 0;
        boolean set=false;
        for(int i=0;i<array.length;i++){
            if(array[i]<=x){
                max = Math.max(max, array[i]-prev);
                prev = array[i];
            }else{
                set=true;
                max = Math.max(max, 2*(x-prev));
                break;
            }
        }
        if(!set){
            max = Math.max(max, 2*(x-array[array.length-1]));
        }
        return max;
    }
}
