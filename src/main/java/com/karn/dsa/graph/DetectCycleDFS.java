package com.karn.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectCycleDFS {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            visited[i]=true;
            if(detectCycle(i,-1, adj,visited)){
                return true;
            }
            Arrays.fill(visited, false);
        }
        return false;
    }
    private boolean detectCycle(int source,int parent, ArrayList<ArrayList<Integer>> adj,
                                boolean[] visited){
        for(int i:adj.get(source)){
            if(i!=parent){
                if(!visited[i]){
                    visited[source]=true;
                    return detectCycle(i,source, adj,visited);
                }else{
                    return true;
                }
            }
        }
        return false;
    }
}
