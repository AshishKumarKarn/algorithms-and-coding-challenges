package com.karn.cses.dp;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DiceCombinations {
    public static long combinations(int n){
        if(n<=1||n==2){
            return n;
        }
        if(n==3) return 4; if(n==4) return 8; if(n==5) return 16; if(n==6) return 32;
        long[] dp=new long[n+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        dp[4]=8;
        dp[5]=16;
        dp[6]=32;

        int m = 1000000007;
        for(int i=7;i<=n;i++){
            dp[i] = ((dp[i-1]%m)+(dp[i-2]%m)+(dp[i-3]%m)+(dp[i-4]%m)+(dp[i-5]%m)+(dp[i-6]%m))%m;
        }
       return dp[n];
    }
    public static void main(String[] args) {
        try(Scanner sc= new Scanner(System.in)){
            System.out.println(combinations(sc.nextInt()));
        }
    }
}
