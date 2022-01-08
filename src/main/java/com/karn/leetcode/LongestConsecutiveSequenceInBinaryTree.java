package com.karn.leetcode;

import static java.lang.Math.max;

public class LongestConsecutiveSequenceInBinaryTree {
    public int longestConsecutiveSequence(Node node) {
        if (node == null) {
            return -1;
        }
        int left = -1;
        int right = -1;
        if (node.left != null) {
            int l1 = 0, l2 = 0;
            if (node.left.data - node.data == 1) {
                l1 = longestConsecutiveSequence(node.left, 2);
            } else {
                l2 = longestConsecutiveSequence(node.left, 0);
            }
            left = max(l1, l2);
        }

        if (node.right != null) {
            int r1 = 0, r2 = 0;
            if (node.right.data - node.data == 1) {
                r1 = longestConsecutiveSequence(node.right, 2);
            } else {
                r2 = longestConsecutiveSequence(node.right, 0);
            }
            right = max(r1, r2);
        }
        int res = max(left, right);
        return res == 0 ? -1 : res;
    }

    private int longestConsecutiveSequence(Node node, int length) {
        if (node == null) {
            return length;
        }
        int left = length;
        int right = length;
        if (node.left != null) {
            int l1 = 0, l2 = 0;
            if (node.left.data - node.data == 1) {
                l1 = longestConsecutiveSequence(node.left, length == 0 ? length + 2 : length + 1);
            } else {
                l2 = longestConsecutiveSequence(node.left, 0);
            }
            left = max(max(l1, l2), left);
        }

        if (node.right != null) {
            int r1 = 0, r2 = 0;
            if (node.right.data - node.data == 1) {
                r1 = longestConsecutiveSequence(node.right, length == 0 ? length + 2 : length + 1);
            } else {
                r2 = longestConsecutiveSequence(node.right, 0);
            }
            right = max(right, max(r1, r2));
        }
        return max(left, right);

    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(Node left, Node right, int data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }
}
