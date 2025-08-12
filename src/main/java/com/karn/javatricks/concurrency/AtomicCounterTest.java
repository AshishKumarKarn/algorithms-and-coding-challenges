package com.karn.javatricks.concurrency;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounterTest {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(0);
        int numThreads = 10;
        int totalIncrements = 1000;

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        CountDownLatch latch = new CountDownLatch(totalIncrements);
        ConcurrentHashMap<String, Integer> threadOps = new ConcurrentHashMap<>();

        for (int i = 0; i < totalIncrements; i++) {
            executor.submit(() -> {
                counter.incrementAndGet();

                String threadName = Thread.currentThread().getName();
                threadOps.merge(threadName, 1, Integer::sum);

                latch.countDown();
            });
        }

        latch.await();
        executor.shutdown();

        System.out.println("Final Counter Value: " + counter.get());
        threadOps.forEach((thread, count) ->
            System.out.println(thread + " performed " + count + " increments"));
    }
}
