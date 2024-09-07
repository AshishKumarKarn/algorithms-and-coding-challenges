package com.karn.leetcode.potd;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {

    }
    //trying to solve reverse dijkstra
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        List<NodeProb>[] graph=new List[n];
        for (int i = 0; i < n; i++) {
            graph[i]=new ArrayList<>();
        }
        int k=0;
        for(int[] edge:edges){
            int src=edge[0];
            int dest=edge[1];
            double p=succProb[k++];
            graph[src].add(new NodeProb(dest, p));
            graph[dest].add(new NodeProb(src, p));
        }
        
        double[] probs = new double[n];//befault 0 probablity for all
        probs[start_node]=1;
        Queue<NodeProb> queue = new PriorityQueue<>();
        queue.add(new NodeProb(start_node, 1));
        while(!queue.isEmpty()){
            NodeProb maxNode = queue.poll();
            int node = maxNode.node;
            double prob = maxNode.prob;
            for(NodeProb neigh:graph[node]){
                double currentProb = neigh.prob*prob;
                if(currentProb>probs[node]){
                    probs[node]=currentProb;
                    queue.add(new NodeProb(neigh.node, currentProb));
                }
            }
        }
        return probs[end_node];
        
    }
    class NodeProb implements Comparable<NodeProb>{
        Integer node;
        Double prob;
        NodeProb(int node, double prob){
            this.node = node;
            this.prob = prob;
        }
        public int compareTo(NodeProb np){
            return np.prob.compareTo(this.prob);
        }
    }
}