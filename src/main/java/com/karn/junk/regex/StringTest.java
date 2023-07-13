package com.karn.junk.regex;

import java.util.UUID;

public class StringTest {
    public static void main(String[] args) {
        String string="AshishKarn";
        String substring = string.substring(0, string.length());
        System.out.println(substring);
        long start = System.currentTimeMillis();
        generateRandom();
        System.out.printf("Total duration %s ms", (System.currentTimeMillis()-start));
    }
    private static String generateRandom(){
        StringBuilder sb=new StringBuilder();
        int i=0;
        while (i<1000000){
            sb.append(UUID.randomUUID());
            i++;
        }
        return sb.toString();
    }
}
