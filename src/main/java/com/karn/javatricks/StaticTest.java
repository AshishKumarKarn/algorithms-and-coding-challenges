package com.karn.javatricks;

import java.io.FileNotFoundException;
import java.io.IOException;

public class StaticTest {
    public static void main(String[] args) {
        final String cl;
        A a=null;
        a.method();
    }
}
abstract class Parent{
    protected Object method(Object a) throws IOException {
        return null;
    }

//    public abstract String method(String st) throws FileNotFoundException;
}
class Child extends Parent{
    @Override
    public String method(Object st) throws FileNotFoundException {
        return null;
    }
}
class A{
    public static void method(){
        System.out.println("method");
    }

}
interface A1 {
    default void print(){}
}
interface B {
    default void print(){

    }
}
 class Test implements A1,B {


     @Override
     public void print() {
         A1.super.print();
     }
 }