package com.karn.javatricks.core.interfaces.abstractclasses;

public class MyAbsTest {
    public static void main(String[] args) {
       // MyAbs1 abs1= () -> System.out.println("Hello");
    }
}
abstract class MyAbs1 {
    public int speed;
    MyAbs1(int s){
        this.speed=s;
    }
    public abstract void method();
}
class A extends MyAbs1{

    A(int s) {
        super(s);
    }

    @Override
    public void method() {

    }
}
interface AI{
    public static final String name="";
}