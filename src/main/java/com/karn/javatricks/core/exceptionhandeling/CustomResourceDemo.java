package com.karn.javatricks.core.exceptionhandeling;

public class CustomResourceDemo {
    public static void main(String[] args) {
        MyResource resource1 = new MyResource();
        MyResource resource2 = new MyResource();
        try(resource1;resource2){
            System.out.println("Executing try");
        }catch (Exception e){
            System.out.println("caught "+e.getMessage());
        }
    }
}
class MyResource implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Closing");
        throw new RuntimeException("expected exception");
    }
}
