package com.karn.faang.gfg;

public class IntegralPointsInsideTriangle {
    long InternalCount(long p[], long q[], long r[]) {
        // code here
        return getit(new Point(p[0], p[1]), new Point(q[0], q[1]), new Point(r[0], r[1]));
    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static long get1(Point p, Point q) {
        if (p.x == q.x)
            return Math.abs(p.y - q.y) - 1;
        if (p.y == q.y)
            return Math.abs(p.x - q.x) - 1;
        return gcd(Math.abs(p.x - q.x), Math.abs(p.y - q.y)) - 1;
    }

    public static long getit(Point p, Point q, Point r) {
        long boundary = get1(p, q) + get1(q, r) + get1(p, r) + 3;
        long ar = Math.abs(p.x * (q.y - r.y) + q.x * (r.y - p.y) + r.x * (p.y - q.y));
        return (ar - boundary + 2) / 2;
    }

    static class Point {
        long x;
        long y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
