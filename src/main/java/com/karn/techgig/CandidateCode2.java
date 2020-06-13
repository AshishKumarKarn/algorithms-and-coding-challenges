package com.karn.techgig;
/*
 * Enter your code here. Read input from STDIN. Print your output to STDOUT.
 * Your class should be named CandidateCode.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Ashish Karn
 */
public class CandidateCode2 {
    public static void main(String args[]) throws Exception {
        FastReader sc = new FastReader();
        int tc = sc.nextInt();
        while (tc > 0) {
            final int size = sc.nextInt();
            final List<Long> grev = new ArrayList(size);
            final Long[] opp = new Long[size];
            for (int i = 0; i < size; i++) {
                grev.add(sc.nextLong());
            }
            for (int i = 0; i < size; i++) {
                opp[i] = sc.nextLong();
            }
            grev.sort((a, b) -> a.compareTo(b));
            Arrays.sort(opp);
            int count = 0, lc = 0;
            for (int i = 0; i < opp.length; i++) {
                if (opp[i] < grev.get(i)) {
                    count++;
                } else {
                    final long tmp = grev.remove(i);
                    grev.add(tmp);
                    i--;
                    lc++;
                    if (lc >= grev.size() - i)
                        break;
                }
            }
            System.out.println(count);
            tc--;
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
                } catch (IOException e) {
                    e.printStackTrace();
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
1
10
3 6 7 5 3 5 6 2 9 1 
2 7 0 9 3 6 0 6 2 6

7
*/
