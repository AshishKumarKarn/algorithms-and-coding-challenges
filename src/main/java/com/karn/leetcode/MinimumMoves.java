package com.karn.leetcode;

import java.io.FileInputStream;
import java.util.Scanner;

public class MinimumMoves {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new FileInputStream("minimumMoves.txt"));
        int N = sc.nextInt();
        String[] leftRow = new String[N];
        String[] rightRow = new String[N];
        int[] left = new int[N];
        int[] right = new int[N];
        int sib = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            leftRow[i] = sc.next();
            rightRow[i] = sc.next();
            if ((leftRow[i].contains("M") && leftRow[i].contains("V"))
                    || (rightRow[i].contains("M") && rightRow[i].contains("V"))) {
                System.out.println(0);
                return;
            }
            if ((leftRow[i].contains("M") && rightRow[i].contains("V"))
                    || (rightRow[i].contains("M") && leftRow[i].contains("V"))) {
                sib = 2;
            }
            if (leftRow[i].contains("V")) {
                left[i] = 1;
            }

            if (rightRow[i].contains("V")) {
                right[i] = 1;
            }
            if (rightRow[i].contains("M")) {
                right[i] = 2;
                left[i] = 3;
            }
            if (leftRow[i].contains("M")) {
                left[i] = 2;
                right[i] = 3;
            }
        }
//        System.out.println(Arrays.toString(leftRow));
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(rightRow));
//        System.out.println(Arrays.toString(right));
        int distanceL1 = 0;
        int resultL1 = 0;
        int distanceL2 = 0;
        int resultL2 = 0;
        int distanceR1 = 0;
        int resultR1 = 0;
        int distanceR2 = 0;
        int resultR2 = 0;
        boolean startLeftCounterLeftRow = false;
        boolean startRightCounterLeftRow = false;
        boolean startLeftCounterRightRow = false;
        boolean startRightCounterRightRow = false;


        for (int i = 0, j = N - 1; i < N; i++, j--) {
            if (left[i] == 0 && !startLeftCounterLeftRow) {
                //do nothing
            } else if (left[i] == 0 && startLeftCounterLeftRow) {
                distanceL1++;
            } else if (left[i] == 1 && !startLeftCounterLeftRow) {
                startLeftCounterLeftRow = true;
            } else if (left[i] == 1 && startLeftCounterLeftRow) {
                distanceL1 = 0;
            } else if (left[i] == 2 && !startLeftCounterLeftRow) {
                resultL1 = Integer.MAX_VALUE;
            } else if (left[i] == 2 && startLeftCounterLeftRow) {
                resultL1 = distanceL1 + 1;
            } else if (left[i] == 3 && startLeftCounterLeftRow) {
                resultL1 = distanceL1 + 3;
            } else if (left[i] == 3 && !startLeftCounterLeftRow) {
                resultL1 = Integer.MAX_VALUE;
            }

            if (left[j] == 0 && !startRightCounterLeftRow) {
                //do nothing
            } else if (left[j] == 0 && startRightCounterLeftRow) {
                distanceL2++;
            } else if (left[j] == 1 && !startRightCounterLeftRow) {
                startRightCounterLeftRow = true;
            } else if (left[j] == 1 && startRightCounterLeftRow) {
                distanceL2 = 0;
            } else if (left[j] == 2 && !startRightCounterLeftRow) {
                resultL2 = Integer.MAX_VALUE;
            } else if (left[j] == 2 && startRightCounterLeftRow) {
                resultL2 = distanceL2 + 1;
            } else if (left[j] == 3 && startRightCounterLeftRow) {
                resultL2 = distanceL2 + 3;
            } else if (left[j] == 3 && !startRightCounterLeftRow) {
                resultL2 = Integer.MAX_VALUE;
            }

            if (right[i] == 0 && !startLeftCounterRightRow) {
                //do nothing
            } else if (right[i] == 0 && startLeftCounterRightRow) {
                distanceR1++;
            } else if (right[i] == 1 && !startLeftCounterRightRow) {
                startLeftCounterRightRow = true;
            } else if (right[i] == 1 && startLeftCounterRightRow) {
                distanceR1 = 0;
            } else if (right[i] == 2 && !startLeftCounterRightRow) {
                resultR1 = Integer.MAX_VALUE;
            } else if (right[i] == 2 && startLeftCounterRightRow) {
                resultR1 = distanceR1 + 1;
            } else if (right[i] == 3 && startLeftCounterRightRow) {
                resultR1 = distanceR1 + 3;
            } else if (right[i] == 3 && !startLeftCounterRightRow) {
                resultR1 = Integer.MAX_VALUE;
            }

            if (right[j] == 0 && !startRightCounterRightRow) {
                //do nothing
            } else if (right[j] == 0 && startRightCounterRightRow) {
                distanceR2++;
            } else if (right[j] == 1 && !startRightCounterRightRow) {
                startRightCounterRightRow = true;
            } else if (right[j] == 1 && startRightCounterRightRow) {
                distanceR2 = 0;
            } else if (right[j] == 2 && !startRightCounterRightRow) {
                resultR2 = Integer.MAX_VALUE;
            } else if (right[j] == 2 && startRightCounterRightRow) {
                resultR2 = distanceR2 + 1;
            } else if (right[j] == 3 && startRightCounterRightRow) {
                resultR2 = distanceR2 + 3;
            } else if (right[j] == 3 && !startRightCounterRightRow) {
                resultR2 = Integer.MAX_VALUE;
            }
        }
        int leftRowResult = Math.min(resultL1, resultL2);
        int rightRowResult = Math.min(resultR1, resultR2);
        System.out.println(Math.min(Math.min(leftRowResult, rightRowResult), sib));
    }
}
