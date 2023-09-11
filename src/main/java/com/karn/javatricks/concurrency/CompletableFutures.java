package com.karn.javatricks.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CompletableFutures {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService service = Executors.newFixedThreadPool(4);
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            futures.add(CompletableFuture.supplyAsync(() -> {
                        try {
                            return getData();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }).
                    thenApplyAsync(ad -> {
                        return ad.stream().map(m -> {
                            System.out.println("First " + Thread.currentThread().getName()+" "+m);
                            return m + 1;
                        }).collect(Collectors.toList());
                    },service).
                    thenApplyAsync(ad -> {
                        return ad.stream().map(m -> {
                            System.out.println("Second " + Thread.currentThread().getName()+" "+m);
                            return m + 1;
                        }).collect(Collectors.toList());
                    },service).thenAccept(System.out::println));
        }
        for (int i = 0; i < futures.size(); i++) {
            Void unused = futures.get(i).get();
        }
        service.shutdown();

    }

    static List<Integer> getData() throws Exception{
        Thread.sleep(1000);
        return List.of(1, 2, 3, 3, 2, 3);
    }
//    public static void main(String[] args) {
//        AtomicInteger in=new AtomicInteger(1);
//        MyRunnable runnable = new MyRunnable(in);
//        ExecutorService service = Executors.newCachedThreadPool();
//        for (int i = 0; i < 4; i++) {
//            service.submit(runnable);
//        }
//        service.shutdown();
//    }
class MyRunnable implements Runnable {
    AtomicInteger i;

    MyRunnable(AtomicInteger i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("executing " + i + " Thread >>" + Thread.currentThread().getName());
        if (i.getAndIncrement() == 2) {
            throw new RuntimeException("Intentional ");
        }


    }
}
}

