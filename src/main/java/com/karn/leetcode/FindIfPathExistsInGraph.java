package com.karn.leetcode;

import java.util.Arrays;

public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination){
            return true;
        }
        if(edges.length==0){
            return false;
        }

        int[] head=new int[n+1];
        Arrays.fill(head, -1);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            union(head, u + 1, v + 1);
        }
        return root(head,source+1)==root(head,destination+1);
    }
    private int root(int[] head,int x){
        int u=x;
        int ind=u;
        while(u>=0){
            ind=u;
            u=head[u];
        }
        return ind;
    }
    private void union(int[] head,int i,int j){
        int u = root(head, i);
        int v = root(head, j);
        if(u==v){
            return;
        }

        if(head[u]<head[v]){
            head[u]=head[u]+head[v];
            head[v]= u;
        }else{
            head[v]=head[u]+head[v];
            head[u]= v;
        }

    }

    private int find(int[] set,int u){
        int x=u;
        int v;
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
}
