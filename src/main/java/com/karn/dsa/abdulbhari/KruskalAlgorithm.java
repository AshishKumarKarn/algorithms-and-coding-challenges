package com.karn.dsa.abdulbhari;

import java.util.Arrays;

public class KruskalAlgorithm {
    static int[] set = {-1, -1, -1, -1, -1, -1, -1, -1};//|v|+1 index representing vertex and value their head

    public static void main(String[] args) {
        int[][] edges = {
                {1, 1, 2, 2, 3, 4, 4, 5, 5},
                {2, 6, 3, 7, 4, 5, 7, 6, 7},
                {25, 5, 12, 10, 8, 16, 14, 20, 18}
        };
        int[] included = new int[9];//index 0-8 as edges
        int[][] tree = new int[2][6];//2,|v|-1 , edges for minimum spanning tree

        for (int i = 0; i < tree[0].length;) {
            int min = Integer.MAX_VALUE;
            int u = 0, v = 0, minEdgeIndex = 0;
            for (int j = 0; j < edges[2].length; j++) {
                if (included[j] == 0 && edges[2][j] < min) {
                    min = edges[2][j];
                    u = edges[0][j];
                    v = edges[1][j];
                    minEdgeIndex = j;
                }
            }
            included[minEdgeIndex] = 1;
            int rootU = findRoot(u);
            int rootV = findRoot(v);
            if ( rootU!= rootV) {
                tree[0][i] = u;
                tree[1][i] = v;
                union(findRoot(u),findRoot( v));
                i++;
            }
        }
        System.out.println(Arrays.deepToString(tree));
    }

    private static int findRoot(int u) {
        int x=u;
        int v=0;
        while (set[x] > 0) {
            x = set[x];
        }
        //collapsing find
        while(u!=x){
            v=set[u];
            set[u]=x;
            u=v;
        }
        return x;
    }
    private static void union(int u,int v){
        if(set[u]<set[v]){
            set[u]=set[u]+set[v];
            set[v]=u;
        }else{
            set[v]=set[u]+set[v];
            set[u]=v;
        }
    }
}
