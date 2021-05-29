package com.karn.algosolutions;

public class ThreadExecutionObserverTest implements Runnable {
    MyThread tr = new MyThread();

    public static void main(String[] args) {
        ThreadExecutionObserverTest testJava = new ThreadExecutionObserverTest();
        Thread t1 = new Thread(testJava, "t1");
        Thread t2 = new Thread(testJava, "t2");
        t1.start();
        t2.start();


    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("t1")) {
            tr.printKey();
        } else {
            tr.printValue();
        }

    }


}

class MyThread {

    public static synchronized void printKey() {
        try {
            System.out.println("printKey");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printValue() {
        System.out.println("printValue");
    }


}
