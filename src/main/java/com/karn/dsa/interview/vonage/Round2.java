package com.karn.dsa.interview.vonage;

public class Round2 {

    public static void main(String[] args) throws Exception {
        new Round2().print(5);

    }
    public void print(Integer n) {
        Object lock=new Object();
        Runnable r1 =() -> {
            int counter=0;
            while (counter != 100) {
                counter++;
                synchronized (lock) {
                    try {
                        lock.wait(1000);
                        System.out.println("Foo");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();
                }
            }
        };
        Runnable r2 =() -> {
           int counter=0;
            while (counter != 100) {
                counter++;

                synchronized (lock) {
                    lock.notify();
                    try {
                        lock.wait(1000);
                        System.out.println("Bar");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        };

        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);
        t1.start();
       // t1.join();
        t2.start();
    }
}
