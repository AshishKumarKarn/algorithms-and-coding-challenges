package com.karn.javatricks.concurrency;

import java.util.concurrent.*;

public class UsingExecutors {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        var futureArray = new Future[5];
        long start = System.currentTimeMillis();
        System.out.printf("Started at %s \n", start);
        for (int i = 0; i < 5; i++) {
            futureArray[i] = service.submit(new Task());
        }
        int total = 0;
        for (int i = 0; i < 5; i++) {
            total += (int) futureArray[i].get();
        }
        System.out.printf("completed in %s ms\n", (System.currentTimeMillis() - start));
        System.out.println(total);
        service.shutdown();

    }
}

class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("invoked");
        Thread.sleep(3000);
        int i = (int) (Math.random() * 100);
        System.out.printf("produced %s \n", i);
        return i;
    }
}
