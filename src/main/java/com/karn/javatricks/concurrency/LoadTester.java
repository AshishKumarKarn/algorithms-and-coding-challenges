package com.karn.javatricks.concurrency;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoadTester {

    public static void runLoadTest(Runnable task, int n) {
        ExecutorService executor = Executors.newFixedThreadPool(n);
        CountDownLatch readyLatch = new CountDownLatch(n);      // For threads to get ready
        CountDownLatch startLatch = new CountDownLatch(1);      // To start all at once
        CountDownLatch doneLatch = new CountDownLatch(n);       // Wait until all threads finish

        long[] threadTimes = new long[n];

        System.out.println("Starting load test with " + n + " threads...");

        for (int i = 0; i < n; i++) {
            int threadIndex = i;
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " counting down " + new Date());
                readyLatch.countDown(); // Signal ready
                try {

                    System.out.println(Thread.currentThread().getName() + " starting  " + new Date());
                    startLatch.await(); // Wait for the go signal
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                System.out.println(Thread.currentThread().getName() + " started at " + new Date());
                long startTime = System.nanoTime();
                task.run();
                long endTime = System.nanoTime();
                threadTimes[threadIndex] = endTime - startTime;

                doneLatch.countDown(); // Signal done
            });
        }

        try {
            readyLatch.await(); // Wait for all threads to be ready
            long globalStart = System.nanoTime();

            startLatch.countDown(); // Release all threads to start

            doneLatch.await(); // Wait for all threads to complete
            long globalEnd = System.nanoTime();

            System.out.println("All threads completed.");
            System.out.println("Total execution time (ms): " + (globalEnd - globalStart) / 1_000_000);

            for (int i = 0; i < n; i++) {
                System.out.printf("Thread %d executed in %.3f ms%n", i + 1, threadTimes[i] / 1_000_000.0);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            executor.shutdown();
        }
    }

    // Example usage
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            // Simulated work
            try {
                Thread.sleep(500); // Simulate 500ms workload
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        runLoadTest(task, 5); // Run task with 10 concurrent threads
    }
}
