package com.karn.javatricks;

public class TestEnumCast {
    public static void main(String[] args) {
        String name = String.valueOf(MyName.ASHISH);
        System.out.println(name);
    }
}

enum MyName {
    ASHISH(12), NEHA(14);
    private int value;

    MyName(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}