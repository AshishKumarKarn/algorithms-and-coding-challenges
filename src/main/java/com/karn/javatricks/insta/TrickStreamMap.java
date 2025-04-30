package com.karn.javatricks.insta;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TrickStreamMap {
    /**
     * Question is to create map from a list of given objects without
     * leading to any exception using streams API
     * */
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1, 2.2, "apple"),
                new Product(2, 2.2, "pineapple"),
                new Product(3, 2.2, "orange"),
                new Product(3, 2.4, "orange")
                );
        //illegal state exception due to same id of two entries
//        Map<Integer, Product> collect = products.stream()
//                .collect(Collectors.toMap(
//                        Product::getId,
//                        Function.identity()
//                ));
        Map<Integer, Product> collect = products.stream()
                .collect(Collectors.toMap(
                        Product::getId,
                        Function.identity(),
                        (existing, now) -> now
                ));
        System.out.println(collect);
    }
    static class Product{
        private final int id;
        private final String name;
        private final double value;

        public Product(int id, double value, String name) {
            this.id = id;
            this.value = value;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }



        public double getValue() {
            return value;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Product{");
            sb.append("id=").append(id);
            sb.append(", name='").append(name).append('\'');
            sb.append(", value=").append(value);
            sb.append('}');
            return sb.toString();
        }
    }
}

