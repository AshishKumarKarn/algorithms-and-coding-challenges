package com.karn.junk;

import java.util.Scanner;

public class CG2023_2 {
    public static void main(String args[] ) throws Exception {
        try(Scanner sc=new Scanner(System.in)){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] arr = new int[N];
            int[] queries=new int[M];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            for(int i=0;i<M;i++){
                queries[i]=sc.nextInt();
            }
            for(int i=0;i<M;i++){
                int sum = 0;
                for(int j=0;j<N;j++){
                    int diff = Math.abs(queries[i]-arr[j]);
                    sum += diff;
                }
                System.out.print(sum);
                if(i<M-1){
                    System.out.print(" ");
                }
            }
        }

    }
}
