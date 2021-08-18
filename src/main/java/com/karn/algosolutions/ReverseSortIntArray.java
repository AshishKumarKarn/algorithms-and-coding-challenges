package com.karn.algosolutions;

import java.util.Arrays;
import java.util.Comparator;

public class ReverseSortIntArray {
    public static void main(String[] args) {
        int[] array={2,45,4,2,6,7,8,3,2,1,9};
        Arrays.sort(array);
        int[] ints = Arrays.stream(array).boxed().sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(ints));
    }
}
