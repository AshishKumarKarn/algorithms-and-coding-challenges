package com.karn.leetcode.leetcode75contest;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsSubsequenceTest {

    IsSubsequence object=new IsSubsequence();
    @Test
    public void test1() {
        assertFalse(object.isSubsequence("acb",
                "ahbgdc"));
    }
    @Test
    public void test2() {
        assertFalse(object.isSubsequence("bb",
                "ahbgdc"));
    }
}