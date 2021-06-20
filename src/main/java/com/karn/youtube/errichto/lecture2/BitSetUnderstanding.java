package com.karn.youtube.errichto.lecture2;

import java.util.BitSet;

public class BitSetUnderstanding {
    public static void main(String[] args) {
        BitSet bitSet1 = new BitSet(2);
        bitSet1.set(3);
        bitSet1.set(2);
        bitSet1.set(1);
        bitSet1.set(0);
        bitSet1.set(5);
        //101111
        System.out.println(bitSet1);
        //32+8+4+2+1=47
        BitSet bitSet2 = new BitSet();
        bitSet2.set(1);
        bitSet2.set(0);
        bitSet2.set(2);
        //000111=7
        //intersection occurs
        System.out.println(bitSet1.intersects(bitSet2));
        System.out.println(bitSet2);
        // & operation will return 111 = 7
        bitSet1.and(bitSet2);

        System.out.println(bitSet1);//0 1 2
        System.out.println(bitSet1.stream().count());//3

        bitSet1.flip(0, 5);
        System.out.println(bitSet1);// !0 !1 !2 !3 !4 => !1 !1 !1 !0 !0 => 0 0 0 1 1 => 3 4

    }
}
