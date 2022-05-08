package com.karn.faang.old;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class TwoSumTest {

    @Test
    public void testOne(){
        int[] array={1,3,7,9,2};
        int target = 11;
        int[] solution = new TwoSum().solutionOptimizedTwo(array, target);
        Arrays.sort(solution);
        assertArrayEquals(new int[]{3,4}, solution);
    }

    @Test
    public void testTwo(){
        int[] array={1,3,7,9,2};
        int target = 25;
        int[] solution = new TwoSum().solutionOptimizedTwo(array, target);
        assertArrayEquals(null, solution);
    }
    @Test
    public void testThree(){
        int[] array={};
        int target = 25;
        int[] solution = new TwoSum().solutionOptimizedTwo(array, target);
        assertArrayEquals(null, solution);
    }
    @Test
    public void testFour(){
        int[] array={5};
        int target = 25;
        int[] solution = new TwoSum().solutionOptimizedTwo(array, target);
        assertArrayEquals(null, solution);
    }
    @Test
    public void testFive(){
        int[] array={1,6};
        int target = 7;
        int[] solution = new TwoSum().solutionOptimizedTwo(array, target);
        Arrays.sort(solution);
        System.out.println(Arrays.toString(solution));
        assertArrayEquals(new int[]{0,1}, solution);
    }


}