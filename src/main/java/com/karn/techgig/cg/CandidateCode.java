package com.karn.techgig.cg;
import java.io.*;
import java.util.*;

/**
 *
  5
  1 3
  1 2
  2 4
  3 5
  GGRGG
 *
 * output
 * 3
 * 3
 * 0
 * 3
 * 1
 *
 *
 *
 *
  5
  1 2
  1 3
  2 4
  3 5
  RGRGR
 *
 * output:
 * 4
 * 4
 * 4
 * 4
 * 2
 *
 */

import java.io.*;
import java.util.*;

/**
 *
 * 5
 * 1 3
 * 1 2
 * 2 4
 * 3 5
 * GGRGG
 *
 * output
 * 3
 * 3
 * 0
 * 3
 * 1
 *
 *
 * 5
 * 1 2
 * 1 3
 * 2 4
 * 3 5
 * RGRGR
 *
 * output:
 4
 4
 4
 4
 2
 *
 */
import java.io.*;
import java.util.*;

/**
 * For input:
 * 5
 * 1 2
 * 1 3
 * 2 4
 * 3 5
 * RGRGR
 *
 * Expected output:
 * 4
 * 4
 * 4
 * 4
 * 2
 */

import java.io.*;
import java.util.*;

/**
 * For input:
 * 5
 * 1 2
 * 1 3
 * 2 4
 * 3 5
 * RGRGR
 *
 * Expected output:
 * 4
 * 4
 * 4
 * 4
 * 2
 */

public class CandidateCode {
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

    static class Node {
        int id;
        char flag; // 'G' for green, 'R' for red
        List<Node> neighbors;

        Node(int id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int N = sc.nextInt();
        Node[] nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }
        String s = sc.next();
        while (!s.startsWith("R") && !s.startsWith("G")) {
            int source = Integer.parseInt(s);
            int destination = sc.nextInt();
            nodes[source].neighbors.add(nodes[destination]);
            nodes[destination].neighbors.add(nodes[source]);
            s = sc.next();
        }
        char[] charArray = s.toCharArray();
        for (int i = 1; i <= N; i++) {
            nodes[i].flag = charArray[i - 1];
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(maximumEvenRedPaths(nodes[i], N));
        }
    }

    public static int maximumEvenRedPaths(Node start, int N) {
        int maxPaths = 0;
        boolean[] visited = new boolean[N + 1];
        Stack<Node> stack = new Stack<>();
        Stack<Integer> redCountStack = new Stack<>();
        stack.push(start);
        visited[start.id] = true;
        redCountStack.push(start.flag == 'R' ? 1 : 0);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            int currentRedCount = redCountStack.pop();
            maxPaths = Math.max(maxPaths, currentRedCount);

            for (Node neighbor : node.neighbors) {
                if (!visited[neighbor.id]) {
                    int newRedCount = currentRedCount;
                    if (neighbor.flag == 'R') {
                        newRedCount++;
                    }
                    if (newRedCount % 2 == 0) {
                        stack.push(neighbor);
                        redCountStack.push(newRedCount);
                    }
                    visited[neighbor.id] = true;
                }
            }
        }

        return maxPaths;
    }
}
