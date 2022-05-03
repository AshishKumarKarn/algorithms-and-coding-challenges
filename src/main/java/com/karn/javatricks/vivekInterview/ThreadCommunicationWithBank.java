package com.karn.javatricks.vivekInterview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadCommunicationWithBank {

    public static void main(String[] args) throws Exception {
       new ConcurrentHashMap();
        ExecutorService service = Executors.newFixedThreadPool(2);
        try {
            Callable<Integer> c1 = Portfolio::getBalance;
            Callable<Integer> c2 = Portfolio::getLoanAmount;
            List<Callable<Integer>> calls = List.of(c1, c2);

            Integer result = 0;
            long startTime = System.currentTimeMillis();
            List<Future<Integer>> results = new ArrayList<>();
            for (Callable<Integer> c : calls) {
                Future<Integer> submit = service.submit(c);
                results.add(submit);
            }
            for (Future<Integer> f : results) {
                result += f.get();
            }


            System.out.println(result);
            System.out.println(System.currentTimeMillis() - startTime + " ms");


            Callable<Integer> c3=Portfolio::getLastAmount;
            Future<Integer> submit = service.submit(c3);
            int finalResult = result + submit.get();
            System.out.println(finalResult);

        }catch (Exception e){
            System.out.println("Exception happened");
        }finally {
            service.shutdown();
        }
    }
}
class Portfolio{
    public static int getBalance(){
        //let's wait here
        System.out.println("invoked get balance");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Hi there");
//        return 500;
    }
    public static int getLoanAmount(){
        System.out.println("invoked get amount");
        //let's wait here
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 199;
    }

    public static int getLastAmount(){
        return 100;
    }
}
