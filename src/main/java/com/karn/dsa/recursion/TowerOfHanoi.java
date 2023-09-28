package com.karn.dsa.recursion;

public class TowerOfHanoi {

    public void TOH(int n,int A, int B, int C){
        if(n>0){
            TOH(n-1,A,C,B);
            System.out.printf("Move %s to %s \n", A, C);
            TOH(n-1, B, A, C);
        }
    }
}
