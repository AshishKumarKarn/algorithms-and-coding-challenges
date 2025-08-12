package com.karn.leetcode.lc1857;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[][] edges = {{1,0},{0,2},{2,1},{3,4},{4,5}};
        String colors = "abacac";
        System.out.println(new Solution().largestPathValue(colors, edges));
    }

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        boolean[] isParent = new boolean[n];
        List<Integer>[] graph = getGraph(edges, n, isParent);
        if (graphHasCycle(graph, n)) {
            return -1;
        }
        int result = 0;

        //check from all parents
        for (int i = 0; i < n; i++) {//each component
            if (isParent[i]) {
                int[] arr = new int[26];
                result = Math.max(result, dfs(graph, i, colors, arr));
            }
        }
        return result;
    }

    private boolean graphHasCycle(List<Integer>[] graph, int n) {
        for (int i = 0; i < n; i++) {
            if (hasCycle(graph, i, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(List<Integer>[] graph, int node, int parent) {
        List<Integer> neighbours = graph[node];
        boolean result = false;

        for (Integer neig : neighbours) {
            if(neig==parent||neig==node) {
                return true;
            }
            if (hasCycle(graph, neig, parent)) {
                return true;
            }
            if (hasCycle(graph, neig, node)) {
                return true;
            }


        }
        return result;
    }

    private int dfs(List<Integer>[] graph, int node, String colors, int[] arr) {
        List<Integer> neigh = graph[node];
        int len = 0;
        arr[colors.charAt(node) - 'a']++;
        for (int n : neigh) {
            len = Math.max(dfs(graph, n, colors, arr), len);
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(len, Math.max(arr[i], max));
        }
        arr[colors.charAt(node) - 'a']--;
        return max;
    }

    private List<Integer>[] getGraph(int[][] edges, int n, boolean[] isParent) {
        Arrays.fill(isParent, true);
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
            isParent[to] = false;
        }
        return graph;
    }
}
