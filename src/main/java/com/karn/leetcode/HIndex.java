package com.karn.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = {100};
        System.out.println(new HIndex().hIndex(citations));
    }

    public int hIndex(int[] citations) {
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < citations.length; i++) {
            set.add(citations[i]);
            max = Math.max(citations[i], max);
        }
        int maxCitation = Math.min(citations.length, max);
        int result = 0;
        Arrays.sort(citations);
        outer:
        for (int i = maxCitation; i >= 0; i--) {
                int count = 0;
                for (int j = citations.length - 1; j >= 0; j--) {
                    if (citations[j] >= i) {
                        count++;
                    } else {
                        break;
                    }
                    if (count == i) {
                        result = i;
                        break outer;
                    }

            }
        }
        return result;
    }
}
