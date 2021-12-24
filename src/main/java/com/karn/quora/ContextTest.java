package com.karn.quora;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ContextTest {
    public static void main(String[] args) throws NamingException {

        Context context=new InitialContext();
//        context.bind("java:com/env/object", new MyObject());
        MyObject object =(MyObject) context.lookup("java:com/env/object");
        MyObject object2 =(MyObject) context.lookup("java:object");
        System.out.println(object==object2);


    }
    static class MyObject{
        String propName;
    }
}
