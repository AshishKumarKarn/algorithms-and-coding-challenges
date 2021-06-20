package com.karn.youtube.errichto.lecture2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * There are N <= 5000 Workers. Each worker is available during some days of a month.
 * Find two workers with maximum intersection of their Schedule.
 * <p>
 * Illustration:
 * 2, 3, 5, 6, 8
 * 2, 4, 5, 8
 * 1, 2, 10, 12, 14, 16
 * Output: 3
 * Worker one works on 2nd 5th and 8th day that also matches with 2nd worker's schedule.
 * This is maximum intersection of schedules between any two worker. So, output is 3.
 *
 * @author Ashish Karn (reference Errichto lecutre)
 */
public class FIndMaxCommonDayForNWorkers {
    public static void main(String[] args) {
        int[] W1 = {2, 3, 5, 6, 8};
        int[] W2 = {2, 4, 5, 8};
        int[] W3 = {1, 2, 10, 12, 14, 16};
        List<int[]> scheduleList = Arrays.asList(W1, W2, W3);
        System.out.println(solve(scheduleList));
    }

    private static int solve(List<int[]> scheduleList) {
        //convert all int[] in list to corresponding binary representation
        List<Integer> binaryList = scheduleList.stream().map(FIndMaxCommonDayForNWorkers::getBinary).collect(Collectors.toList());
        int max = 0;
        for (int i = 0; i < binaryList.size() - 1; i++) {
            Integer w_current = binaryList.get(i);

            for (int j = i + 1; j < binaryList.size(); j++) {
                Integer w_compareTo = binaryList.get(j);
                int schedules = countOnesAlternative3(w_current & w_compareTo);
                if (schedules > max) {
                    max = schedules;
                }
            }
        }
        return max;
    }

    private static int countOnesAlternative1(int a) {
        int orig = a;
        int count = 0;
        while (a > 0) {
            a = a >> 1 << 1;//right shift eliminates last bit and undoing it will set last bit 0
            //if the new value of a is same as old means last bit was 0 otherwise 1
            if (a != orig)
                count++;
            //right shift to check next bit
            orig = a >> 1;
            a = orig;
        }
        return count;
    }

    private static int countOnesAlternative2(int a) {
        int orig = a;
        int count = 0;
        while (orig > 0) {
            count += orig & 1;
            orig = orig >> 1;
        }
        return count;
    }
    private static int countOnesAlternative3(int a) {
        return Integer.bitCount(a);
    }
    private static int countOnesAlternative4(long a) {
        return Long.bitCount(a);
    }

    private static int getBinary(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result |= 1 << arr[i];
        }
        return result;
    }
}
