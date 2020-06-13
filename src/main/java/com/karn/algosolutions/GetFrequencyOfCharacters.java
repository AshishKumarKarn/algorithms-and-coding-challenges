package com.karn.algosolutions;

import java.util.Map;

/**
 * @author Ashish Karn
 */
public class GetFrequencyOfCharacters {
    public static Map<Character, Integer> getFrequencyOfCharacters(char[] charArray, Map<Character, Integer> map) {
        Integer initialFreq = 1;
        for (char character : charArray) {
            Integer freq = map.put(character, initialFreq);
            if (freq != null) {
                map.put(character, (freq + 1));
            }
        }
        return map;
    }
}
