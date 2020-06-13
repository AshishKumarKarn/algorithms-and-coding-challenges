package com.karn.algosolutions;

import java.util.Arrays;

/**
 * @author Ashish Karn
 * <p>
 *     
 * An array A consisting of N integers is given. Rotation of the array means that each element
 * is shifted right by one index, and the last element of the array is moved to the first place.
 * For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]
 * (elements are shifted right by one index and 6 is moved to the first place).
 */

public class CyclicRotation {
    public static void main(String[] args) {
        int[] array = {3, 8, 9, 7, 6};
        int K = 8;
        //Solution should be [9, 7, 6, 3, 8]
        rotateClockWiseUsingClonedBackup(array, K);
        System.out.println(Arrays.toString(array));

        int[] array2 = {3, 8, 9, 7, 6};
        int K2 = 3;
        //Solution should be [9, 7, 6, 3, 8]
        //rotateClockWise(array2, K2);
        //System.out.println(Arrays.toString(array2));
    }

    private static void rotateClockWiseUsingClonedBackup(int[] array, int k) {
        int[] arrayBackup = array.clone();
        for (int i = 0; i < array.length; i++) {
            int newPosition = (i + k) % array.length;
            array[newPosition] = arrayBackup[i];
        }
    }
}
