package com.karn.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class RottingOrangesTest {
    private RottingOranges rottingOranges = new RottingOranges();

    @Test
    public void testCase1() {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        Assert.assertEquals(4, rottingOranges.orangesRotting(grid));
    }

    @Test
    public void testCase4() {
        int[][] grid = {{1}};
        Assert.assertEquals(-1, rottingOranges.orangesRotting(grid));
    }

    @Test
    public void testCase5() {
        int[][] grid = {{1, 2}};
        Assert.assertEquals(1, rottingOranges.orangesRotting(grid));
    }

    @Test
    public void testCase6() {
        int[][] grid = {{0, 1}};
        Assert.assertEquals(-1, rottingOranges.orangesRotting(grid));
    }

    @Test
    public void testCase7() {
        int[][] grid = {{1}, {2}};
        Assert.assertEquals(1, rottingOranges.orangesRotting(grid));
    }

    @Test
    public void testCase8() {
        int[][] grid = {{1}, {1}, {1}, {1}};
        Assert.assertEquals(-1, rottingOranges.orangesRotting(grid));
    }

    @Test
    public void testCase2() {
        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        Assert.assertEquals(-1, rottingOranges.orangesRotting(grid));
    }

    @Test
    public void testCase3() {
        int[][] grid = {{0, 2}};
        Assert.assertEquals(0, rottingOranges.orangesRotting(grid));
    }

    @Test
    public void testCase9() {
        int[][] grid = {{0}};
        Assert.assertEquals(0, rottingOranges.orangesRotting(grid));
    }

    @Test
    public void testCase10() {
        int[][] grid = {{0, 0, 0, 0}};
        Assert.assertEquals(0, rottingOranges.orangesRotting(grid));
    }

    @Test
    public void testCase11() {
        int[][] grid = {{0, 0, 0, 1, 1}};
        Assert.assertEquals(-1, rottingOranges.orangesRotting(grid));
    }

    @Test
    public void testCase12() {
        int[][] grid = {{0, 2, 2}, {0, 1, 0}};
        Assert.assertEquals(1, rottingOranges.orangesRotting(grid));
    }

    @Test
    public void testCase13() {
        int[][] grid = {{0, 0}, {2, 0}, {1, 2}};
        Assert.assertEquals(1, rottingOranges.orangesRotting(grid));
//{{2,1,1},{0,1,1},{1,0,1}}
//{{0,2}};
    }

    @Test
    public void testCase14() {
        int[][] grid = {{2}, {2}, {1}, {0}, {1}, {2}};
        Assert.assertEquals(1, rottingOranges.orangesRotting(grid));
    }
    @Test
    public void testCase15() {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 2}};
        Assert.assertEquals(2, rottingOranges.orangesRotting(grid));
    }

}