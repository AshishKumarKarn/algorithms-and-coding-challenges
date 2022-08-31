package com.karn.kickstart.ks2022.practice.season3;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class WiggleWalk {
    static int mod = (int) (1e9+7);
    static InputReader in;
    static PrintWriter out;

    static void update(Integer idx, Pair newP, TreeSet<Pair>[] rows) {
        Pair fPair = rows[idx].lower(newP);
        Pair nPair = rows[idx].higher(newP);
        if(fPair != null && fPair.y == newP.x - 1) {
            newP.x = fPair.x;
            rows[idx].remove(fPair);
        }
        if(nPair != null && nPair.x == newP.y + 1) {
            newP.y = nPair.y;
            rows[idx].remove(nPair);
        }
        rows[idx].add(newP);
    }

    static Pair get(int pc, int pr, TreeSet<Pair>[] rows, TreeSet<Pair>[] cols) {
        int cc1 = pc - 1;
        int cc2 = pc - 1;
        Pair nP = new Pair(cc1, cc2);
        Pair tPair = rows[pr].floor(nP);
//		debug(pc,pr,cc1,tPair);
        if(tPair != null && (tPair.y >= pc)) {
            cc1 = tPair.x - 1;
            cc2 = tPair.y;
            rows[pr].remove(tPair);
        }
        Pair newP = new Pair(cc1, cc2);
        update(pr, newP, rows);
        pc = cc1;
        Pair newP2 = new Pair(pr, pr);
        update(pc, newP2, cols);
        return new Pair(pr, pc);
    }

    static Pair get2(int pc, int pr, TreeSet<Pair>[] rows, TreeSet<Pair>[] cols) {
        int cc1 = pc + 1;
        int cc2 = pc + 1;
        Pair nP = new Pair(cc1, cc2);
        Pair tPair = rows[pr].floor(nP);
        if(tPair != null && tPair.y >= pc) {
            cc1 = tPair.x;
            cc2 = tPair.y + 1;
            rows[pr].remove(tPair);
        }
        Pair newP = new Pair(cc1, cc2);
        update(pr, newP, rows);
        pc = cc2;
        Pair newP2 = new Pair(pr, pr);
        update(pc, newP2, cols);
        return new Pair(pr, pc);
    }

    static void solve()
    {

        in = new InputReader(System.in);
        out = new PrintWriter(System.out);

        int t = in.nextInt();

        TreeSet<Pair>[] rows = new TreeSet[60005];
        TreeSet<Pair>[] cols = new TreeSet[60005];

        for(int i = 0; i < 60005; i++) {
            rows[i] = new TreeSet<Pair>();
            cols[i] = new TreeSet<Pair>();
        }

        for(int it = 1; it <= t; it++) {
            int n = in.nextInt();
            int r = in.nextInt();
            int c = in.nextInt();
            int pr = in.nextInt();
            int pc = in.nextInt();

            for(int i = 1; i <= r; i++)
                rows[i].clear();
            for(int i = 1; i <= c; i++)
                cols[i].clear();

            String string = in.readString();
            rows[pr].add(new Pair(pc, pc));
            cols[pc].add(new Pair(pr, pr));
            for(int i = 0; i < n; i++) {
                char ch = string.charAt(i);
                if(ch == 'W') {
                    Pair nPair1 = get(pc, pr, rows, cols);
                    pr = nPair1.x;
                    pc = nPair1.y;
                }
                else if(ch == 'N') {
                    Pair nPair1 = get(pr, pc, cols, rows);
                    pr = nPair1.y;
                    pc = nPair1.x;
                }
                else if(ch == 'E') {
                    Pair nPair1 = get2(pc, pr, rows, cols);
                    pr = nPair1.x;
                    pc = nPair1.y;
                }
                else if(ch == 'S') {
                    Pair nPair1 = get2(pr, pc, cols, rows);
                    pr = nPair1.y;
                    pc = nPair1.x;
                }
                if(pr > r || pc > c || pr <= 0 || pc <= 0) {
                    out.println(pr/0);
                }
//        		debug(it, i, pr, rows[pr], pc, cols[pc]);
//        		debug(it,it,pr,pc);
            }
            out.println("Case #" + it + ": " + pr + " " + pc);
        }

        out.close();
    }


    public static void main(String[] args) {
//        new Thread(null , () -> {
            try{
                solve();
            } catch(Exception e){
                e.printStackTrace();
            }
       // },"1",1<<26).start();
    }

    static int[][] graph(int from[], int to[], int n)
    {
        int g[][] = new int[n][];
        int cnt[] = new int[n];
        for (int i = 0; i < from.length; i++) {
            cnt[from[i]]++;
            cnt[to[i]]++;
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[cnt[i]];
        }
        Arrays.fill(cnt, 0);
        for (int i = 0; i < from.length; i++) {
            g[from[i]][cnt[from[i]]++] = to[i];
            g[to[i]][cnt[to[i]]++] = from[i];
        }
        return g;
    }

    static class Pair implements Comparable<Pair>{

        int x,y,i;

        Pair (int x,int y,int i){
            this.x=x;
            this.y=y;
            this.i=i;
        }

        Pair (int x,int y){
            this.x=x;
            this.y=y;
        }

        public int compareTo(Pair o) {
            return Integer.compare(this.x,o.x);
        }

        public boolean equals(Object o) {
            if (o instanceof Pair) {
                Pair p = (Pair)o;
                return p.x == x && p.y == y && p.i==i;
            }
            return false;
        }
        public int hashCode() {
            return Integer.valueOf(x).hashCode() * 31 + Integer.valueOf(y).hashCode()+Integer.valueOf(i).hashCode()*37;
        }
        @Override
        public String toString() {
            return x + " " + y;
        }
    }


    static String rev(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }

    static long gcd(long x, long y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    static int abs(int a, int b) {
        return (int) Math.abs(a - b);
    }

    static long abs(long a, long b) {
        return (long) Math.abs(a - b);
    }

    static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    static int min(int a, int b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }

    static long max(long a, long b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    static long min(long a, long b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }

    static long pow(long n, long p, long m) {
        long result = 1;
        if (p == 0) {
            return 1;
        }
        while (p != 0) {
            if (p % 2 == 1) {
                result *= n;
            }
            if (result >= m) {
                result %= m;
            }
            p >>= 1;
            n *= n;
            if (n >= m) {
                n %= m;
            }
        }
        return result;
    }

    static long pow(long n, long p) {
        long result = 1;
        if (p == 0) {
            return 1;
        }
        if (p == 1) {
            return n;
        }
        while (p != 0) {
            if (p % 2 == 1) {
                result *= n;
            }
            p >>= 1;
            n *= n;
        }
        return result;
    }

    static void debug(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    static class InputReader
    {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream)
        {
            this.stream = stream;
        }

        public int snext()
        {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars)
            {
                curChar = 0;
                try
                {
                    snumChars = stream.read(buf);
                } catch (IOException e)
                {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt()
        {
            int c = snext();
            while (isSpaceChar(c))
            {
                c = snext();
            }
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong()
        {
            int c = snext();
            while (isSpaceChar(c))
            {
                c = snext();
            }
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n)
        {
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = nextInt();
            }
            return a;
        }

        public long[] nextLongArray(int n)
        {
            long a[] = new long[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = nextLong();
            }
            return a;
        }

        public String readString()
        {
            int c = snext();
            while (isSpaceChar(c))
            {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do
            {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine()
        {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do
            {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c)
        {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c)
        {
            return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter
        {
            public boolean isSpaceChar(int ch);
        }

    }
}



