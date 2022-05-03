package com.karn.javatricks.vivekInterview;

public class LabelTest {
    public static void main(String[] args) {
        vivek:
        for (int i = 0; i < 10; i++) {
            System.out.println("executing outer loop start");
            for (int j = 0; j < 5; j++) {
                System.out.println("executing inner loop start");
                if (j == 3) {
                    System.out.println("Mission accomplished");
                    break vivek;
                }
                System.out.println("executing inner loop end");
            }
            System.out.println("executing outer loop end");

        }
        System.out.println("program exits");
    }
}
