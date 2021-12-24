package com.karn.quora;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SortLinkedList {
    public static void main(String[] args) {
        List<Employee> employeeList = new LinkedList<>();

        employeeList.add(new Employee(1L,"Ashish"));
        employeeList.add(new Employee(3L,"Dinesh"));
        employeeList.add(new Employee(2L,"RandomName"));
        //Java 8
        //preferred
        employeeList.sort(Comparator.comparing(Employee::getId));
        System.out.println(employeeList);

        //or Collections.sort(employeeList, Comparator.comparing(Employee::getName));

        //Java 7
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println(employeeList);
        System.out.println('4'-'0');

    }

    private static class Employee {
        private Long id;
        private String name;

        Employee(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
