package com.karn.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonPrefixTest {

    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
    @Test
    public void test1() {
        String[] arr= {"reflower","flow","flight"};
        String s = longestCommonPrefix.longestCommonPrefix(arr);
        assertEquals("",s);
    }
}