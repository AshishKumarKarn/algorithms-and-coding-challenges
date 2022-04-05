package com.karn.dsa.codejam.cj2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


//ChainReactions
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {

            int n = sc.nextInt();
            Node[] array = new Node[n];
            Set<Node> leafNodes = new HashSet<>();
            for (int j = 0; j < n; j++) {
                array[j] = new Node(sc.nextInt());
                leafNodes.add(array[j]);
            }
            List<Node> roots = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int index = sc.nextInt();
                if (index != 0) {
                    array[j].parentNode = array[index - 1];
                    array[index-1].childList.add(array[j]);
                    leafNodes.remove(array[index - 1]);
                } else {
                    //array[j].nextNode = null;
                    roots.add(array[j]);
                }
            }
            Node[] nodes = leafNodes.toArray(Node[]::new);
            int solution = solveChainReaction(nodes, roots);
//            System.out.println(Arrays.toString(array));
//            System.out.println(initiatorNodes);
            System.out.println("Case #" + i + ": " + solution);
        }
    }

    private static int solveChainReaction(Node[] leafNodes, List<Node> roots) {
        int sum=0;
        for (Node root: roots) {
            sum += calculateMaxSum(root,root.childList,new HashSet<>());
        }
        return sum;
    }

    private static int calculateMaxSum(Node parent,List<Node> childList,Set<Node> visited) {
        if(childList.isEmpty()){
            return parent.funValue;
        }
        if(visited.contains(parent)){
            return 0;
        }
        int sum= 0;
        for (Node child: childList) {
            if(!child.childList.isEmpty()){
                visited.add(parent);
                sum += calculateMaxSum(child, child.childList, visited);
            }else{
                sum += Math.max(child.funValue, parent.funValue);
            }
        }
        return sum;
    }

    public static List<List<Node>> permute(Node[] nodes) {
        List<List<Node>> results = new ArrayList<>();
        if (nodes == null || nodes.length == 0) {
            return results;
        }
        List<Node> result = new ArrayList<>();
        dfs(nodes, results, result);
        return results;
    }

    public static void dfs(Node[] nums, List<List<Node>> results, List<Node> result) {
        if (nums.length == result.size()) {
            List<Node> temp = new ArrayList<>(result);
            results.add(temp);
        }
        for (Node num : nums) {
            if (!result.contains(num)) {
                result.add(num);
                dfs(nums, results, result);
                result.remove(result.size() - 1);
            }
        }
    }

    private static int solveChainReaction(List<Node> initiatorNodes) {
        Set<Node> visited = new HashSet<>();
        int sum = 0;
        for (Node node : initiatorNodes) {
            int max = 0;
            while (node != null && !visited.contains(node)) {
                visited.add(node);
                max = Math.max(max, node.funValue);
                node = node.parentNode;
            }
            sum += max;
        }
        return sum;
    }

    static class Node {
        Node parentNode;
        int funValue;
        List<Node> childList = new ArrayList<>();

        Node(int funValue) {
            this.funValue = funValue;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "nextNode=" + parentNode.funValue +
                    ", funValue=" + funValue +
                    '}';
        }
    }
}
