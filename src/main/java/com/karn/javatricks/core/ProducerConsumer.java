package com.karn.javatricks.core;

import java.util.ArrayDeque;
import java.util.Queue;

public class ProducerConsumer {
    private static final Queue<Integer> queue = new ArrayDeque<>();
    public static void main(String[] args) {
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();

    }
}
class Producer implements Runnable{
    private final Queue<Integer> queue;
    Producer(Queue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        int count = 0;
        if (queue.isEmpty()){
            while (true) {
                count++;
                if (count > 10) {
                    break;
                }
                queue.add(count);
                System.out.println("Produced "+count);
            }
        }
        synchronized (queue) {
            queue.notify();
        }
    }
}
class Consumer implements Runnable{
    private final Queue<Integer> queue;
    Consumer(Queue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        if(queue.isEmpty()||queue.size()<=10){
           synchronized (queue){
               try {
                   System.out.println("waiting for producer to produce message and notify current thread");
                   queue.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            System.out.println("Consumed "+poll);
        }
    }
}
