package com.karn.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PacificAtlanticWaterFlowTest {

    PacificAtlanticWaterFlow object=new PacificAtlanticWaterFlow();

    @Test
    public void pacificAtlanticTest1() {
        int[][] grid={{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> lists = object.pacificAtlantic(grid);
        //List<List<Integer>> result = (List<List<Integer>>) Arrays.asList(new int[][]{{0, 2}, {0, 4}, {1, 2}, {1, 3}, {1, 4}, {3, 0}, {3, 1}, {4, 0}});
        Assert.assertNotNull(lists);
        System.out.println(lists);
    }
    @Test
    public void pacificAtlanticTest2() {
        int[][] grid={{1,2,7,3,5},{3,2,6,4,4},{2,4,1,3,1},{6,7,2,4,5},{5,1,1,2,4}};
        List<List<Integer>> lists = object.pacificAtlantic(grid);
        //List<List<Integer>> result = (List<List<Integer>>) Arrays.asList(new int[][]{{0, 2}, {0, 4}, {1, 2}, {1, 3}, {1, 4}, {3, 0}, {3, 1}, {4, 0}});
        Assert.assertNotNull(lists);
        String expected="[[0, 2], [0, 4], [1, 2], [1, 3], [1, 4], [3, 0], [3, 1], [4, 0]]";
        Assert.assertEquals(expected,lists.toString());
    }
    @Test
    public void pacificAtlanticTest3() {
        int[][] grid={{2,1},{1,2}};
        List<List<Integer>> lists = object.pacificAtlantic(grid);
        //List<List<Integer>> result = (List<List<Integer>>) Arrays.asList(new int[][]{{0, 2}, {0, 4}, {1, 2}, {1, 3}, {1, 4}, {3, 0}, {3, 1}, {4, 0}});
        Assert.assertNotNull(lists);
        String expected="[[0, 0], [0, 1], [1, 1], [1, 0]]";
        Assert.assertEquals(expected,lists.toString());
    }
}