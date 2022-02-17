package com.karn.kickstart.ks2022.practice.sol;

import java.util.*;

public class SolutionHIndex {

    public static int[] getHIndexScore(int[] citationsPerPaper) {
        int[] hIndex = new int[citationsPerPaper.length];
        Map<Integer, Integer> MAP = new HashMap<>();
        for (int i = 0; i < citationsPerPaper.length; i++) {
            int keys = citationsPerPaper[i];
            int iterations = Math.min(keys, citationsPerPaper.length);
            boolean inserted = false;
            for (int key = (i - 1) < 1 ? hIndex[i] > 0 ? 1 : 0 : hIndex[i - 1]; key <= iterations; key++) {
                Integer oldVal = MAP.put(key, 1);
                int oldValue = (oldVal == null) ? 0 : oldVal;
                int newValue = oldValue + 1;
                MAP.put(key, newValue);
                if (key <= (newValue)) {
                    hIndex[i] = key;
                    inserted = true;
                }
            }
            if (!inserted)
                hIndex[i] = (i - 1) < 0 ? 0 : hIndex[i - 1];
        }
        //System.out.println(MAP);
        return hIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Get number of test cases in input
        int testCaseCount = scanner.nextInt();
        // Iterate through test cases
        for (int tc = 1; tc <= testCaseCount; ++tc) {
            // Get number of papers for this test case
            int paperCount = scanner.nextInt();
            // Get number of citations for each paper
            int[] citations = new int[paperCount];
            for (int p = 0; p < paperCount; ++p) {
                citations[p] = scanner.nextInt();
            }
            // Print h-index score after each paper in this test case
            System.out.print("Case #" + tc + ":");
            for (int score : getHIndexScore(citations)) {
                System.out.append(" ").print(score);
            }
            System.out.println();
        }
    }
}
