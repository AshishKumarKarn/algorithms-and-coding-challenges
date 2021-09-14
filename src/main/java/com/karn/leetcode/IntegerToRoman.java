package com.karn.leetcode;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

//TODO: UNSOLVED
public class IntegerToRoman {
    private static final Map<Integer, String> intToRomanMap = new TreeMap<>(Comparator.reverseOrder());

    static {
        intToRomanMap.put(1, "I");
        intToRomanMap.put(5, "V");
        intToRomanMap.put(10, "X");
        intToRomanMap.put(50, "L");
        intToRomanMap.put(100, "C");
        intToRomanMap.put(500, "D");
        intToRomanMap.put(1000, "M");
    }

    public static void main(String[] args) {

            System.out.println(new IntegerToRoman().intToRoman(5));

    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        Integer prev = null;
        for (Map.Entry<Integer, String> entry : intToRomanMap.entrySet()) {
            Integer k = entry.getKey();
//            if (prev != null && (prev - num) == 1) {
//                sb.append("I" + intToRomanMap.get(prev));
//                continue;
//            }
            while (num / k > 0) {

                num = num / k;
                if (k == 1) {
                    num = num - 1;
                }

                sb.append(intToRomanMap.get(k));
            }
            prev = k;
        }
        return sb.toString();
    }
}
