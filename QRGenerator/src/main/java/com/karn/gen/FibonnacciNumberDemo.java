package com.karn.gen;

import java.util.Arrays;

public class FibonnacciNumberDemo {

    public static void main(String[] args) {
        int n=45;
        long start = System.currentTimeMillis();
        int number = fibonacci(n);
        System.out.printf("Total time spent is %s ms and answer is %s \n", (System.currentTimeMillis()-start), number);

        long start2 = System.currentTimeMillis();
        int number2 = fibonacciFast(n);
        System.out.printf("Fast method :: Total time spent is %s ms and answer is %s \n", (System.currentTimeMillis()-start2), number2);
    }

    private static int fibonacci(int n) {
        if(n==0||n==1){
            return 1;
        }
        if(n<0){
            throw new IllegalArgumentException("Invalid input "+n);
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }


    private static int fibonacciFast(int n) {
        if(n==0||n==1){
            return 1;
        }

        int[] memory = new int[n+1];
        memory[0]=1;
        memory[1]=1;
        for (int i = 2; i < n + 1; i++) {
            memory[i]=memory[i-1]+memory[i-2];
        }
        return memory[n];
    }

    private static boolean isFibonacci(int number){
        int cursor = 1;
        int lastNum = 0;
        while (true){
            if(cursor<number){
                cursor = cursor + lastNum;
                lastNum = cursor;
            }else if(cursor == number){
                return true;
            }else{
                break;
            }
        }
        return false;
    }
}
