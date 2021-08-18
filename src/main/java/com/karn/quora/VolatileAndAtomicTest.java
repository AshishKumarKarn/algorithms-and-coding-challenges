package com.karn.quora;

import java.util.concurrent.atomic.AtomicBoolean;

public class VolatileAndAtomicTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread0=new Thread(new ARunnable());
        Thread thread1=new Thread(new ARunnable2());
        thread0.start();
        thread1.start();


    }
}
class ARunnable implements Runnable{
    private AtomicBoolean flag=new AtomicBoolean();
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(this.flag.getAndSet(!flag.get())+" Thread "+Thread.currentThread().getName());
            try {
                synchronized (this) {
                    this.wait(5000);
                    System.out.println("notified or time out");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
class ARunnable2 implements Runnable{
    private AtomicBoolean flag=new AtomicBoolean();
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (this){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.notifyAll();
            }
            System.out.println(this.flag.getAndSet(!flag.get())+" Thread "+Thread.currentThread().getName());
        }

    }
}
