package com.karn.leetcode;

import java.util.Arrays;

public class NearestExitFromEntranceInMaze {
    //    [["+",".","+","+","+","+","+"],["+",".","+",".",".",".","+"],["+",".","+",".","+",".","+"],["+",".",".",".",".",".","+"],["+","+","+","+",".","+","."]]
//            [0,1]
    public int nearestExit(char[][] maze, int[] e) {
        boolean canTravelNorth = true;
        boolean canTravelSouth = true;
        boolean canTravelEast = true;
        boolean canTravelWest = true;

        if (e[0] == 0) {
            canTravelNorth = false;
        }
        if (e[0] == maze.length - 1) {
            canTravelSouth = false;
        }
        if (e[1] == 0) {
            canTravelWest = false;
        }
        if (e[1] == maze[e[0]].length - 1) {
            canTravelEast = false;
        }
        int res = findNearest(maze, e[0], e[1], 0, canTravelNorth, canTravelSouth, canTravelEast, canTravelWest);
        print(maze);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int findNearest(char[][] maze, int i, int j, int step, boolean north, boolean south, boolean east, boolean west) {
        System.out.println("step > "+step+" "+i+" "+j);
        print(maze);
        if (i >= maze.length || i < 0 || j >= maze[i].length || j < 0) {
            System.out.println("final step , moving back ");
            return step - 1;
        }
        if (maze[i][j] == '+') {
            System.out.println("moving back ");
            return Integer.MAX_VALUE;
        }
        int n = Integer.MAX_VALUE;
        int s = Integer.MAX_VALUE;
        int e = Integer.MAX_VALUE;
        int w = Integer.MAX_VALUE;
        maze[i][j] = '+';
        if (north) {
            n = findNearest(maze, i - 1, j, step + 1, true, true, true, true);
        }
        if (south) {
            s = findNearest(maze, i + 1, j, step + 1, true, true, true, true);
        }
        if (east) {
            e = findNearest(maze, i, j + 1, step + 1, true, true, true, true);
        }
        if (west) {
            w = findNearest(maze, i, j - 1, step + 1, true, true, true, true);
        }
        return Math.min(Math.min(n, s), Math.min(e, w));
    }
    private void print(char[][] maze){
        for (char[] chars : maze) {
            System.out.println(Arrays.toString(chars));
        }
        System.out.println();
    }
}
