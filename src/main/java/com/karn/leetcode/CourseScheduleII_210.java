package com.karn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleII_210 {
    public static void main(String[] args) {
        int[][] arr;//new int[][]{{1, 0}, {2, 0}, {3, 1}, {5, 2}, {4, 2}, {6, 5}, {7, 3}, {7, 6}};
        // arr = new int[][]{{1, 0}};
        //3
        //[[0,1],[0,2],[1,2]]
        //4
        //[[1,0],[2,0],[3,1],[3,2]]
//        3
//                [[1,0],[1,2],[0,1]]
//        4
//                [[3,0],[0,1]]
        arr = new int[][]{{3,0},{0,1}};
        System.out.println(Arrays.toString(
                new CourseScheduleII_210().findOrder(4,
                        arr)
        ));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) {
            return new int[1];
        }
        if (prerequisites.length == 0) {
            int[] arr = new int[numCourses];
            for (int j = 0; j < numCourses; j++) {
                arr[j] = j;
            }
            return arr;
        }
        Graph.Node[] arr = new Graph.Node[numCourses];

        for (int[] req : prerequisites) {
            int course = req[0];
            int pre = req[1];
            if (arr[pre] == null) {
                arr[pre] = new Graph.Node(pre);
            }
            if (arr[course] == null) {
                arr[course] = new Graph.Node(course);
            }
            arr[pre].outNode.add(arr[course]);
            arr[course].inNodes.add(arr[pre]);
        }
        Graph.Node rootNode = null;
        for (Graph.Node nodeInArr : arr) {
            if (nodeInArr != null && nodeInArr.inNodes.size() == 0) {
                rootNode = nodeInArr;
                break;
            }
        }
        if (rootNode == null) {
            return new int[]{};
        }
        //marking that the node has already been created
        arr[0] = rootNode;
        Graph graph = new Graph(rootNode);
        int[] result = new int[numCourses];
        visited = new boolean[numCourses];
        dfs(graph.rootNode, result);
        if (i + 1 < numCourses) {
            for (int j = i + 1; j < numCourses; j++) {
                result[j] = j;
            }
        }
        if(hasDuplicate(result)){
            return new int[0];
        }
        return result;
    }

    private boolean hasDuplicate(int[] result) {
        BitSet bitSet=new BitSet(result.length);
        for (int k : result) {
            if (!bitSet.get(k)) {
                bitSet.set(k);
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean[] visited;
    private int i = 0;

    private void dfs(Graph.Node node, int[] result) {
        if (!visited[node.val]) {
            visited[node.val] = true;
            result[i] = node.val;
        }
        if (node.outNode.size() > 0) {
            boolean flag = false;
            for (Graph.Node child : node.outNode) {
                if (child.inNodes.size() > 1) {
                    child.inNodes.remove(node);
                    node.outNode.remove(child);
                    flag = true;
                    break;
                } else if (child.inNodes.size() == 1) {
                    ++i;
                    dfs(child, result);
                }
                visited[child.val] = true;
            }
            if (flag) {
                dfs(node, result);
            }
        }
    }

    static class Graph {
        Node rootNode;

        Graph(Node rootNode) {
            this.rootNode = rootNode;
        }

        static class Node {
            int val;
            List<Node> inNodes = new ArrayList<>();
            List<Node> outNode = new ArrayList<>();

            public Node(int val) {
                this.val = val;
            }
        }
    }
}
