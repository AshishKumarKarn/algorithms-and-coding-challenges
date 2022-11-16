package com.karn.javatricks.concurrency;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.*;

public class UsingExecutors {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService service = Executors.newCachedThreadPool();
//        var futureArray = new Future[5];
//        long start = System.currentTimeMillis();
//        System.out.printf("Started at %s \n", start);
//        for (int i = 0; i < 5; i++) {
//            futureArray[i] = service.submit(new Task());
//        }
//        int total = 0;
//        for (int i = 0; i < 5; i++) {
//            total += (int) futureArray[i].get();
//        }
//        System.out.printf("completed in %s ms\n", (System.currentTimeMillis() - start));
//        System.out.println(total);
//        service.shutdown();
        Task task = new Task();
        int[] ar={1,2,3};
        int[] ints = Arrays.copyOf(ar, ar.length);
        System.out.println(Arrays.toString(ints));

        ExecutorService pool=Executors.newCachedThreadPool();
        var arr=new CompletableFuture[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = CompletableFuture.supplyAsync(task::call,pool)
                    .thenApplyAsync(a -> a + task.call(),pool)
                    .thenApplyAsync(a -> a + task.call(),pool)
                    .thenApplyAsync(a -> a + task.call(),pool)
                    .thenApplyAsync(a -> a + task.call(),pool)
                    .thenAccept(System.out::println);
        }
        for (int i = 0; i < 10; i++) {
            arr[i].join();
        }




    }
}

class Task implements Callable<Integer> {

    @Override
    public Integer call()  {
        System.out.printf("invoked by %s \n", Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = (int) (Math.random() * 100);
        System.out.printf("produced %s \n", i);
        return i;
    }
}

class DemoTask{
    static Integer call() throws Exception{
        System.out.printf("invoked by %s \n", Thread.currentThread().getName());
        Thread.sleep(3000);
        int i = (int) (Math.random() * 100);
        System.out.printf("produced %s \n", i);
        return i;
    }
}