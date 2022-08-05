package com.karn.leetcode.leetcode75contest;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsomorphicStringsTest {

    IsomorphicStrings object = new IsomorphicStrings();
    @Test
    public void test1(){
        assertTrue(object.isIsomorphic("paper","title"));
    }

    @Test
    public void test2(){
        assertFalse(object.isIsomorphic("badc","baba"));
    }
    @Test
    public void test3(){
        assertFalse(object.isIsomorphic("egcd","adfd"));
    }
}