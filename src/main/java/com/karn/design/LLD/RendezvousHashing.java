package com.karn.design.LLD;

import java.util.*;

public class RendezvousHashing {

    // Set of server nodes
    private final List<String> nodes;

    public RendezvousHashing(List<String> nodes) {
        this.nodes = nodes;
    }

    // Hash function combining node and key
    private int computeScore(String node, String key) {
        return Objects.hash(node, key); // simple hash combination
    }

    // Selects the best node for a given key
    public String getAssignedNode(String key) {
        String bestNode = null;
        int highestScore = Integer.MIN_VALUE;

        for (String node : nodes) {
            int score = computeScore(node, key);
            if (score > highestScore) {
                highestScore = score;
                bestNode = node;
            }
        }

        return bestNode;
    }

    public static void main(String[] args) {
        List<String> nodes = Arrays.asList("Node-A", "Node-B", "Node-C");
        RendezvousHashing rh = new RendezvousHashing(nodes);

        List<String> keys = Arrays.asList("User1", "User2", "User3", "User4");

        for (String key : keys) {
            String node = rh.getAssignedNode(key);
            System.out.println("Key: " + key + " is assigned to: " + node);
        }
        nodes.set(1,"Node-D");
        String node = rh.getAssignedNode("User0");
        System.out.println("Key: " + "User0" + " is assigned to: " + node);
    }
}
