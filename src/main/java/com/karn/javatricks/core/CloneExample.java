package com.karn.javatricks.core;

import java.util.HashMap;

public class CloneExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        HashMap map = new HashMap();

        MyCloneable cloneable = new MyCloneable();
        MyCloneable clone = (MyCloneable) cloneable.clone();
        System.out.println(cloneable.hashCode());
        System.out.println(clone.hashCode());
        System.out.println(clone.a);
    }
}
class MyCloneable implements Cloneable{
     int a = 6;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}