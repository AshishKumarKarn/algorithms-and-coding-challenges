package com.karn.javatricks.features.switchexp;

public class SwitchTest {
    public static void main(String[] args) {
        switchTest("a");
    }

    private static void switchTest(String player) {
        switch (player) {
            case "a", "b", "c" -> System.out.println("small");
            case "A", "B", "C" -> System.out.println("large");
        }
    }
}
