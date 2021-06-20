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

        int number = 1322123;
        for (int i = 63; i >= 0; i--) {
            if ((number & (1l << i)) != 0) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }
        }

    }
}
