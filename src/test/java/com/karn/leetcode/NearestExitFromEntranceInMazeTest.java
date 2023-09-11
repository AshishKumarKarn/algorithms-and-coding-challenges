package com.karn.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NearestExitFromEntranceInMazeTest {

    NearestExitFromEntranceInMaze instance = new NearestExitFromEntranceInMaze();
    @Test
    public void nearestExit1() {
        char[][] maze = {{'+','.','+','+','+','+','+'},{'+','.','+','.','.','.','+'},{'+','.','+','.','+','.','+'},{'+','.','.','.','.','.','+'},{'+','+','+','+','.','+','.'}};
        int i = instance.nearestExit(maze, new int[]{0, 1});
        Assert.assertEquals(7, i);
    }
}