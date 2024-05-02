package com.karn.algosolutions.codility;

import java.util.concurrent.*;

public class CompletableFutureDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
       /* CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(Task1::supply)
                .thenApply(a -> a * 2)
                .thenAccept(System.out::println);
        voidCompletableFuture.get(); // important to make it blocking here*/


        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(Task1::supply);
        CompletableFuture<Void> cf3=CompletableFuture.runAsync(()->{
            try {
                Thread.sleep(4001);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        cf3.get(4,TimeUnit.SECONDS);

       // cf3.get();//breaks the main thread if exception
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(Task1::supply);
        CompletableFuture<Integer> result = cf1.thenCombine(cf2, (a,b)->a*b);
        System.out.println("Result is "+result.get());
    }
    static class Task1{
        public static int supply(){
            System.out.println("Supply executed "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Supply finished "+Thread.currentThread().getName());
            return 2;
        }
    }

    /**
    public static void main(String[] args) throws Exception{


        //** execution of threads with exception
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.execute(Task1::execute);//no way to stop main thread if exception occurs
        Future<Integer> result1 = service.submit(Task2::execute1);//also this is eager
//        Future<Integer> result2 = service.submit(Task2::execute1);
//        int result = result2.get()+ result1.get();
//        System.out.println("Total result "+result);
        service.shutdown();

    }
    static class Task1{
        public static void execute(){
            try {
                System.out.println("Task1 execution started "+Thread.currentThread().getName());
                Thread.sleep(1000);
                var a =10/0;
                System.out.println("Task1 execution finished "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    static class Task2{
        public static int execute1(){
            try {
                System.out.println("Task2 execution1 started "+Thread.currentThread().getName());
                Thread.sleep(1000);
                System.out.println("Task2 execution1 finished "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 5;
        }
        public static int execute2(){
            try {
                System.out.println("Task2 execution2 started "+Thread.currentThread().getName());
                Thread.sleep(1000);
                System.out.println("Task2 execution2 finished "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 5;
        }
    }
    /**
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //** execution of threads with exception
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.execute(Task1::execute);
        Future<Integer> result2 = service.submit(Task2::execute);
        result2.get();
        service.shutdown();

    }
    static class Task1{
        public static void execute(){
            try {
                System.out.println("Task1 execution started "+Thread.currentThread().getName());
                Thread.sleep(1000);
                var a =10/0;
                System.out.println("Task1 execution finished "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    static class Task2{
        public static int execute(){
            try {
                System.out.println("Task2 execution started "+Thread.currentThread().getName());
                Thread.sleep(1000);
                System.out.println("Task2 execution finished "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 5;
        }
    }*/
}
