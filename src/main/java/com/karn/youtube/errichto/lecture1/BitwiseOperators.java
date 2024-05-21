package com.karn.youtube.errichto.lecture1;

public class BitwiseOperators {
    public static void main(String[] args) {
        //int 32 bit
        int a = 3 & 4;
        // 011 & 100
        //a=0
        System.out.println(a);
        a = 5 & 6;
        //101 & 110
        //a=100 4
        System.out.println(a);
        a = 5 | 6;
        //111 = 7
        System.out.println(a);
        a = 5 ^ 6;
        //different bits
        //011 = 3 XOR
        System.out.println(a);

        //~ => FlipSign minus 1
        //FlipSign(-99) -1
        //99-1 = 98
        System.out.println(~-99);

        // -99 -1 = -100
        System.out.println(~99);

        System.out.println((1<<31)-1);
        System.out.println(Integer.MAX_VALUE);
        long number = 8922123199992321313L;
        for (int i = 63; i >= 0; i--) {
            if ((number & (1L << i)) != 0) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }
        }

    }
}
