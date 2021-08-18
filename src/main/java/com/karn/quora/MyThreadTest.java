package com.karn.quora;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class MyThreadTest {
    public static void main(String[] args) {
        List<Integer> myList =new ArrayList<>();
        myList.add(3);
        myList.add(6);
        myList.add(7);
        myList.add(8);
        myList.add(9);
        System.out.printf("old list %s %n", myList);
        myList.set(4,5);
        System.out.printf("updated list %s %n",myList);

    }


}
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.printf("I am executing Thread >>> %s %n", Thread.currentThread().getName());
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.printf("I am executing Runnable>>> %s  %n", Thread.currentThread().getName());
    }
}