package com.karn.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestRepeatingCharacterReplacementTest {

    LongestRepeatingCharacterReplacement instance =new LongestRepeatingCharacterReplacement();
    @Test
    public void test1() {
        assertEquals(4, instance.characterReplacement("ABAB", 2));
    }
    @Test
    public void test2() {
        assertEquals(4, instance.characterReplacement("AABABBA", 1));
    }

    @Test
    public void test3(){
        assertEquals(31, instance.characterReplacement("AABABBAABBABAAABABABABABABABABBBBAAABBABABABABAAAABABABABABBAABBAAAAABABA"
        ,12));
    }
    @Test
    public void test4(){
        assertEquals(5, instance.characterReplacement("BAAAB"
                ,2));
    }

    @Test
    public void test5(){
        assertEquals(4, instance.characterReplacement("ABBB"
                ,2));
    }
}