package com.karn.javatricks.core;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternalizableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Example usage of ExternalizableClass
        ExternalizableClass externalizableObject = new ExternalizableClass();
        externalizableObject.name = "Karn";
        externalizableObject.personNumber = "1234567890";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("externalizable.ser"));
        oos.writeObject(externalizableObject);
        oos.close();
        System.out.println("Externalizable object serialized successfully.");
        // To deserialize, you would use ObjectInputStream
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("externalizable.ser"));
        ExternalizableClass deserializedObject = (ExternalizableClass) ois.readObject();
        System.out.println("Deserialized name: " + deserializedObject.name);
        // personNumber will not be available since it is transient
        System.out.println("Deserialized personNumber: " + deserializedObject.personNumber);
        ois.close();
    }
}

class ExternalizableClass implements Externalizable {

    public String name;
    public transient String personNumber;

    public ExternalizableClass() {
        // Default constructor is required for Externalizable
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        // personNumber is transient, so it won't be serialized
         out.writeObject(personNumber); // Uncommenting this line will cause an java.io.OptionalDataException
        // because personNumber is transient and not serialized
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        // personNumber will not be read since it is transient
         personNumber = (String) in.readObject(); // Uncommenting this line will cause an java.io.OptionalDataException
    }
}