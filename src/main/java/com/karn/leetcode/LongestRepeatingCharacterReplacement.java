package com.karn.leetcode;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int result = 0;
        int[] arr = new int[26];
        for (int leftCursor = 0, rightCursor = 0; rightCursor < s.length() && leftCursor <= rightCursor; ) {

            arr[s.charAt(rightCursor) - 'A']++;

            int maxCount = 0;
            for (int l = 0; l < 26; l++) {
                maxCount = Math.max(maxCount, arr[l]);
            }
            int lengthFromLeftToRightCursor = (rightCursor - leftCursor + 1);
            int numberOfCharacterNeedsToBeReplaced = lengthFromLeftToRightCursor - maxCount;
            if (numberOfCharacterNeedsToBeReplaced <= k) {
                result = Math.max(result, lengthFromLeftToRightCursor);
                rightCursor++;
            } else {
                /*
                 * remove left cursor character as shifting it towards right would eliminate a character from left side
                 * removing right cursor character as we are not affecting right cursor, and it would anyway be added
                 * at line 10, so removing redundant occurrence
                 */
                arr[s.charAt(leftCursor) - 'A']--;
                arr[s.charAt(rightCursor) - 'A']--;
                leftCursor++;
            }
        }
        return result;
    }


    /*public int characterReplacement(String s, int k) {
        String back = s;
        s = "-"+s+"-";
        char[] arr = s.toCharArray();
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = k;
            int length;
            int left = 1;
            int right = 1;
            for (int j = i + 1; j < arr.length ; j++) {
                if (arr[j] != arr[i] && count > 0) {
                    count--;
                    left++;
                } else if (arr[j] != arr[i] && count == 0) {
                    break;
                } else if (arr[j] == arr[i]) {
                    left++;
                }
            }
            count = k;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] != arr[i] && count > 0) {
                    count--;
                    right++;
                } else if (arr[j] != arr[i] && count == 0) {
                    break;
                } else if (arr[j] == arr[i]) {
                    right++;
                }
            }
            length = Math.max(left, right);
            result = Math.max(result, length);
        }
        return Math.min(result,back.length());
    }*/
}
