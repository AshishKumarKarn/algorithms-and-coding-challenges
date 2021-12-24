package com.karn.techgig;

import java.util.Arrays;
import java.util.Scanner;

public class DishaMarket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int items = sc.nextInt();
        int[] price = new int[items];
        int budget = sc.nextInt();
        for (int i = 0; i < items; i++) {
            price[i] = sc.nextInt();
        }
        Arrays.sort(price);
        int expense = 0, count = 0;

        for (int i = 0; i < items; i++) {
            expense = expense + price[i];
            if (i == items - 1) {
                i = -1;
            }
            if (expense <= budget) {
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}
