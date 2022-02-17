package com.karn.kickstart.ks2022.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int length = in.nextInt();
            int kidCount = in.nextInt();
            int totalCandies=0;
            for (int j = 0; j < length; j++) {
                totalCandies += in.nextInt();
            }
            int share=1;
            while((share*kidCount) < totalCandies){
                share++;
            }
            int output = totalCandies - ((share - 1) * kidCount);
            if(output<0){
                System.out.println("Case #" + i + ": " + 0);
                continue;
            }
            System.out.println("Case #" + i + ": " + output);
        }
    }

}
