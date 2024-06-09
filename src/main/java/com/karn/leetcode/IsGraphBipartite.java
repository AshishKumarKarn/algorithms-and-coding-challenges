package com.karn.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    public static void main(String[] args) {
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(new IsGraphBipartite().isBipartite(graph));
    }
    public boolean isBipartite(int[][] graph) {
        Queue<ColorNode> queue = new LinkedList<>();
        ColorNode[] visited = new ColorNode[graph.length];
        for(int node=0;node<graph.length;node++){
            if(visited[node]==null){
                queue.add(new ColorNode(node, 1));
                while(!queue.isEmpty()){
                    ColorNode cNode = queue.poll();
                    visited[cNode.value] = cNode;
                    for(int neighbour: graph[cNode.value]){
                        if(visited[neighbour]==null){
                            int color;
                            if(cNode.color==2){
                                color = 1;
                            }else{
                                color = 2;
                            }
                            queue.add(new ColorNode(neighbour, color));
                        }else{
                            if(visited[neighbour].color == cNode.color){
                                return false;
                            }
                        }

                    }
                }
            }
        }
        return true;
    }
    class ColorNode{
        int value;
        int color;//0,1,2
        ColorNode(int value, int color){
            this.value = value;
            this.color = color;
        }
    }
}
