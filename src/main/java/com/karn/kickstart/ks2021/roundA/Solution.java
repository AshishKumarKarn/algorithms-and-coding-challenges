package com.karn.kickstart.ks2021.roundA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            long number1 = sc.nextLong();
            long number2 = sc.nextLong();
            long solution=0;
            if(number2>9){
                solution = solve(number1,number2);
                System.out.println("Case #" + i + ": " + solution);
            }else{
                solution = number2 - number1 + 1;
                System.out.println("Case #" + i + ": " + solution);
            }

        }
    }

    private static long solve(long number1, long number2) {
        long result=0;
        for (long i = number1; i <=number2 ; i=i+1) {
            long sum = sumOfDigits(i);
            long product=productOfDigits(i);
            if(product%sum==0){
                result+=1;
            }
        }
        return result;
    }

    private static long productOfDigits(long i) {
        long product=1;
        while(i>0){
            int digit= (int) (i%10);
            product *= digit;
            i=i/10;
        }
        return product;
    }

    private static long sumOfDigits(long i) {
        long sum=0;
        while(i>0){
            int digit= (int) (i%10);
            sum += digit;
            i=i/10;
        }
        return sum;
    }
}
