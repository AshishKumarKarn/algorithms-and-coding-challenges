package com.karn.youtube.onlinehowtocode;

public class CoreJavaTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        MyClass myClass=MyClass.getInstance(23);
        MyClass myClass1=MyClass.getInstance(24);
        System.out.println(myClass==myClass1);
        System.out.println(myClass.hashCode());
        System.out.println(myClass1.hashCode());
        System.out.println(myClass1.getValue());
        MyClass myClass2 = (MyClass) myClass1.clone();
        System.out.println(myClass2.hashCode());



    }
}
enum MyEnum implements Cloneable{
    Val;
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
}
class MyClass implements Cloneable{
    private volatile static MyClass INSTANCE;
    public static MyClass getInstance(int value){
        if(INSTANCE==null){
            synchronized (MyClass.class){
                if(INSTANCE==null){
                    INSTANCE = new MyClass(value);
                }
            }
        }
        return INSTANCE;
    }
    private final int  value;

    private MyClass(int value){
        this.value=value;
    }
    public int getValue() {
        return value;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}