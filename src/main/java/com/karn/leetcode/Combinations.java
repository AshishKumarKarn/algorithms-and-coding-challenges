package com.karn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> subResult = new LinkedList<>();
        return combine(numbers, k, k, result, subResult, 0);
    }

    private List<List<Integer>> combine(int[] numbers, int size, int k, List<List<Integer>> result, LinkedList<Integer> subResult, int cursor) {
        if (k == 0 || cursor == numbers.length || (numbers.length - cursor) < k) {
            if (subResult.size() == size) {
                result.add(Arrays.asList(subResult.toArray(new Integer[0])));
            }
            return result;
        }
        subResult.addLast(numbers[cursor]);
        combine(numbers, size, k - 1, result, subResult, cursor + 1);
        subResult.removeLast();
        combine(numbers, size, k, result, subResult, cursor + 1);
        return result;
    }
}
