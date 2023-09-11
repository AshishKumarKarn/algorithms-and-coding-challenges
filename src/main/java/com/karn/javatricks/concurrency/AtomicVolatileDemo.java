package com.karn.javatricks.concurrency;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVolatileDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(1000);
        MyCallable callable = new MyCallable();
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            futures.add(service.submit(callable));
        }

        service.shutdown();
        Set<Integer> set=new HashSet<>();
        for (Future<Integer> future: futures){
            if(!set.add(future.get())){
                System.out.println("Dup");
            }
        }
        System.out.println(set.size()==1000);
    }

    static class MyCallable implements Callable<Integer> {
         AtomicInteger number = new AtomicInteger(0);

        @Override
        public Integer call() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //  System.out.println(number++);
            return number.getAndIncrement();
        }
    }
}

