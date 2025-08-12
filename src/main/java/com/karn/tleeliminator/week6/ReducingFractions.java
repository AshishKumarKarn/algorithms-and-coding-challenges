package com.karn.tleeliminator.week6;

import java.util.*;

public class ReducingFractions {
    static final int MAX = 10_000_000;
    static int[] spf = new int[MAX + 1]; // smallest prime factor

    public static void main(String[] args) {
        preprocessSPF();

        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] nums = new int[n];
            int[] dens = new int[m];

            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
            for (int i = 0; i < m; i++) dens[i] = sc.nextInt();

            Map<Integer, Integer>[] reduced = reduce(nums, dens);

            if (reduced[0].isEmpty()) reduced[0].put(1, 1);
            if (reduced[1].isEmpty()) reduced[1].put(1, 1);


            System.out.println(reduced[0].size() + " " + reduced[1].size());
            printProducts(reduced[0]);
            printProducts(reduced[1]);
        }
    }

    private static void preprocessSPF() {
        for (int i = 2; i <= MAX; i++) {
            if (spf[i] == 0) {
                for (int j = i; j <= MAX; j += i) {
                    if (spf[j] == 0) spf[j] = i;
                }
            }
        }
    }

    private static Map<Integer, Integer>[] reduce(int[] nums, int[] dens) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        Map<Integer, Integer> denFreq = new HashMap<>();

        for (int n : nums) countFactors(n, numFreq);
        for (int d : dens) countFactors(d, denFreq);

        for (Integer p : new HashSet<>(numFreq.keySet())) {
            if (denFreq.containsKey(p)) {
                int num = numFreq.get(p), den = denFreq.get(p);
                if (num > den) numFreq.put(p, num - den);
                else if (den > num) denFreq.put(p, den - num);
                else {
                    numFreq.remove(p);
                    denFreq.remove(p);
                }
                if (num <= den) numFreq.remove(p);
                if (den <= num) denFreq.remove(p);
            }
        }
        return new Map[]{numFreq, denFreq};
    }

    private static void countFactors(int x, Map<Integer, Integer> freqMap) {
        while (x > 1) {
            int factor = spf[x];
            freqMap.put(factor, freqMap.getOrDefault(factor, 0) + 1);
            x /= factor;
        }
    }

    private static void printProducts(Map<Integer, Integer> freqMap) {
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int value = entry.getValue();
            for (int i = 0; i < value; i++) {
                System.out.print(entry.getKey() + " ");
            }
        }
        System.out.println();
    }
}