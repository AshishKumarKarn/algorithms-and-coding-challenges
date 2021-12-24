package com.karn.algosolutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

public class JavaTest {
    public static void main(String[] args) {
        Map<Employee, Employee> employeeMap = new HashMap<>(1,4);
        employeeMap.put(new Employee("1", "Ashish"),new Employee("1", "Ashish") );
        employeeMap.put(new Employee("1", "Ashish"),new Employee("1", "Ashish") );
        System.out.println(employeeMap);
    }
    private static class Employee{
        String name;
        String id;
        Employee(String id,String name){
            this.id=id;
            this.name=name;
        }

        @Override
        public boolean equals(Object o) {
            return false;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
                    .add("name='" + name + "'")
                    .add("id='" + id + "'")
                    .toString();
        }
    }
}
