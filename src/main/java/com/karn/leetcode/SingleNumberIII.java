package com.karn.leetcode;

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int a=0;
        int b=0;
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }
        long differentBits = 0;
        for (long i = 1; i <= Integer.MAX_VALUE; ) {
            if((xor & i) == i){
                differentBits = i;
                break;
            }
            i = i<< 1;
        }
        for (int i : nums) {
            if((differentBits & i) == differentBits){
                a = a^i;
            }else{
                b=b^i;
            }
        }
        return new int[]{a,b};

    }
}
