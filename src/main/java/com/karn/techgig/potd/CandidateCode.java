package com.karn.techgig.potd;
import java.io.*;
import java.util.*;

public class CandidateCode {
    public static void main(String args[]) throws Exception {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {
            int l = sc.nextInt();
            double[] lefts = new double[l];
            for (int i = 0; i < l; i++) {
                lefts[i] = sc.nextDouble();
            }
            int r = sc.nextInt();
            double[] rights = new double[r];
            for (int i = 0; i < r; i++) {
                rights[i] = sc.nextDouble();
            }
            double m = sc.nextDouble();

            long count = countRides(m, lefts, rights);
            System.out.println(count);
        }
    }

    private static long countRides(double m, double[] lefts, double[] rights) {
        int l = lefts.length;
        int r = rights.length;

        int leftPointer = 0, rightPointer = 0;
        long count = 0;
        while (leftPointer < l && rightPointer < r) {
            if (m >= lefts[leftPointer] && m >= rights[rightPointer]) {
                if (lefts[leftPointer] <= rights[rightPointer]) {
                    m -= lefts[leftPointer];
                    leftPointer++;
                } else {
                    m -= rights[rightPointer];
                    rightPointer++;
                }
                count=count+1;
            } else if (m >= lefts[leftPointer]) {
                m -= lefts[leftPointer];
                leftPointer++;
                count=count+1;
            } else if (m >= rights[rightPointer]) {
                m -= rights[rightPointer];
                rightPointer++;
                count=count+1;
            } else {
                break;
            }
        }

        while (leftPointer < l && m >= lefts[leftPointer]) {
            m -= lefts[leftPointer];
            leftPointer++;
            count=count+1;
        }

        while (rightPointer < r && m >= rights[rightPointer]) {
            m -= rights[rightPointer];
            rightPointer++;
            count=count+1;
        }

        return count;
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

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
