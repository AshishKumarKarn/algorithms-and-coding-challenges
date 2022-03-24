package com.karn.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BrokenCalculator {

    public static void main(String[] args) {
        System.out.println(new BrokenCalculator().brokenCalc(5, 11));
    }

    public int brokenCalc(int startValue, int target) {
        int result = 0;
        while (target > startValue) {
            result++;
            if (target % 2 == 0) {
                target /= 2;
            } else {
                target++;
            }
        }
        return result + (startValue - target);
    }
}
