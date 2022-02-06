package com.karn.leetcode;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class IntervalListIntersections {
    public static void main(String[] args) {
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        new IntervalListIntersections().intervalIntersection(
                firstList, secondList
        );
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int firstMax = Integer.MIN_VALUE;
        for (int i = 0; i < firstList.length; i++) {
            int x = firstList[i][0];
            int y = firstList[i][1];
            if (firstMax < x) {
                firstMax = x;
            }
            if (firstMax < y) {
                firstMax = y;
            }

        }


        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < secondList.length; i++) {
            int x = secondList[i][0];
            int y = secondList[i][1];
            if (secondMax < x) {
                secondMax = x;
            }
            if (secondMax < y) {
                secondMax = y;
            }
        }
        int max = Math.max(secondMax, firstMax);
        boolean[] first = new boolean[max+1];
        for (int i = 0; i < firstList.length; i++) {
            int x = firstList[i][0];
            int y = firstList[i][1];
            for (int j = x; j <= y; j++) {
                first[j] = true;
            }
        }
        boolean[] second = new boolean[max+1];
        for (int i = 0; i < secondList.length; i++) {
            int x = secondList[i][0];
            int y = secondList[i][1];
            for (int j = x; j <= y; j++) {
                second[j] = true;
            }
        }
        boolean secondIsSmaller = secondMax < firstMax;
        for (int i = 0; i < max; i++) {
            if (secondIsSmaller) {
                if (first[i] && second[i]) {
                    second[i] = true;
                } else {
                    second[i] = false;
                }
            } else {
                if (first[i] && second[i]) {
                    first[i] = true;
                } else {
                    first[i] = false;
                }
            }
        }

        List<List<Integer>> arrayList = new ArrayList<>();
        boolean started = false;
        List<Integer> list = null;
        for (int i = 0;i <= max; i++) {
            if (secondIsSmaller) {
                if (second[i] && !started) {
                    list = new ArrayList<>();
                    list.add(i);
                    started = true;
                } else if (started) {
                    list.add(i - 1);
                    started = false;
                    arrayList.add(list);
                }
            } else {
                if (first[i] && !started) {
                    list = new ArrayList<>();
                    list.add(i);
                    started = true;
                } else if (!first[i]&&started) {
                    list.add(i - 1);
                    started = false;
                    arrayList.add(list);
                }

            }
        }
        System.out.println(arrayList);
        return firstList;
    }
}
