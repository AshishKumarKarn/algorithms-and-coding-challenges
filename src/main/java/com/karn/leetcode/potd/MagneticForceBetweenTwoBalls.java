package com.karn.leetcode.potd;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) throws Exception {
        MagneticForceBetweenTwoBalls magneticForceBetweenTwoBalls = new MagneticForceBetweenTwoBalls();
//        int[] position = {5,4,3,2,1,22};
//        int[] position = {1,2,3,4,7};
        Scanner sc = new Scanner(new FileInputStream("MagneticForceBetweenTwoBalls.txt"));
        String s = sc.nextLine();
        int[] positions = Arrays.stream(s.split(",")).mapToInt(Integer::valueOf).toArray();
        int m = 9301;
        long startTime = System.currentTimeMillis();
        System.out.println(magneticForceBetweenTwoBalls.maxDistance(positions, m));
        System.out.println("Time " + (System.currentTimeMillis() - startTime) + " ms");
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int max = position[position.length - 1];
        List<Integer> itemIndex = new ArrayList<>();
        Map<Integer, Integer> memory = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            memory.put(position[i], i);
            itemIndex.add(position[i]);
        }
        return binarySearch(1, max, position, m, itemIndex, memory);
    }

    public int binarySearch(int left, int right, int[] positions, int m, List<Integer> itemIndex, Map<Integer, Integer> memory) {

        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        boolean possible = isPossible(mid, positions, m, itemIndex, memory);
        if (possible) {
            return Math.max(mid, binarySearch(mid + 1, right, positions, m, itemIndex, memory));
        } else {
            return binarySearch(left, mid - 1, positions, m, itemIndex, memory);
        }

    }

    private boolean isPossible(int interval, int[] positions, int m, List<Integer> itemIndex, Map<Integer, Integer> memory) {
        int position = positions[0];
        int lastIndex = 0;
        while (m != 0) {
            int nextHigherNumber = -1;
            if (!memory.containsKey(position)) {
                for (int i = lastIndex; i < itemIndex.size(); i++) {
                    if (itemIndex.get(i) > position) {
                        nextHigherNumber = itemIndex.get(i);
                        lastIndex = i+1;
                        break;
                    }
                }
            } else {
                nextHigherNumber = position;
                lastIndex = memory.get(position);
            }

            if (nextHigherNumber == -1) {
                break;
            }
            m--;
            position = nextHigherNumber + interval;
        }
        return m == 0;
    }
}
