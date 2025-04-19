package com.karn.javatricks.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        MyThread thread1=new MyThread("T1", countDownLatch);
        MyThread thread2=new MyThread("T2", countDownLatch);
        MyThread thread3=new MyThread("T3", countDownLatch);
        thread1.start();
        thread3.start();
        thread2.start();
        countDownLatch.await();
        System.out.println("Main also finished");

    }
}
class MyThread extends Thread{
    CountDownLatch latch;
    MyThread(String name, CountDownLatch latch){
        super(name);
        this.latch = latch;
    }
    @Override
    public void run() {
        System.out.println("Executing Thread"+this.getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished Thread"+this.getName());
        latch.countDown();
    }
}
