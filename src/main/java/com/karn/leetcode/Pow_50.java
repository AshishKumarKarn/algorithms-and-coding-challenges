package com.karn.leetcode;

public class Pow_50 {
    public static void main(String[] args) {
        //2.00000
        //-2147483648

        System.out.println(new Pow_50().myPow(-1.00000, -2147483648));
    }

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0||x ==1) {
            return 1;
        }
        if (n >= Integer.MAX_VALUE && x>1) {
            return Double.POSITIVE_INFINITY;
        }
        if(n>=Integer.MAX_VALUE && x>0 &&x<1){
            return 0;
        }
        if (n <= Integer.MIN_VALUE && x > 1) {
            return 0;
        }
        if (n <= Integer.MIN_VALUE && x > 0 && x< 1) {
            return Double.POSITIVE_INFINITY;
        }
        if(x==-1&&n%2==0){
            return 1;
        }
        if(x==-1&&n%2!=0){
            return -1;
        }

        double t = x;
        if (n > 0) {
            for (int i = 1; i < n; i++) {
                x = t * x;
            }
            return x;
        }

        n *= -1;
        for (int i = 0; i <= n; i++) {
            x = x * (1 / t);
        }
        return x;
    }

}
