package com.karn.javatricks.java8;

import java.util.ArrayList;
import java.util.List;

public class Example {
public static void main(String[] args) {
    Byte [][] aar=new Byte [1][2];
List<String> list = new ArrayList<>();
list.add("A");
list.add("B");
list.add("C");
list.remove(1);
System.out.println(list.get(1));
}
}