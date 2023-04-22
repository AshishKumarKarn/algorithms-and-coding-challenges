package com.karn.junk;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] array, int target) {

        final Map<Integer, Integer> memory = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (memory.get(array[i]) != null) {
                return new int[]{memory.get(array[i]), i};
            } else {
                memory.put(target - array[i], i);
            }
        }
        throw new IllegalArgumentException("Not found");
    }


}
