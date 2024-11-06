package com.karn.javatricks.core.multithreading;

public class ExceptionHandelingInThread {

    public static void main(String[] args) throws Exception {
        Thread.UncaughtExceptionHandler handler = (t, e) -> System.out.println("caught it " + e.getMessage() + " in " + t.getName());
        Runnable task = () -> {

            if (Thread.currentThread().getName().contains("1")) {
                throw new RuntimeException("\"Intentional thread exception\"");
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread processing " + i + " name" + Thread.currentThread().getName());
            }


        };
        Thread t1 = new Thread(task);
        t1.setUncaughtExceptionHandler(handler);
        Thread t2 = new Thread(task);
        t2.setUncaughtExceptionHandler(handler);


        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}
