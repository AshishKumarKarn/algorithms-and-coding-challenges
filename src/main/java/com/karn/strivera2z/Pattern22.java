package com.karn.strivera2z;

import java.util.Scanner;

public class Pattern22 {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int n = sc.nextInt();
            for (int i = n; i > 0; i--) {
                for (int j = n; j >= i ; j--) {
                    System.out.print(j+" ");
                }
                for (int j = i; j <= n ; j++) {
                    System.out.print(j+" ");
                }
                System.out.println();

            }
        }
    }
}
