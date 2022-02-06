package com.karn.quora;

import java.util.StringJoiner;

public class ObjectTestJava {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        String abc = "abc";
        myObject.name = "Alok";
        new ObjectTestJava().process(myObject, abc);
        System.out.println(myObject);
        System.out.println(abc);
    }

    private void process(MyObject myObject, String abc) {
        myObject.name = "ashish";
        myObject.age = 23;
        abc = "def";
    }
}

class MyObject {
    public String name;
    public int age;

    @Override
    public String toString() {
        return new StringJoiner(", ", MyObject.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .toString();
    }
}