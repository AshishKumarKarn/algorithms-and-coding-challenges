package com.karn.dsa.recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class TowerOfHanoiTest {

    TowerOfHanoi object = new TowerOfHanoi();

    @Test
    public void test1() {
        object.TOH(2, 1,2,3);
    }
}