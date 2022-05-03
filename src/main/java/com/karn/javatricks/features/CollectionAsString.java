package com.karn.javatricks.features;

import java.util.ArrayList;
import java.util.List;

public class CollectionAsString {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("asda");
        list.add(":'");
        list.add("aer");
        System.out.println(list.toString());

    }
}
