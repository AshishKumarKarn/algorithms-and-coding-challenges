package com.karn.leetcode;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        String result = "";
        for (int i = num1.length() - 1; i >= 0; i--) {
            int carry = 0;
            StringBuilder currentLine = new StringBuilder();

            for (int j = num2.length() - 1; j >= 0; j--) {
                int res = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry;
                currentLine.append(res % 10);
                carry = res / 10;
            }
            if (carry != 0) {
                currentLine.append(carry);
            }
            int pow = num1.length() - 1 - i;
            StringBuilder appendZero = new StringBuilder();
            for (int l = 0; l < pow; l++) {
                appendZero.append("0");
            }
            result = sum(result, currentLine.reverse() + appendZero.toString());
        }
        boolean allZero = true;
        int count = 0;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '0') {
                allZero = false;
                count = i;
                break;
            }
        }
        if (allZero) return "0";
        if (count == 0) return result;
        return result.substring(count);
    }

    private String sum(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int max;
        int diff;
        StringBuilder appendZero = new StringBuilder();
        if (len1 > len2) {
            max = len1;
            diff = len1 - len2;
            for (int i = 0; i < diff; i++) {
                appendZero.append("0");
            }
            num2 = appendZero + num2;
        } else {
            max = len2;
            diff = len2 - len1;
            for (int i = 0; i < diff; i++) {
                appendZero.append("0");
            }
            num1 = appendZero + num1;
        }
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < max; i++) {
            int res = (num1.charAt(max - i - 1) - '0') + (num2.charAt(max - i - 1) - '0') + carry;
            result.append(res % 10);
            carry = res / 10;
        }
        if (carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }


    public static void main(String[] args) {
        //System.out.println("Result -> "+multiply("645654","989"));
    }
}
