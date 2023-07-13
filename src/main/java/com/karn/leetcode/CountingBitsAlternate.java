package com.karn.leetcode;

public class CountingBitsAlternate {
    public int[] countBits(int n) {
        if(n == 0){
            return new int[]{0};
        }
        if(n == 1){
            return new int[]{0, 1};
        }
        int[] memory = new int[n+1];
        //memory[0] = 0; //00
        memory[1] = 1; //  01
        memory[2] = 1; //  10
        memory[3] = 2; //  11
        //memosfdfry[n] =  1+memory[n-2]
//adsa
        int offset=0;
        for(int i=2;i<=n;i++){
            if (i == offset)
                offset *= 2;
            memory[i] = 1 + memory[i-2];
        }
        return memory;
    }
}
