package com.karn.tleeliminator.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//https://cses.fi/problemset/task/1712/
public class Exponentiation2 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        while (n > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            long pow = binaryPower(b, c, (modExact - 1)) % (modExact - 1);
            System.out.println(binaryPower(a, pow, modExact));
            n--;
        }
    }

    private static class FastReader {
        private final BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException eX) {
                    eX.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    private static final long modExact = (long) (1e9) + 7;

    private static long binaryPower(long a, long b, long mod) {
        long answer = 1;
        while (b > 0) {
            if ((b & 1) == 1) {//odd check can also work
                answer = (answer * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return answer;
    }
}
