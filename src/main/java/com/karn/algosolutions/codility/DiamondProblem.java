package com.karn.algosolutions.codility;

public class DiamondProblem {


    public static void main(String[] args) {
        A a=new I();
        a.method();
        a.dp();
    }
}
interface A{
    void method();
    default void dp(){
        System.out.print("A");
    }
}
interface B{
    default void dp(){
        System.out.print("B");
    }
    void method();
}
class I implements A,B{
    public void method(){
        System.out.print("Hello");
    }

    @Override
    public void dp() {
        A.super.dp();
        B.super.dp();
    }
}