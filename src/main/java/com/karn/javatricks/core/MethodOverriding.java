package com.karn.javatricks.core;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class MethodOverriding {
    public static void main(String[] args) {
        Employee emp1=new Employee();
        emp1.name="Ashish";
        emp1.age="31";
        emp1.salary = 23232;
        Employee emp2=new Employee();
        emp2.name="Neeraj";
        emp2.age="30";
        emp2.salary = 23232;
        Set<Employee> employeeSet = new TreeSet<>();
        employeeSet.add(emp2);
        employeeSet.add(emp1);
        System.out.println(employeeSet);
        Set<Employee> employeeSet2 = new TreeSet<>(Comparator.comparing(a -> a.age));
        employeeSet2.add(emp2);
        employeeSet2.add(emp1);
        System.out.println(employeeSet2);
    }
}
class Parent{
    public static String method1(){
        System.out.println("Parent");
        return "Parent";
    }
}
class Child extends Parent{

    public static String method1(){
        System.out.println("Child");
        return "Child";
    }
}
class Employee implements Comparable<Employee>{
    String name;
    String age;
    double salary;
    @Override
    public int compareTo(Employee o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}