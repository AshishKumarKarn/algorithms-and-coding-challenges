package com.karn.javatricks.features.forname;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestStaticWithForName {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.karn.javatricks.features.forname.MyClass");
        System.out.println("Class loaded");

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        int constant = 100;
        Optional<Integer> reduce = numbers.stream().filter(n -> n % 2 == 0).map(n -> constant * n).reduce(Integer::sum);
        IntSummaryStatistics collect = numbers.stream().filter(n -> n % 2 == 0).map(n -> constant * n).collect(Collectors.summarizingInt(a -> a));
        int sum = numbers.stream().filter(n -> n % 2 == 0).mapToInt(a -> constant * a).sum();
        System.out.println(sum);
        System.out.println(collect.getSum());
        System.out.println(reduce.get());
    }
}

class MyClass {
    static {
        System.out.println("Hello World");
    }
}