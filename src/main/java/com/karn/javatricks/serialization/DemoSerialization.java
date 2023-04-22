package com.karn.javatricks.serialization;

import java.io.*;

public class DemoSerialization {
//    @Serial

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "file.ser";
   /*
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fileName));
        SomeClass sc=new SomeClass();
        sc.name="Ashish";
        sc.moto="sharing";
        SomeOtherClass soc=new SomeOtherClass();
        soc.name="Ashish";
        soc.moto="sharing";
        oos.writeObject(soc);
        oos.writeObject(sc);
  */
//         /*
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fileName));
        SomeOtherClass outputOtherObject= (SomeOtherClass)ois.readObject();
        SomeClass outputObject = (SomeClass)ois.readObject();
        System.out.println(outputObject);
        System.out.println(outputOtherObject);
        System.out.println(outputObject.hashCode());
        System.out.println(outputOtherObject.hashCode());
//      */
    }
}
class SomeClass implements Serializable{
   @Serial
  private static final long serialVersionUID = 2L;

    public String name;
    public String moto;
    public String age;

    @Override
    public String toString() {
        return "SomeClass{" +
                "name='" + name + '\'' +
                ", moto='" + moto + '\'' +
                '}';
    }
}
class SomeOtherClass extends SomeClass{
    @Serial
    private static final long serialVersionUID = 2L;

    @Override
    public String toString() {
        return "SomeOtherClass{" +
                "name='" + name + '\'' +
                ", moto='" + moto + '\'' +
                '}';
    }
}