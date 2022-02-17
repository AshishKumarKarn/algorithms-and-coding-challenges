package com.karn.kickstart.ks2022.practice.sol;

import java.util.*;

public class SolutionKingdom {

    private static final char[] vowelCaps = {'A','E','I','O','U'};
    private static int vowelCapLetters;
    static {
        for (char vowelCap : vowelCaps) {
            vowelCapLetters |= 1 << (vowelCap - 'A');
        }
    }
    private static String getRuler(String kingdom) {
        if(kingdom==null||kingdom.length()==0){
            return "nobody";
        }
        char lastChar = kingdom.toUpperCase().charAt(kingdom.length() - 1);
        int bit = 1<< lastChar -'A';
        if(lastChar == 'y'||lastChar == 'Y'){
            return "nobody";
        }
        if((vowelCapLetters & bit) ==0){
            return "Alice";
        }else {
            return "Bob";
        }
        //   System.out.println(Integer.toBinaryString(kingdomLetters));
//        if(kingdom!=null&&kingdom.toUpperCase().endsWith()
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int T = in.nextInt();

            for (int t = 1; t <= T; ++t) {
                String kingdom = in.next();
                System.out.println(
                        "Case #" + t + ": " + kingdom + " is ruled by " + getRuler(kingdom) + ".");
            }
        }
    }
}
