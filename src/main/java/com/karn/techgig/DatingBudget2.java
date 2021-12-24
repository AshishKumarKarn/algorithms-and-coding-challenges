package com.karn.techgig;

import java.util.Arrays;
import java.util.Scanner;


import static java.lang.Math.max;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

class DatingBudget2 {
    static class Reader {
        private final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            din.close();
        }
    }

    static int m;
    static int[][] dp;
    static int[][] prices;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        prices = new int[2][];
        int j = sc.nextInt();
        prices[0] = new int[j + 1];
        prices[0][0] = j;
        int t = sc.nextInt();
        prices[1] = new int[t + 1];
        prices[1][0] = t;
        for (int i = 1; i < prices[0].length; i++) {
            prices[0][i] = sc.nextInt();
        }
        for (int i = 1; i < prices[1].length; i++) {
            prices[1][i] = sc.nextInt();
        }
        dp = new int[m + 1][1000];
        Arrays.stream(dp)
                .forEach(
                        a -> {
                            Arrays.fill(a, -1);
                        });
        int ans = solve(m, 0);
        if (ans < 0) System.out.println(-ans);
        else System.out.println(ans);
        sc.close();

    }

    static int solve(int money, int g) {
        if (money < 0) return Integer.MIN_VALUE;
        if (g == 2) return m - money;
        if (dp[money][g] != -1) return dp[money][g];
        int ans = -1;
        for (int i = 1; i <= prices[g][0]; i++) ans = max(ans, solve(money - prices[g][i], g + 1));
        return dp[money][g] = ans;
    }
}