package com.karn.javatricks.concurrency;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoadTestingAnother {
    public static void main(String[] args) throws Exception {
        loadTesting(()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Executing task "+Thread.currentThread().getName());
        }, 3);
    }
    private static void loadTesting(Runnable runnable, int n) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(n);
        CountDownLatch waitLatch=new CountDownLatch(n);
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(n);
        for (int i = 0; i < n; i++) {
            service.submit(()->{
                waitLatch.countDown();
                try {
                    startLatch.await();
                    System.out.println("Thread starting at "+Thread.currentThread().getName()+new Date());
                    runnable.run();
                    endLatch.countDown();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }

            });
        }
        waitLatch.await();
        long startTime = System.currentTimeMillis();
        startLatch.countDown();
        endLatch.await();
        System.out.println(System.currentTimeMillis()-startTime);
        service.shutdown();
    }
}
