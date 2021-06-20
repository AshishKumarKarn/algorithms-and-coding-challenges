package com.karn.youtube.errichto.lecture1;


import java.util.ArrayList;
import java.util.List;

/**
 * This program is an extension or alternate use of the analogy made in FindSumOfSubArrayPresentOrNot
 * program.
 *
 * @author Ashish Karn
 */
public class FindAllSubArrayOfAnArray {
    public static void main(String[] args) {
        int[] givenArray = {1, 3, 4, 2, 5};
        List<List<Integer>> allSubArray = new ArrayList<>();
        //O(2^N)
        for (int mask = 0; mask < 1 << givenArray.length; mask++) {
            List<Integer> subArray = new ArrayList<>();
            //O(2^N)*O(N)
            for (int i = 0; i < givenArray.length; i++) {
                if ((mask & 1 << i) == 0) {
                    subArray.add(givenArray[i]);
                }
            }
            allSubArray.add(subArray);
        }
        System.out.println(allSubArray);
    }
}
