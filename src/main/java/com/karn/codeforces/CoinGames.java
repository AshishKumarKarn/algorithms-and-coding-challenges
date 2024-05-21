package com.karn.codeforces;

import java.util.Scanner;

public class CoinGames {

    public static final String ALICE = "Alice";
    public static final String BOB = "Bob";

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            while (N > 0) {
                int size = sc.nextInt();
                String coins = sc.next();
                String[] coinsArray = coins.split("");
                if (canAliceChoose(coinsArray, ALICE)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
                N--;
            }
        }
    }

    private static boolean canAliceChoose(String[] coinsArray, String player) {
        for (int i = 0; i < coinsArray.length; i++) {
            if (coinsArray[i].equals("U")) {
                Pair pair = flipCoins(coinsArray, i, player);
                if (pair.winner != null) {
                    return pair.winner.equals(ALICE);
                } else {
                    if (ALICE.equals(player))
                        return canAliceChoose(pair.arr, BOB);
                    else
                        return canAliceChoose(pair.arr, ALICE);
                }

            }
        }
        return !ALICE.equals(player);

    }

    static class Pair {
        String[] arr;
        String winner;

        public Pair(String[] arr, String winner) {
            this.arr = arr;
            this.winner = winner;
        }
    }

    private static Pair flipCoins(String[] coinsArray, int i, String player) {
        if (coinsArray.length == 2) {
            if (coinsArray[0].equals(coinsArray[1])) {
                if (player.equals(ALICE))
                    return new Pair(null, BOB);
                else {
                    return new Pair(null, ALICE);
                }
            } else {
                return new Pair(null, player);
            }
        }
        if (i == 0) {
            if (coinsArray[coinsArray.length - 1].equals("U")) {
                coinsArray[coinsArray.length - 1] = "D";
            } else {
                coinsArray[coinsArray.length - 1] = "U";
            }
            if (coinsArray[1].equals("U")) {
                coinsArray[1] = "D";
            } else {
                coinsArray[1] = "U";
            }
        } else if (i == coinsArray.length) {
            if (coinsArray[coinsArray.length - 2].equals("U")) {
                coinsArray[coinsArray.length - 2] = "D";
            } else {
                coinsArray[coinsArray.length - 2] = "U";
            }
            if (coinsArray[0].equals("U")) {
                coinsArray[0] = "D";
            } else {
                coinsArray[0] = "U";
            }
        }
        String[] arr = new String[coinsArray.length - 1];
        for (int j = 0, k = 0; j < coinsArray.length; j++) {
            if (j != i) {
                arr[k++] = coinsArray[j];
            }
        }
        return new Pair(arr, null);
    }
}
