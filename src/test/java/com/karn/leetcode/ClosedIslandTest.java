package com.karn.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClosedIslandTest {
    private ClosedIsland closedIsland=new ClosedIsland();

    @Test
    public void testCase1(){
        int[][] grid={{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
//{{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}}
//{{1,1,1,1,1,1,1},{1,0,0,0,0,0,1},{1,0,1,1,1,0,1},{1,0,1,0,1,0,1},{1,0,1,1,1,0,1},{1,0,0,0,0,0,1},{1,1,1,1,1,1,1}}
        Assert.assertEquals(2, closedIsland.closedIsland(grid));
    }

    @Test
    public void testCase2(){
        int[][] grid=//{{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
{{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}};
//{{1,1,1,1,1,1,1},{1,0,0,0,0,0,1},{1,0,1,1,1,0,1},{1,0,1,0,1,0,1},{1,0,1,1,1,0,1},{1,0,0,0,0,0,1},{1,1,1,1,1,1,1}}
        Assert.assertEquals(1, closedIsland.closedIsland(grid));
    }
    @Test
    public void testCase3(){
        int[][] grid=//{{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
//{{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}};
{{1,1,1,1,1,1,1},{1,0,0,0,0,0,1},{1,0,1,1,1,0,1},{1,0,1,0,1,0,1},{1,0,1,1,1,0,1},{1,0,0,0,0,0,1},{1,1,1,1,1,1,1}};
        Assert.assertEquals(2, closedIsland.closedIsland(grid));
    }

    @Test
    public void testCase4(){
        int[][] grid={  {0,0,1,1,0,1,0,0,1,0},
                        {1,1,0,1,1,0,1,1,1,0},
                        {1,0,1,1,1,0,0,1,1,0},
                        {0,1,1,0,0,0,0,1,0,1},
                        {0,0,0,0,0,0,1,1,1,0},
                        {0,1,0,1,0,1,0,1,1,1},
                        {1,0,1,0,1,1,0,0,0,1},
                        {1,1,1,1,1,1,0,0,0,0},
                        {1,1,1,0,0,1,0,1,0,1},
                        {1,1,1,0,1,1,0,1,1,0}   };
        Assert.assertEquals(5, closedIsland.closedIsland(grid));
    }
    @Test
    public void testCase5(){
        int[][] grid={  {0,1,1,1,0},
                        {1,0,1,0,1},
                        {1,0,1,0,1},
                        {1,0,0,0,1},
                        {0,1,1,1,0}};
        Assert.assertEquals(1, closedIsland.closedIsland(grid));
    }

}