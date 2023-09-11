package com.karn.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class AsteroidsCollisionTest {

    AsteroidsCollision instance = new AsteroidsCollision();
    @Test
    public void asteroidCollision1() {
        int[] arr = {8,-8};
        int[] ints = instance.asteroidCollision(arr);
        System.out.println(Arrays.toString(ints));
    }
    @Test
    public void asteroidCollision2() {
        int[] arr = {1,-1,-2,-2};
        int[] ints = instance.asteroidCollision(arr);
        System.out.println(Arrays.toString(ints));
    }
}