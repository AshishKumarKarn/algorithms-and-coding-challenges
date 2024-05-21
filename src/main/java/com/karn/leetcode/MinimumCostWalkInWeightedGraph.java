package com.karn.leetcode;

import java.io.File;
import java.util.*;

public class MinimumCostWalkInWeightedGraph {
    public static void main(String[] args) throws Exception {
//        int[][] edges = {{0, 1, 7}, {1, 3, 7}, {1, 2, 1}};
//        int[][] queries = {{1, 3}, {3, 4}};
//                int[][] edges = {{0, 2, 7}, {0, 1, 15}, {1, 2, 6}, {1, 2, 1}};
//        int[][] queries = {{1, 2}};
        try (Scanner sc = new Scanner(new File("MinimumCostWalkInWeightedGraph.txt"))) {
            int n = sc.nextInt();
            String edgesFile = sc.next();
            String queryFile = sc.next();
            String[] edgesStrings = edgesFile.replaceAll("\\[\\[", "").replaceAll("]]", "").replaceAll("],\\[", ",").split(",");
            String[] queryStrings = queryFile.replaceAll("\\[\\[", "").replaceAll("]]", "").replaceAll("],\\[", ",").split(",");
            int edgesLength = edgesStrings.length / 3;
            int[][] edges = new int[edgesLength][3];
            for (int j = 0, i = 0; j < edgesLength; j++) {
                edges[j][0] = Integer.parseInt(edgesStrings[i++]);
                edges[j][1] = Integer.parseInt(edgesStrings[i++]);
                edges[j][2] = Integer.parseInt(edgesStrings[i++]);
            }
            int length = queryStrings.length / 2;
            int[][] queries = new int[length][2];
            for (int i = 0, j = 0; i < length; i++) {
                queries[i][0] = Integer.parseInt(queryStrings[j++]);
                queries[i][1] = Integer.parseInt(queryStrings[j++]);
            }

            long startTime = System.currentTimeMillis();
            int[] results = new MinimumCostWalkInWeightedGraph().minimumCost(n, edges, queries);
            System.out.println(System.currentTimeMillis() - startTime + " ms");
            System.out.println(Arrays.toString(results));
        }



    }

    private boolean found = false;
    private boolean[] visited;
    Set<Integer> nodes;


    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        List<Pair>[] adjecencyList = new List[n];
        Arrays.fill(adjecencyList, new ArrayList<>());

        for (int[] edge : edges) {
            adjecencyList[edge[0]].add(new Pair(edge[1], edge[2]));
            adjecencyList[edge[1]].add(new Pair(edge[0], edge[2]));
        }
        //nodes with map of destination nodes with weights associated with them
        Map<Integer,Integer>[] ajMap = new Map[n];
        Arrays.fill(ajMap, new HashMap<>());
        boolean[] visited = new boolean[n];


        int[] results = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            int start = query[i][0];
            int end = query[i][1];
            visited[start] = true;
            Map<Integer,Integer> map = new HashMap<>();
            dfsFillMap(adjecencyList[start], map, adjecencyList, visited, ajMap);
            ajMap[start] = map;
            dfsFillMap(adjecencyList[end], map, adjecencyList, visited, ajMap);

            boolean found = ajMap[start].containsKey(end);
            if (found) {
                results[i] = getBitWiseAndForWeights(ajMap, start);
            } else {
                results[i] = -1;
            }
        }


        return results;
    }

    private int getBitWiseAndForWeights(Map<Integer, Integer>[] ajMap, int start) {
        Map<Integer, Integer> nodeTargetWeights = ajMap[start];
        int weight = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> targetEntry : nodeTargetWeights.entrySet()) {
            weight &= targetEntry.getValue();
        }
        return weight;

    }

    private void dfsFillMap(List<Pair> pairs, Map<Integer, Integer> map, List<Pair>[] adjecencyList, boolean[] visited, Map<Integer, Integer>[] ajMap) {
        for (Pair pair : pairs) {
            map.put(pair.node, pair.weight);

            if (!ajMap[pair.node].isEmpty()) {
                map.putAll(ajMap[pair.node]);
                continue;
            }
            if(!visited[pair.node]){
                visited[pair.node] = true;
                dfsFillMap(adjecencyList[pair.node], map, adjecencyList, visited, ajMap);
            }
        }
    }

    class Pair {
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

         @Override
         public String toString() {
             return "node=" + node + " weight=" + weight;
         }
    }

}
