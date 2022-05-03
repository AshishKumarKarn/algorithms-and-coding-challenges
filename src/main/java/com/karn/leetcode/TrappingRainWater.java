package com.karn.leetcode;

public class TrappingRainWater {

    public int trap(int[] height) {
        int prevValue=-1;
        int trappedWater=0;
        int tempWater=0;
        int lastHeight = 0;
        for (int j : height) {
            if (j >= prevValue) {
                trappedWater += Math.min(tempWater,lastHeight- prevValue);
                lastHeight = j;
            } else {
                tempWater += (prevValue - j);
            }
            prevValue = j;
        }
        return trappedWater;
    }
}
