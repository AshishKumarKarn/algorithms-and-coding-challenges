package com.karn.algotricks;

public class KMPStringMatchingDemo {
    public static void main(String[] args) {
        String searchString = "ashishkumarkarn";
        String toFind = "arkar";
        int index = searchKMP(toFind, searchString);
        System.out.println("Index found by KMP: " + index);
        System.out.println("Validation with contains(): " + searchString.contains(toFind));
    }

    private static int searchKMP(String toFind, String searchString) {
        int[] table = prepareTableForPattern(toFind);
        int i = 0; // For search string
        int j = 0; // For pattern to find

        while (i < searchString.length()) {
            // Match characters of searchString and toFind
            while (j < toFind.length() && i < searchString.length() && toFind.charAt(j) == searchString.charAt(i)) {
                i++;
                j++;
            }

            // If a match is found
            if (j == toFind.length()) {
                return i - toFind.length();
            }

            // Mismatch after `j` matches, update `j` using table
            if (j > 0) {
                j = table[j - 1];
            } else {
                i++; // Move to the next character in searchString
            }
        }

        return -1; // Not found
    }

    private static int[] prepareTableForPattern(String toFind) {
        int[] table = new int[toFind.length()];
        int j = 0; // Length of the previous longest prefix suffix

        for (int i = 1; i < toFind.length(); i++) {
            // Handle mismatch: backtrack `j` using the table
            while (j > 0 && toFind.charAt(i) != toFind.charAt(j)) {
                j = table[j - 1];
            }

            // If there's a match, extend the prefix
            if (toFind.charAt(i) == toFind.charAt(j)) {
                j++;
            }

            table[i] = j;
        }

        return table;
    }
}
