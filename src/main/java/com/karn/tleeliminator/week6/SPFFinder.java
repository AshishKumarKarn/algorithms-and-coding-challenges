package com.karn.tleeliminator.week6;

import java.util.Arrays;

//this goes in conjunction with Sieve of Eratosthenes
public class SPFFinder {

    public static void main(String[] args) {
        //find SPF of 18 i.e 2
        int size = (int) (1e6) + 1;
        int[] spf = new int[size];//array showing smallest prime factor of each number
        boolean[] sieve = new boolean[size];
        Arrays.fill(sieve, true); //marking all prime
        Arrays.fill(spf, (int) 1e9);//fill all to infinite
        sieve[0] = false;
        sieve[1] = false;
        for (int i = 2; i * i < size; i++) {
            if (sieve[i]) {
                for (int j = i * i; j < size; j += i) {
                    sieve[j] = false;
                    spf[j] = Math.min(i, spf[j]);
                }
            }
        }
        for (int i = 0; i < spf.length; i++) {
            System.out.println("Smallest Prime Factor of "+i +" is "+(spf[i]==1000000000?i:spf[i]));
        }
    }

}
