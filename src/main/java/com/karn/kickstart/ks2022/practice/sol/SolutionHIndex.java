package com.karn.kickstart.ks2022.practice.sol;

import java.util.*;

public class SolutionHIndex {

    public static int[] getHIndexScore(int[] citationsPerPaper) {
            int[] hIndex = new int[citationsPerPaper.length];

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < citationsPerPaper.length; i++) {
                int c = citationsPerPaper[i];

                if (pq.isEmpty()) {
                    pq.add(c);
                } else {
                    if (c > pq.size()) {
                        pq.add(c);
                    }
                    while (pq.size() > 1 && pq.peek() < pq.size()) {
                        pq.remove();
                    }
                }

                hIndex[i] = pq.size();
            }

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
