package com.karn.leetcode.lc1976;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countPaths(7, new int[][]{{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}}));
    }
    private int mod = (int)(1e9+7);
    public int countPaths(int n, int[][] roads) {
        int[] times = new int[n];
        Arrays.fill(times, (int)(1e10));
        times[0] = 0;
        List<int[]>[] graph = new List[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] road: roads){
            graph[road[0]].add(new int[]{road[1],road[2]});
            graph[road[1]].add(new int[]{road[0],road[2]});
        }

        dijsktra(times, graph);
        int shortestTime = times[n-1];
        long count = dfs(graph,n-1, 0, shortestTime);
        return (int)count%mod;
    }
    private long dfs(List<int[]>[] graph,int target, int node, int shortestTime){
        if(node==target&&shortestTime==0){
            return 1;
        }
        if(shortestTime<0){
            return 0;
        }
        List<int[]> neighbours = graph[node];
        long count = 0;
        for(int[] neigh:neighbours){
                //visited[neigh[0]] = true;
                int dist = neigh[1];
                if(dist<=shortestTime){
                    count += dfs(graph,target, neigh[0], shortestTime-dist);
                }

        }
        return count;
    }
    private void dijsktra(int[] times, List<int[]>[] graph){
        Queue<int[]> minHeap = new PriorityQueue<>((a,b)->a[1]-b[1]);
        minHeap.add(new int[]{0,0});
        while(!minHeap.isEmpty()){
            int[] poll = minHeap.poll();
            int node = poll[0];
            int dist = poll[1];
            List<int[]> neighs = graph[node];
            for(int[] ne: neighs){
                if(times[ne[0]]>(dist+ne[1])){
                    times[ne[0]]=(dist+ne[1]);
                    minHeap.add(new int[]{ne[0],times[ne[0]]});
                }
            }
        }
    }
}
