package com.karn.youtube.onlinehowtocode;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws Exception{
      //  Integer.MAX_VALUE;
        Child a=new Child();
        a.setId(1);
        a.setName("Ashish");
        Child b= (Child) a.clone();
        System.out.println(a.hashCode());
        System.out.println(a);
        System.out.println(b.hashCode());
        System.out.println(b);

        b.setId(2);
        System.out.println(b.hashCode());
        System.out.println(b);
        System.out.println(a);

    }

}
class Child extends MyClassA implements Cloneable{
    @Override
    public String toString() {
        return "Child{" +
                "childProp='" + childProp + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    private String childProp;

    public String getChildProp() {
        return childProp;
    }

    public void setChildProp(String childProp) {
        this.childProp = childProp;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class MyClassA {
    protected int id;
    protected String name;

    public void setName(String name) {
        this.name = name;
    }


    public void setId(int id) {
        this.id = id;
    }


}
