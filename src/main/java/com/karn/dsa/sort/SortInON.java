package com.karn.dsa.sort;

import java.util.BitSet;

/**
 * Constraint 1:
 * Input numbers to be either 0 or positive, and no duplicates.
 * Constraint 2:
 * Max value present in the input array is equal to length
 * of the input array.
 *
 * @author Ashish Karn
 */
public class SortInON {

    public void sort(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }
        BitSet bitSet = new BitSet(max);
        for (int num : nums) {
            bitSet.set(num);
        }
        for (int i = 0, j = 0; i < bitSet.length(); i++) {
            if (bitSet.get(i)) {
                nums[j] = i;
                j++;
            }
        }
    }
}
