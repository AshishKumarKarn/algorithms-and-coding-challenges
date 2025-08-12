package com.karn.leetcode.lc3362;

import java.util.List;
import java.util.Optional;

public class Solution {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4);
        Optional<Integer> any = integers.parallelStream().findAny();
        System.out.println(any.get());
        String a = "asdsa";
        String ne = a.charAt(1) + String.valueOf(a.charAt(0));
        System.out.println(ne);

    }
}
