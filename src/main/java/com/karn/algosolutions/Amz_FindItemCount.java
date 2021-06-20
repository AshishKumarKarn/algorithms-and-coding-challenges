package com.karn.algosolutions;

public class Amz_FindItemCount {
    public static void main(String[] args) {
        int a=10;
        int b=++a + ++a + ++a - a;
        System.out.println(b);
        System.out.println(a);
        String str = "*|**|***|*|****";
        int startIndex =3;
        int endIndex=14;
        int finalCount = 0;
        int count = 0;
        boolean beginCount = false;
        for (int i = startIndex; i < endIndex; i++) {
            if (str.charAt(i) == '*') {
                ++count;
            }
            if (str.charAt(i) == '|' && beginCount) {
                finalCount = count;
            } else if (str.charAt(i) == '|') {
                count=0;
                beginCount = true;
            }
        }
        System.out.println(finalCount);
    }
}
