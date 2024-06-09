package com.karn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestCycleInGraph {
    public static void main(String[] args) {
//        int[][] edges = {{0,1},{1,2},{2,0},{3,4},{4,5},{5,6},{6,3}};
//        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {3, 4}};
//        int[][] edges = {{0,2},{2,4},{4,0}};
        int[][] edges = {{2,1},{0,1},{4,1},{3,0},{1,3}};
//        int[][] edges = {{3,4},{0,3},{5,4},{2,0},{1,2},{0,4}};
        
        System.out.println(new ShortestCycleInGraph().findShortestCycle(7, edges));
    }

    public int findShortestCycle(int n, int[][] edges) {
        List<Integer>[] al = new List[n];

        for (int i = 0; i < n; i++) {
            al[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            al[edge[0]].add(edge[1]);
            al[edge[1]].add(edge[0]);
        }
        Node[] visited = new Node[n];
        int shortestLength = Integer.MAX_VALUE;
        for (int source = 0; source < n; source++) {
            if (visited[source]==null) {
                shortestLength = Math.min(shortestLength, getCycleLength(al, source, -1, 0, visited));
            }
            Arrays.fill(visited, null);
        }
        return shortestLength == Integer.MAX_VALUE ? -1 : shortestLength + 1;

    }

    class Node{
        int value;
        int position;

        public Node(int value, int position) {
            this.value = value;
            this.position = position;
        }
    }
    int minLength = Integer.MAX_VALUE;
    private int getCycleLength(List<Integer>[] al, int source, int parent, int length, Node[] visited) {
        visited[source] = new Node(source, length);
        int cycleLength = Integer.MAX_VALUE;
        for (int neighbourIndex = 0; neighbourIndex < al[source].size(); neighbourIndex++) {
            Integer neighbour = al[source].get(neighbourIndex);
            if (visited[neighbour] == null) {
                cycleLength = getCycleLength(al, neighbour, source, length + 1, visited);
            } else if (neighbour != parent) {
                //cycle
                 cycleLength = length - visited[neighbour].position;
            }
            if(cycleLength > 2){
                length = Math.min(cycleLength, length);
            }
        }
        return length;
    }


}
