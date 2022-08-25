package com.karn.javatricks.vivekInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveAllElementFromList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10,20,30,10));
        list.removeIf(a->a==10);
        list.removeAll(List.of(20));
        System.out.println(list);
    }
}
