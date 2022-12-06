package com.karn.dsa.abdulbhari;

import java.util.ArrayDeque;
import java.util.Queue;

public class GraphBFSDFS {
    public static void main(String[] args) {

        int[][] graph ={//   1  2  3  4  5  6
                         {0, 0, 0, 0, 0, 0, 0},
                /*1*/    {0, 0, 0, 1, 1, 0, 0},
                /*2*/    {0, 0, 0, 1, 0, 1, 1},
                /*3*/    {0, 1, 1, 0, 0, 1, 0},
                /*4*/    {0, 1, 0, 0, 0, 0, 1},
                /*5*/    {0, 0, 1, 1, 0, 0, 0},
                /*6*/    {0, 0, 1, 0, 1, 0, 0},
        };

        bfs(graph);
        System.out.println();
        dfs(graph);
    }

    private static void bfs(int[][] graph) {
        int[] visited=new int[7];
        Queue<Integer> queue=new ArrayDeque<>();
        //select start vertex here in by adding in queue
        queue.add(1);
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            if(visited[poll]==0){//if not already visited
                System.out.print(poll+" ");
                visited[poll]=1;
                for (int i = 1; i < 7; i++) {
                    if(graph[poll][i]==1&&visited[i]==0){
                        queue.add(i);
                    }
                }
            }
        }

    }

    private static void dfs(int[][] graph) {
        int[] visited=new int[7];
        //select start vertex here in argument
        dfs(graph,visited,1);
    }

    private static void dfs(int[][] graph, int[] visited, int start) {
        if(visited[start]==0){
            visited[start]=1;
            System.out.print(start+" ");
            for (int i = 1; i < graph[start].length; i++) {
                if(graph[start][i]==1){
                    dfs(graph, visited, i);
                }
            }
        }
    }
}
