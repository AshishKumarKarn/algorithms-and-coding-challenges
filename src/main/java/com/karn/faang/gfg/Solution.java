package com.karn.faang.gfg;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        double sum = 7077888000d + 1528823808d;
      //256 16777216
        outer: for (int i = 3; i < 2048; i++) {
            for (int j = 3; j < 2048 ; j++) {
                if(isPerfectCube(((i*i*i)+(j*j*j)))){
                    System.out.println(i+" "+j);
                    break outer;
                }
            }
        }
    }

    private static boolean isPerfectCube(double num) {

        for (int i = 3; i < 2048; i++) {
            double m = i * i * i;
            if(m==num){
                System.out.println(i);
                System.out.println(m);
                return true;
            }
        }
        return false;
    }
}
