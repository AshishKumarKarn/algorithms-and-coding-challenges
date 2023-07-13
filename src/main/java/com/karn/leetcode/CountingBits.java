package com.karn.leetcode;

public class CountingBits {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        memory = new int[n+1];
        for(int i=0;i<=n;i++){
            res[i] = count1s(i);
        }
        return res;
    }
    private int[] memory;
    private int count1s(int i){
        int res=0;
        while(i!=0){
            if(memory[i]!=0){
                return memory[i]+res;
            }
            i &= (i-1);
            res++;
        }
        memory[i]=res;
        return res;
    }
}
