package com.karn.leetcode.potd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Integer>>[] graph = new List[n];
        Arrays.fill(graph, new ArrayList<>());
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int distance = edge[2];
            graph[src].add(Arrays.asList(dest, distance));
            graph[dest].add(Arrays.asList(src, distance));
        }
        int minCount = n;
        int resultNode = 0;
        for (int i = 0; i < n; i++) {
            int[] dij = dijsktra(i, graph, n);
            int count = 0;
            for (int d : dij) {
                if (d <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= minCount) {
                minCount = count;
                resultNode = i;
            }

        }
        return resultNode;
    }

    int[] dijsktra(int src, List<List<Integer>>[] graph, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Pair> minHeap = new PriorityQueue<>();
        dist[src] = 0;
        minHeap.add(new Pair(0, src));
        while (!minHeap.isEmpty()) {
            Pair pair = minHeap.poll();
            int distance = pair.distance;
            int node = pair.node;
            for (List<Integer> neighbor : graph[node]) {
                Integer neighborNode = neighbor.get(0);
                Integer neighborPathDistance = neighbor.get(1);
                int totalPathTillNode = neighborPathDistance + distance;
                if (totalPathTillNode < dist[neighborNode]) {
                    dist[neighborNode] = totalPathTillNode;
                    minHeap.add(new Pair(totalPathTillNode, neighborNode));
                }
            }
        }
        return dist;
    }

    class Pair implements Comparable<Pair> {
        int distance;
        int node;

        Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }

        @Override
        public int compareTo(Pair o) {
            return this.distance - o.distance;
        }
    }

}
