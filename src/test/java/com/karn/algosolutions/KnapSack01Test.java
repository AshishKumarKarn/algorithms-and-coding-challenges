package com.karn.algosolutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class KnapSack01Test {

    KnapSack01 instance=new KnapSack01();
    @Test
    public void test1() {
        int[] values={10,20,30,40};
        int[] weights={30,10,40,20};
        int w = 40;
        assertEquals(
                60,instance.knapSack(w,3, values,weights));
    }
}