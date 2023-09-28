package com.karn.javatricks.java8;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class JodaTimeAPIDemo {
    public static void main(String[] args) {
        Date date = new Date();
        int day = date.getDate();
        System.out.println(day);
        Queue<Integer> q = new LinkedList<>();
        q.poll();
    }
}
