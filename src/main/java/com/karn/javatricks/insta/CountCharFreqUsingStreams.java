package com.karn.javatricks.insta;

import java.util.Map;
import java.util.stream.Collectors;

public class CountCharFreqUsingStreams {
    public static void main(String[] args) {
        String word = "aabbbbdadddaccc";
        Map<Character, Long> freqMap = word
                .chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        ch -> ch,
                        Collectors.counting()
                ));

        System.out.println(freqMap);
    }
}
