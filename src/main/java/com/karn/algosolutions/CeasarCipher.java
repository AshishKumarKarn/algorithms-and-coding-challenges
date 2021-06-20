package com.karn.algosolutions;

public class CeasarCipher {
    public static void main(String[] args) {
        String str = "ABCDE lm LM GHXYZabcxyz";
        int move = 28;
        System.out.println(encrypt(str, move));
    }

    private static String encrypt(String str, int move) {
        move = move % 26;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if ((aChar >= 'A' && aChar <= 'Z') || (aChar >= 'a' && aChar <= 'z')) {
                chars[i] = (char) (aChar + move);
                if (chars[i] > 'z' || (chars[i] < 'a' && chars[i] > 'Z')) {
                    chars[i] = (char) (chars[i] - 26);
                }
            }
        }
        return new String(chars);
    }
}
