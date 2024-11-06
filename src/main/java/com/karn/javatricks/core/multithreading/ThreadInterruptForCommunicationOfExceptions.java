package com.karn.javatricks.core.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadInterruptForCommunicationOfExceptions {
    public static void main(String[] args) {
        Callable<Integer> r = () -> {
            for (int i = 0; i < 100; i++) {
                try {
                    System.out.println("sleeping");
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new InterruptedException(e.getMessage());
                }
                System.out.println("Ex");
            }
            return 3;
        };
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(r);
        service.shutdown();

    }
}
