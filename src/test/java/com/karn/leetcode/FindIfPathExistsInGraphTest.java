package com.karn.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindIfPathExistsInGraphTest {

    FindIfPathExistsInGraph instance=new FindIfPathExistsInGraph();
    @Test
    public void test1() {
        int[][] edges={{0,1},{1,2},{2,0}};
        System.out.println(instance.validPath(3,edges,0,2));
    }
}