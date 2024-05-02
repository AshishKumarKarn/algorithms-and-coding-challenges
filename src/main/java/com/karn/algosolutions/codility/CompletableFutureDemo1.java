package com.karn.algosolutions.codility;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureDemo1 {
    public static void main(String[] args) throws Exception{
        ExecutorService executor1  = Executors.newFixedThreadPool(2);
        ExecutorService executor2  = Executors.newFixedThreadPool(2);
        CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.supplyAsync(MyCallTask::invoke)
                .thenApplyAsync(MyCallTask::invoke2,executor1)
                .thenApplyAsync(MyCallTask::invoke2,executor2)
                .thenAcceptAsync(MyRunTask::invoke);
        CompletableFuture<Void> voidCompletableFuture2 = CompletableFuture.supplyAsync(MyCallTask::invoke)
                .thenApplyAsync(MyCallTask::invoke2,executor1)
                .thenApplyAsync(MyCallTask::invoke2,executor2)
                .thenAcceptAsync(MyRunTask::invoke);
        voidCompletableFuture1.get();
        voidCompletableFuture2.get();

        executor1.shutdown();
        executor2.shutdown();
    }
}

class MyCallTask {

    static List<Integer> invoke() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("call invoked " + Thread.currentThread().getName());
        return new ArrayList<>(List.of(1,2,3,4));
    }
    static List<Integer> invoke2(List<Integer> list) {//Function method signature
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("call function invoked "+ Thread.currentThread().getName());
        list.add(5);
        return list;
    }
}

class MyRunTask {
   static void invoke(List<Integer> i) {
       try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
        System.out.println("Run invoked with i = "+i+" " + Thread.currentThread().getName());
    }
}