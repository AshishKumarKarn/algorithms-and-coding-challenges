package com.karn.techgig;
/*
 * Enter your code here. Read input from STDIN. Print your output to STDOUT.
 * Your class should be named CandidateCode.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Ashish Karn
 */
public class CandidateCode {
    public static void main(String args[]) throws Exception {
        FastReader sc = new FastReader();
        int N = sc.nextInt();
        long[] rq = new long[N];
        long[] av = new long[N];
        for (int i = 0; i < N; i++) {
            rq[i] = sc.nextLong();
        }
        long rs = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            av[i] = sc.nextLong();
            if (rq[i] != 0) {
                long val = (av[i] / rq[i]);
                if (val < rs)
                    rs = val;
            }
        }
        System.out.println(rs);
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
    }
}
/*
4
2 5 6 3 
20 40 90 50

8
*/
