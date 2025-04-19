package com.karn.javatricks.java8;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFutureDemo {
    //    public static void main(String[] args) {
//        //give list of numbers , square each numbers are sum all.
//        //using parallel stream
//        List<Integer> integers = List.of(1, 2, 3, 4);//=> 1,4,9,16=>30
//        Integer sqSum = integers.parallelStream().map(n -> n * n).reduce((a, b) -> a + b).get();
//        System.out.println(sqSum);
//
//    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> integers = List.of(1, 2, 3, 4);//=> 1,4,9,16=>30
        // Map each integer to a CompletableFuture that computes its square
        List<CompletableFuture<Integer>> futures = integers.stream()
                .map(i -> CompletableFuture.supplyAsync(() -> i * i))
                .toList();

        // Combine all futures into one that contains the sum of squares
        CompletableFuture<Integer> sumFuture = CompletableFuture
                .allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join) // Wait for each to complete and get the result
                        .reduce(0, Integer::sum));

        // Get the final result
        int sumOfSquares = sumFuture.get();
        System.out.println("Sum of squares: " + sumOfSquares);

    }
}
