package com.karn.tleeliminator.week6;

public class BinaryPower {
    public static void main(String[] args) {
        System.out.println(new BinaryPower().binaryPower(91231232,11321312));
        System.out.println(new BinaryPower().binaryPower(23123,123123129));
    }
    long mod = (long)(1e9+7);
    long binaryPower(long a, long b){
        long answer = 1;
        while(b>0){
            if((b&1)==1){//odd check can also work
                answer = (answer*a)%mod;
            }
            a = (a*a)%mod;
            b >>= 1;
        }
        return answer;
    }
}
