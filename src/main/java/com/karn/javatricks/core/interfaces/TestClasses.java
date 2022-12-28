package com.karn.javatricks.core.interfaces;

public class TestClasses {
    public static void main(String[] args) {
        Interface1 i1=new Class2();
        i1.method1();
        Interface2 i2=(Interface2) i1;
        i2.method2();
    }
}
interface Interface1{
    void method1();
}
class Class1 implements  Interface1{
    @Override
    public void method1() {
        System.out.println("class1 invoked");
    }
}
interface Interface2 extends Interface1{
    void method2();
}
class Class2 extends Class1 implements Interface2{

    @Override
    public void method2() {
        System.out.println("method2 invoked from class2");
    }
}