package com.karn.javatricks.vivekInterview;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;


//All about singleton
public class JavaQ1 {
    public static void main(String[] args) throws Exception{
        MySingletonInstance instance1 = MySingletonInstance.VIVEK;
        Object obj1=instance1.getInstance();

        MySingletonInstance instance2 = MySingletonInstance.VIVEK;
        Object obj2=instance2.getInstance();

        System.out.println(instance2==instance1);

//        MySingleton INSTANCE1 = MySingleton.MY_INSTANCE;
//        MySingleton INSTANCE2 = MySingleton.MY_INSTANCE;
//        System.out.println(INSTANCE1==INSTANCE2);
//        MySingleton INSTANCE3= INSTANCE1.clone();
//        System.out.println(INSTANCE2==INSTANCE3);
//        FileOutputStream fos = new FileOutputStream("file.ser");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(INSTANCE1);
//
//        FileInputStream fis=new FileInputStream("file.ser");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        MySingleton INSTANCE3 = (MySingleton) ois.readObject();
//
//        System.out.println(INSTANCE3 == INSTANCE1);

        Class<MySingleton> mySingletonClass = MySingleton.class;
        Constructor<?>[] declaredConstructors = mySingletonClass.getDeclaredConstructors();
        Constructor<?> declaredConstructor = declaredConstructors[0];
        declaredConstructor.setAccessible(true);
        MySingleton INSTANCE4 = (MySingleton) declaredConstructor.newInstance();

       // System.out.println(INSTANCE1==INSTANCE4);

    }
}
//BREAK SINGLETON
//1. CLONEABLE
//2. SERDE
//3. REFLECTION
//LAZY LOADING
class MySingleton{
    private MySingleton() {

    }
    private static volatile MySingleton MY_INSTANCE = null;
    //read resolve method

    //doubly checked
    public static MySingleton getInstance(){

        if(MY_INSTANCE == null) {

            synchronized (MySingleton.class) {
                if (MY_INSTANCE == null) {
                    MY_INSTANCE = new MySingleton();
                }
            }
        }
        //100000
        return MY_INSTANCE;
    }
}
enum MySingletonInstance{
    VIVEK,ASHISH;
    public Object getInstance(){
        new ArrayList<>(2);
        return this;
    }
}