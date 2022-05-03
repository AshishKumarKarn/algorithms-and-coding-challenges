package com.karn.javatricks.features;

public class VarTest {
    public static void main(String[] args) {
        var record=new MyComplexObjectIdoNtWantToCast();
        record.method();
        System.out.println(record);
    }
}
class MyComplexObjectIdoNtWantToCast{
    void method(){
        System.out.println("Method");
    }
    @Override
    public String toString() {
        return "This is String";
    }
}
