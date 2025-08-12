package com.karn.javatricks.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;

public class SerializableDemos {

    private static final String FILE = "file.sera";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MySerializableCantBeSingleton myObj = MySerializableCantBeSingleton.getInstance();
        myObj.setName("Karn");
        myObj.setPersonNumber("1234567890");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE));
        oos.writeObject(myObj);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE));
        MySerializableCantBeSingleton anotherObject = (MySerializableCantBeSingleton) ois.readObject();
        System.out.println(myObj.hashCode());
        System.out.println(anotherObject.hashCode());
        System.out.println(myObj.getName());
        System.out.println(anotherObject.getName());
        System.out.println(myObj.getPersonNumber());
        System.out.println(anotherObject.getPersonNumber());
    }
}

class MySerializableCantBeSingleton implements Serializable {
    private MySerializableCantBeSingleton() {
    }

    private static volatile MySerializableCantBeSingleton INSTANCE;

    public static MySerializableCantBeSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (MySerializableCantBeSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MySerializableCantBeSingleton();
                }
            }
        }
        return INSTANCE;
    }

    private String name;
    private transient String personNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
    }
    // readResolve() method is not called during deserialization
    //@Serial //recommended for code clarity only=> Object readResolve() should be the signature
//    private Object readResolve() {
//        return getInstance();
//    }

}