package com.karn.leetcode.leetcode75contest;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeTest {

    private final LongestPalindrome object = new LongestPalindrome();
    @Test
    public void longestPalindrome() {
        assertEquals(7,object.longestPalindrome("abccccdd"));
    }

}