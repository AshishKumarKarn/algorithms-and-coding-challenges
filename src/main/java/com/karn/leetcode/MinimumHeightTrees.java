package com.karn.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MinimumHeightTrees {
    public static void main(String[] args) {
        int[][] edges={{3,0},{3,1},{3,2},{3,4},{5,4}};
        System.out.println(new MinimumHeightTrees().findMinHeightTrees(6, edges));
    }
    List<Node> nodeList=new ArrayList<>();
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        for(int i=0;i<edges.length;i++){
            Node node1;
            Node node2;
            if(nodeList.get(edges[i][0])==null){
                node1=new Node(edges[i][0]);
                nodeList.add(edges[i][0],node1);
            }else{
                node1 = nodeList.get(edges[i][0]);
            }
            if(nodeList.get(edges[i][1])==null){
                node2=new Node(edges[i][1]);
                nodeList.add(edges[i][1], node2);
            }else{
                node2 = nodeList.get(edges[i][1]);
            }
            node1.connected.add(node2);
            node2.connected.add(node1);
        }
        int min=Integer.MAX_VALUE;
        List<Integer> heights=new ArrayList<>();
        for (Node node: nodeList) {
            Tree tree=new Tree(node);
            int height = tree.getHeight();
            if(height<=min){
                min=height;
                heights.add(height);
            }
        }
        int minimum=min;
        return heights.stream().filter(a->a==minimum).collect(Collectors.toList());
    }
    class Tree{
        Node root;
        Tree(Node node){
            this.root=node;
        }
        int getHeight(){
            return getDepth(root.connected, 0);
        }
        int getDepth(List<Node> connected, int depth){
            if(connected.isEmpty()){
                return depth;
            }
            for (Node node1 : connected) {
                depth = Math.max(depth,getDepth(node1.connected, depth+1));
            }
            return depth+1;
        }


    }
    class Node{
        int data;
        List<Node> connected=new ArrayList<>();
        Node(int data){
            this.data=data;
        }
    }
}
