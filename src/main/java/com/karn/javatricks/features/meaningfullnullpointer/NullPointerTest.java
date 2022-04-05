package com.karn.javatricks.features.meaningfullnullpointer;

import java.util.Locale;

public class NullPointerTest {
    public static void main(String[] args) {
        Person p=new Person();

//        Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.toLowerCase()" because "p.name" is null
//	at com.karn.javatricks.features.meaningfullnullpointer.NullPointerTest.main(NullPointerTest.java:8)
        //System.out.println(p.name.toLowerCase());

        p=null;

        //Exception in thread "main" java.lang.NullPointerException: Cannot read field "name" because "p" is null
        //	at com.karn.javatricks.features.meaningfullnullpointer.NullPointerTest.main(NullPointerTest.java:14)
        System.out.println(p.name);
    }
}
class Person{
    String name;
}