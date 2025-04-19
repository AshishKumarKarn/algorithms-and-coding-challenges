package com.karn.leetcode.potd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapOfHighestPeak {
    public static void main(String[] args) {
        List<int[]>[] graph = new List[4];
    }
    int max = (int)1e9;
    public int[][] highestPeak(int[][] isWater) {
        for(int i=0;i<isWater.length;i++){
            for(int j=0;j<isWater[i].length;j++){
                isWater[i][j] = 1^isWater[i][j];
            }
        }
        int lenMax = Math.max(isWater.length, isWater[0].length);
        int count = 0;
        int[][] copy = new int[isWater.length][isWater[0].length];
        while(count<=lenMax){
            for(int i=0;i<isWater.length;i++){
                for(int j=0;j<isWater[i].length;j++){
                    if(isWater[i][j]>0){
                        updatePeak(isWater, i, j);
                    }
                }
            }

            count++;
        }

        return isWater;
    }
    private void updatePeak(int[][] grid, int i, int j){
        int min = max;
        int[] neighbours = new int[]{0,1,0,-1,0};
        for(int l=0;l<neighbours.length-1;l++){
            int x = i + neighbours[l];
            int y = j + neighbours[l+1];
            if(x<0||x>=grid.length||y<0||y>=grid[x].length){
                continue;
            }
            min = Math.min(grid[x][y],min);
        }
        grid[i][j] = 1+min;
    }
    private boolean copy(int[][] original, int[][] copy){
        boolean flag = false;
        outer: for(int i=0;i<original.length;i++){
            for(int j=0;j<original[i].length;j++){
                if(copy[i][j]!=original[i][j]){
                    flag = true;
                    break outer;
                }
            }
        }
        if(!flag){
            return false;
        }
        for(int i=0;i<original.length;i++){
            for(int j=0;j<original[i].length;j++){
                copy[i][j]=original[i][j];
            }
        }
        return true;
    }
}
