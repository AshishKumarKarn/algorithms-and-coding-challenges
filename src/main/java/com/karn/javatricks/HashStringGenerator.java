package com.karn.javatricks;

public class HashStringGenerator {

    public static void main(String[] args) {
        int v = (int)(Math.random() * 1000_0000);
        System.out.println(v);
        System.out.println(hashString(v));
    }

    private static String hashString(int input){
        StringBuilder result= new StringBuilder();
        String[] base="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        //length= 10 +26+26= 62 ->indexed between 0-61

        while(input>0){
            result.append(base[input % 62]);
            input /= 62;
        }

        return result.toString();
    }
}
