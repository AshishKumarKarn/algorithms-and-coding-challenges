package com.karn.javatricks.concurrency;

import java.util.concurrent.*;

public class BarrierExecutor {

    public static void runWithBarrier(int n, Runnable task) {
        ExecutorService executor = Executors.newFixedThreadPool(n);
        CyclicBarrier barrier = new CyclicBarrier(n, task); // task runs after all threads reach

        for (int i = 0; i < n; i++) {
            executor.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " is ready.");
                    barrier.await(); // Wait for all threads to reach here
                    System.out.println(Thread.currentThread().getName() + " passed the barrier.");
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
    }

    public static void main(String[] args) {
        Runnable finalTask = () -> System.out.println("All threads are ready. Running central task.");
        runWithBarrier(5, finalTask);
    }
}
