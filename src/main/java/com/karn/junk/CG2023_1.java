package com.karn.junk;

import java.util.Arrays;
import java.util.Scanner;

public class CG2023_1 {
    public static void main(String args[] ) throws Exception {
        long res=0;
        try(Scanner sc=new Scanner(System.in)){
            int N = sc.nextInt();
            long X = sc.nextLong();
            long[] pArr = new long[N];
            for(int i=0;i<N;i++){
                pArr[i] = sc.nextLong();
            }
            Arrays.sort(pArr);
            int count=0;

            for(int i=N-1;i>=0;i--){

                count++;
                if(count<X){

                    res = pArr[i];
                }else if(count==X&&i>0){
                    if(pArr[i]==pArr[i-1]){
                        System.out.println(-1);
                        return;
                    }else{
                        res = pArr[i];
                    }
                }else if(count==X){
                    res = pArr[i];
                    break;
                }else{
                    res = pArr[i+1];
                    break;
                }
            }
        }
        System.out.println(res);
        //Write code here

    }
}
