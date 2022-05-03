package com.karn.dsa.interview.vonage;

import java.util.HashMap;
import java.util.Map;

public class Solution {

//    String str = "HeLloo";
public static void main(String[] args) {
    System.out.println(getFrequency("H"));
}
    public static Character getFrequency(String str) {
        if (str == null || str.length() == 0) return 0;

        //-> map.
        //int[] array=new int[26];
        //'t'-'a'

        str = str.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        Character result = null;
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            Integer existing = map.getOrDefault(str.charAt(i), 0);
            map.put(str.charAt(i), ++existing );
            if (existing > max) {
                max = existing;
                result = str.charAt(i);
            }
        }
        return result;
    }
}
