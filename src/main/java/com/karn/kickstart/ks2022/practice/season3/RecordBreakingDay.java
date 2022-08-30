package com.karn.kickstart.ks2022.practice.season3;

import java.util.Scanner;

import java.util.*;
public class RecordBreakingDay {
}

 class Solution {

    public static int numberOfRecordBreakingDays(int numberOfDays, int[] visitors) {
        int recordBreakingDays = 0;
        int maxTillLastElement = 0;
        if(numberOfDays == 1){
            return 1;
        }
        if(visitors[0]>visitors[1]){
            recordBreakingDays++;
        }
        for (int i = 1; i < numberOfDays; i++) {

            maxTillLastElement = Math.max(maxTillLastElement, visitors[i-1]);
            if(visitors[i]>maxTillLastElement){
                if(i<numberOfDays-1&&visitors[i]<=visitors[i+1]){
                    recordBreakingDays--;
                }
                recordBreakingDays++;
            }
        }
        return recordBreakingDays;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Get number of test cases in input
        int testCaseCount = scanner.nextInt();
        // Iterate through test cases
        for (int tc = 1; tc <= testCaseCount; ++tc) {
            // Get number of days for this test case
            int numberOfDays = scanner.nextInt();
            // Get attendance for each day
            int[] visitorsPerDay = new int[numberOfDays];
            for (int d = 0; d < numberOfDays; ++d) {
                visitorsPerDay[d] = scanner.nextInt();
            }
            // Print results
            int answer = numberOfRecordBreakingDays(numberOfDays, visitorsPerDay);
            System.out.println("Case #" + tc + ": " + answer);
        }
    }
}

