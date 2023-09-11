package com.karn.javatricks.java8;

import java.util.Date;

public class JodaTimeAPIDemo {
    public static void main(String[] args) {
        Date date = new Date();
        int day = date.getDate();
        System.out.println(day);
    }
}
