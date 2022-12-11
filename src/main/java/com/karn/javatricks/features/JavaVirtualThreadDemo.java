package com.karn.javatricks.features;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class JavaVirtualThreadDemo {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
//        virtualThread();
        platformThread();//oom
        System.out.println("End time "+(System.currentTimeMillis()-startTime));
    }

    private static void virtualThread(){
        try(var executor= Executors.newVirtualThreadPerTaskExecutor()){
            IntStream.range(0,100_000).forEach(
                    i->executor.submit(
                            ()->{
                                try {
                                    Thread.sleep(Duration.ofSeconds(1));
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                System.out.println(i);
                                return i;
                            }
                    )
            );
        }
    }
    private static void platformThread(){
        try(var executor= Executors.newThreadPerTaskExecutor(Executors.defaultThreadFactory())){
            IntStream.range(0,100_000).forEach(
                    i->executor.submit(
                            ()->{
                                try {
                                    Thread.sleep(Duration.ofSeconds(1));
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                System.out.println(i);
                                return i;
                            }
                    )
            );
        }
    }

}
