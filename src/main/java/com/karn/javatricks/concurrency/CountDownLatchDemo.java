package com.karn.javatricks.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        MyThread thread1=new MyThread("T1", countDownLatch1);
        thread1.start();
        countDownLatch1.await();
        CountDownLatch countDownLatch2 = new CountDownLatch(1);
        MyThread thread2=new MyThread("T2", countDownLatch2);
        thread2.start();
        countDownLatch2.await();
        CountDownLatch countDownLatch3 = new CountDownLatch(1);
        MyThread thread3=new MyThread("T3", countDownLatch3);
        thread3.start();
        countDownLatch3.await();

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
