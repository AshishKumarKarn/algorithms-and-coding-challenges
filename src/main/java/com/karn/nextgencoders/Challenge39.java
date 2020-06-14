package com.karn.nextgencoders;

/**
 * @author Ashish Karn
 */
public class Challenge39 {
    public static void main(String[] args) {
        String word = "add";
        for (int i = word.length() / 2, j = 0; i < word.length(); i++, j++) {
            if (word.length() % 2 > 0) {
                if (isPalindromPortionForOdd(i, word)) {
                    System.out.println(j * 2);
                    return;

                }
            } else {
                if (isPalindromPortionForEven(i, word)) {
                    System.out.println(j * 2);
                    return;
                } else {
                    if (isPalindromPortionForOdd(i, word)) {
                        System.out.println(j * 2 + 1);
                        return;
                    }
                }

            }

        }

    }

    private static boolean isPalindromPortionForEven(int i, String word) {
        for (int j = 1, k = 0; (i + k) < word.length() && 0 < (i + j); j++, k++) {
            if (word.charAt(i - j) != word.charAt(i + k)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindromPortionForOdd(int i, String word) {
        for (int j = 0; (i + j) < word.length(); j++) {
            if (word.charAt(i + j) != word.charAt(i - j)) {
                return false;
            }
        }
        return true;
    }
}
