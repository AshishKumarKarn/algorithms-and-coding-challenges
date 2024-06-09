package com.karn.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DetectCycleBFS {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(detectCycle(i, adj, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    class Pair{
        int self;
        int parent;
        Pair(int self, int parent){
            this.self = self;
            this.parent = parent;
        }
    }

    private boolean detectCycle(int node,ArrayList<ArrayList<Integer>> adj, boolean[] visited ){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(node, -1));

        visited[node]=true;
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int self = pair.self;
            ArrayList<Integer> ajl = adj.get(self);
            int parent = pair.parent;
            for(Integer neighbour : ajl){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    queue.add(new Pair(neighbour, self));
                }else if(parent != neighbour){
                    return true;
                }
            }
        }
        return false;
    }
}
