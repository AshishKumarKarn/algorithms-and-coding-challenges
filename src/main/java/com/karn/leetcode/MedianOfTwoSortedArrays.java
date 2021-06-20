package com.karn.leetcode;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(
                new int[]{},
                new int[]{}
        ));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int total = length1 + length2;
        if (total == 0) {
            return 0;
        }
        if (total == 1) {
            return length1 > length2 ? nums1[0] : nums2[0];
        }
        double[] finalArray = new double[total];
        for (int i = 0, j = 0, k = 0; i < total; i++) {
            if (k < length2 && j < length1) {
                if (nums1[j] >= nums2[k]) {
                    finalArray[i] = nums2[k];
                    k++;
                } else {
                    finalArray[i] = nums1[j];
                    j++;
                }
            } else if (j < length1) {
                //num2 still has some elements left
                finalArray[i] = nums1[j];
                j++;
            } else {
                //num1 still has some elements left
                finalArray[i] = nums2[k];
                k++;
            }
        }
        //even number of elements, means two elements to sum and take median
        int medIndex1 = total / 2;
        int medIndex2 = total / 2 - 1;
        if (total % 2 == 0) {
            return (finalArray[medIndex1] + finalArray[medIndex2]) / 2;
        }
        return finalArray[medIndex1];
    }
}
