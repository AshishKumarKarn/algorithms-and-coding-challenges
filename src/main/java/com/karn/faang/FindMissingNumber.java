package com.karn.faang;

import java.util.*;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
      //  System.out.println(findPath(matrix, 4));
        for(int[] arr:matrix){
            Arrays.fill(arr, -1);
        }
        int total = 0;
        for(int[] arr:matrix) {
            total += Arrays.stream(arr).reduce(Integer::sum).getAsInt();
        }
        System.out.println(total);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> result = new ArrayList<>();
        if (m[n - 1][n - 1] == 0) {
            result.add("-1");
            return result;
        }
        findPath(m, result);
        if (result.isEmpty()) {
            result.add("-1");
        }
        return result;
    }


    static void findPath(int[][] m, ArrayList<String> result) {
        Set<String> visited = new HashSet<>();
        possiblePaths(0, 0, m, result, new Stack<>(), visited);
    }

    static void possiblePaths(int i, int j, int[][] m, ArrayList<String> result, Stack<String> st, Set<String> visited) {
        String position = i + "_" + j;
        if (i < 0 || i >= m.length || j < 0 || j >= m[i].length || m[i][j] == 0 || visited.contains(position)) {
            if (!st.empty()) {
                st.pop();
            }
            return;
        }
        if (i == m.length - 1 && j == m[i].length - 1 && m[i][j] == 1) {
            StringBuilder sb = new StringBuilder();
            for (String d : st) {
                sb.append(d);
            }
            result.add(sb.toString());
            visited.remove(position);
            if (!st.empty()) {
                st.pop();
            }
            return;
        }
        visited.add(position);
        st.push("U");
        possiblePaths(i - 1, j, m, result, st, visited);
        st.push("D");
        possiblePaths(i + 1, j, m, result, st, visited);
        st.push("L");
        possiblePaths(i, j - 1, m, result, st, visited);
        st.push("R");
        possiblePaths(i, j + 1, m, result, st, visited);

    }
}
