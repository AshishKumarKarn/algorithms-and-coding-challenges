package com.karn.leetcode.lc2685;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = new int[][]{{0,1}};
        System.out.println(new Solution().countCompleteComponents(n, edges));
    }
    public int countCompleteComponents(int n, int[][] edges) {
        Set<Integer>[] graph = new Set[n];
        for(int i=0;i<n;i++){
            graph[i] = new HashSet<>();
        }
        for(int[] edge: edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(graph,graph[i],i, visited, parents);
            }
        }
        int count = 0;
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            List<Integer> child = map.getOrDefault(parents[i],new ArrayList<>());
            if(parents[i]!=-1){
                child.add(i);
                map.put(parents[i],child);
            }else{
                count++;
            }
        }
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            if(areAllConnected(entry.getValue(), graph)){
                set.add(entry.getKey());
            }
        }
        return count+set.size();
    }

    private boolean areAllConnected(List<Integer> child, Set<Integer>[] graph) {
        for(int i=0;i<child.size();i++){
            for (int j = i+1; j < child.size(); j++) {
                Set<Integer> n1 = graph[child.get(i)];
                Set<Integer> n2 = graph[child.get(j)];
                boolean b = n1.contains(child.get(j)) && n2.contains(child.get(i));
                if(!b){
                    return false;
                }

            }
        }
        return true;
    }

    private void dfs(Set<Integer>[] graph,Set<Integer> neigh,int p, boolean[] visited,int[] parents){
        for(Integer n : neigh){
            if(!visited[n]){
                visited[n] = true;
                parents[n] = p;
                dfs(graph,graph[n],p,visited,parents);
            }
        }
    }
}
