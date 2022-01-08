package com.karn.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class SetMatrixZeroesTest {
    private SetMatrixZeroes setMatrixZeroes=new SetMatrixZeroes();

    @Test
    public void setZeroesApproach1() {
        int[][] matrix={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setMatrixZeroes.setZeroes(matrix);
//        [[1,0,1],[0,0,0],[1,0,1]]
//[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
        int[][] expected={{0,0,0,0},{0,4,5,0},{0,3,1,0}};
        Assert.assertArrayEquals(expected,matrix);

    }
}