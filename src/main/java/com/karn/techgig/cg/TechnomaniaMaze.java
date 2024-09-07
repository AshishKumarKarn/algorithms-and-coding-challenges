package com.karn.techgig.cg;

import java.util.ArrayList;
import java.util.List;

public class TechnomaniaMaze {

    static class Node {
        int id;
        char flag; // 'G' for green, 'R' for red
        List<Node> neighbors;

        Node(int id, char flag) {
            this.id = id;
            this.flag = flag;
            this.neighbors = new ArrayList<>();
        }
    }

    static class Result {
        int maxPosts;
    }

    public static void main(String[] args) {
        int N = 5;
        Node[] nodes = new Node[N];
        nodes[0] = new Node(1, 'G');
        nodes[1] = new Node(2, 'G');
        nodes[2] = new Node(3, 'R');
        nodes[3] = new Node(4, 'G');
        nodes[4] = new Node(5, 'G');

        // Creating edges to form the tree
        nodes[0].neighbors.add(nodes[1]);
        nodes[1].neighbors.add(nodes[0]);

        nodes[1].neighbors.add(nodes[2]);
        nodes[2].neighbors.add(nodes[1]);

        nodes[1].neighbors.add(nodes[3]);
        nodes[3].neighbors.add(nodes[1]);

        nodes[3].neighbors.add(nodes[4]);
        nodes[4].neighbors.add(nodes[3]);

        for (Node node : nodes) {
            Result result = new Result();
            boolean[] visited = new boolean[N];
            dfs(node, 0, result, visited);
            System.out.println("Maximum number of posts reachable from post " + node.id + ": " + result.maxPosts);
        }
    }

    public static void dfs(Node node, int redCount, Result result, boolean[] visited) {
        visited[node.id - 1] = true;
        result.maxPosts++;

        for (Node neighbor : node.neighbors) {
            if (!visited[neighbor.id - 1]) {
                if (neighbor.flag == 'R') {
                    if ((redCount + 1) % 2 == 0) {
                        dfs(neighbor, redCount + 1, result, visited);
                    }
                } else {
                    dfs(neighbor, redCount, result, visited);
                }
            }
        }

        visited[node.id - 1] = false;
        result.maxPosts--;
    }
}
