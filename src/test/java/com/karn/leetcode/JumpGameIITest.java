package com.karn.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGameIITest {

    private final JumpGameII game = new JumpGameII();
    @Test
    public void jump() {
        int[] nums = {2,3,1,1,4};
        assertEquals(2, game.jump(nums));
    }
    @Test
    public void testCase2() {
        int[] nums = {2,3,0,1,4};
        assertEquals(2, game.jump(nums));
    }

    @Test
    public void testCase3() {
        int[] nums = {4,3,0,2,4};
        assertEquals(1, game.jump(nums));
    }

    @Test
    public void testCase4() {
        int[] nums = {0,3,0,2,4};
        assertEquals(Integer.MAX_VALUE, game.jump(nums));
    }

    @Test
    public void testCase5() {
        int[] nums = {1,3,0,2,4};
        assertEquals(2, game.jump(nums));
    }

    @Test
    public void testCase6() {
        int[] nums = {1,2,0,1,4};
        assertEquals(3, game.jump(nums));
    }

    @Test
    public void testCase7() {
        int[] nums = {1,4,0,1,4};
        assertEquals(2, game.jump(nums));
    }

    @Test
    public void testCase8() {
        int[] nums = {2,0,1,1,4,6,0,0,0,0,0,4};
        assertEquals(5, game.jump(nums));
    }

    @Test
    public void testCase9() {
        int[] nums = {2,0,1,1,4,6,0,0,0,0,0,0};
        assertEquals(5, game.jump(nums));
    }

    @Test
    public void testCase10() {
        int[] nums = {2,0,3,1,4,6,0,0,0,0,0,0};
        assertEquals(3, game.jump(nums));
    }

    @Test
    public void testCase11() {
        int[] nums = {2,0,3,1,4,1,0,0,2,0,7,0,0};
        assertEquals(5, game.jump(nums));
    }

    // @Test
    public void testCase12() {
        int[] nums = {9,8,2,2,0,2,2,0,4,1,5,7,9,6,6,0,6,5,0,5};
        assertEquals(3, game.jump(nums));
    }

    @Test
    public void testCase13() {
        int[] nums = {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
        assertEquals(5, game.jump(nums));
    }

}