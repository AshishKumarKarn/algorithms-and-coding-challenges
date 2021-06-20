package com.karn.algosolutions;

public class OpenText {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 0, 0, 1, 1, 0};
        //ans 4 starting 0
        System.out.println(solution(arr));

    }

    private static int solution(int[] arr) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                if (arr[i] != 1) {
                    count1++;
                }else {
                    count2++;
                }
            } else {
                if (arr[i] != 0) {
                    count1++;
                }else{
                    count2++;
                }
            }
        }
        return Math.min(count1, count2);
    }
}
