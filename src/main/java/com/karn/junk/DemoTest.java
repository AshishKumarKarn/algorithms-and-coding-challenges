package com.karn.junk;

import java.util.stream.Stream;

public class DemoTest {
    double weight;
    String name;
    DemoTest(double w){
        this(w,"");
        this.weight=w;
    }
    DemoTest(double w,String s){
        this.weight=w;
    }
    public static void main(String[] args) {
        Stream<Integer> ints = Stream.of(10,20,30);
//        ints.map(a->a+10).peek(a-> System.out.println(a));
        ints.forEach(System.out::println);
        var d = new DemoTest(3);
    }
}
