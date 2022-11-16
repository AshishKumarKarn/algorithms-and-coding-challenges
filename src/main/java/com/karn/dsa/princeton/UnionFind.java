package com.karn.dsa.princeton;

import java.util.*;

public class UnionFind {
    public static void main(String[] args) {
        UF uf=new UF(9);
        uf.union(5,4);
        uf.union(2,6);
        uf.union(7,6);
        uf.union(3,8);
        boolean sol1 = uf.isConnected(0, 6);
        System.out.println(sol1);//false
        boolean sol2 = uf.isConnected(2, 7);
        System.out.println(sol2);//true

    }

}
class UF{
    class Node{
        int n;
        Node(int n){
            this.n=n;
        }
        List<Node> neighbor = new ArrayList<>();
    }
     static Map<Integer,Node> nodeMap = new HashMap<>();
    UF(int n){
        for (int i = 0; i < n; i++) {
            Node node = new Node(i);
            //node is self connected
            node.neighbor.add(node);
            nodeMap.put(i,node);
        }
    }
    public void union(int p,int q){
        nodeMap.get(p).neighbor.add(nodeMap.get(q));
        nodeMap.get(q).neighbor.add(nodeMap.get(p));
    }

    public boolean isConnected(int p,int q){
        if(p==q){
            return true;
        }
        Set<Node> visited = new HashSet<>();
        Node node1 = nodeMap.get(p);
        Node node2 = nodeMap.get(q);
        return isConnected(node1,node2,visited);

    }
    private boolean isConnected(Node node1,Node node2, Set<Node> visited){
        if(visited.contains(node1)){
            return false;
        }
        visited.add(node1);
        List<Node> neighbor1 = node1.neighbor;

        if(neighbor1.contains(node2)){
            return true;
        }
        boolean found = false;
        for (Node node : neighbor1) {
            if (isConnected(node, node2, visited)) {
                found = true;
                break;
            }
        }
        return found;

    }
}