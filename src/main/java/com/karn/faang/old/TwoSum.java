package com.karn.faang.old;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] solution(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            int find = target - array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (find == array[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] solutionOptimizedOne(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }
        for (int i = 0; i < array.length; i++) {
            int numberToFind = target - array[i];
            if (map.containsKey(numberToFind)) {
                return new int[]{i, map.get(numberToFind)};
            }
        }
        return null;
    }

    public int[] solutionOptimizedTwo(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer present = map.get(array[i]);
            if (present != null) {
                return new int[]{present, i};
            }else{
                int numberToFind = target - array[i];
                map.put(numberToFind, i);
            }
        }
        return null;
    }
}
