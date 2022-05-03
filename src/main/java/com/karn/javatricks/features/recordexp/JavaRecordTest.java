package com.karn.javatricks.features.recordexp;

public class JavaRecordTest {
    public static void main(String[] args) {
        EmployeeRecord employeeRecord = new EmployeeRecord("Ashish",2l,120d);
        System.out.println(employeeRecord);
        System.out.println(employeeRecord.name());
    }
}

