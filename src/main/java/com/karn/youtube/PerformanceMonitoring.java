package com.karn.youtube;

public class PerformanceMonitoring {
    public static void main(String[] args) throws Exception {
        while (true)
        {
            new MyObject();
//            Thread.sleep(1);
        }
    }
}
class MyObject{
    @Override
    protected void finalize() throws Throwable {
        System.out.println("GC called on OBJECT="+this);
    }
}
