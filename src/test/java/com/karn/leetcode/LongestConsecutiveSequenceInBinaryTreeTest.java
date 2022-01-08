package com.karn.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class LongestConsecutiveSequenceInBinaryTreeTest {
    private LongestConsecutiveSequenceInBinaryTree longestConsecutiveSequenceInBinaryTree =
            new LongestConsecutiveSequenceInBinaryTree();

    @Test
    public void testCase1() {
        LongestConsecutiveSequenceInBinaryTree.Node node7 =
                new LongestConsecutiveSequenceInBinaryTree.Node(null, null, 7);
        LongestConsecutiveSequenceInBinaryTree.Node node6 =
                new LongestConsecutiveSequenceInBinaryTree.Node(node7, null, 6);
        LongestConsecutiveSequenceInBinaryTree.Node node5 =
                new LongestConsecutiveSequenceInBinaryTree.Node(null, null, 5);
        LongestConsecutiveSequenceInBinaryTree.Node node4 =
                new LongestConsecutiveSequenceInBinaryTree.Node(node5, node6, 4);
        LongestConsecutiveSequenceInBinaryTree.Node node3 =
                new LongestConsecutiveSequenceInBinaryTree.Node(null, null, 3);
        LongestConsecutiveSequenceInBinaryTree.Node node2 =
                new LongestConsecutiveSequenceInBinaryTree.Node(node3, null, 2);
        LongestConsecutiveSequenceInBinaryTree.Node rootNode =
                new LongestConsecutiveSequenceInBinaryTree.Node(node2, node4, 1);

        Assert.assertEquals(3, longestConsecutiveSequenceInBinaryTree
        .longestConsecutiveSequence(rootNode));
    }
    @Test
    public void testCase2() {

        LongestConsecutiveSequenceInBinaryTree.Node node3 =
                new LongestConsecutiveSequenceInBinaryTree.Node(null, null, 3);
        LongestConsecutiveSequenceInBinaryTree.Node node2 =
                new LongestConsecutiveSequenceInBinaryTree.Node(null, null, 2);
        LongestConsecutiveSequenceInBinaryTree.Node rootNode =
                new LongestConsecutiveSequenceInBinaryTree.Node(node2, node3, 1);

        Assert.assertEquals(2, longestConsecutiveSequenceInBinaryTree
                .longestConsecutiveSequence(rootNode));
    }

    @Test
    public void testCase3() {
        LongestConsecutiveSequenceInBinaryTree.Node node7 =
                new LongestConsecutiveSequenceInBinaryTree.Node(null, null, 4);
        LongestConsecutiveSequenceInBinaryTree.Node node6 =
                new LongestConsecutiveSequenceInBinaryTree.Node(node7, null, 5);
        LongestConsecutiveSequenceInBinaryTree.Node node5 =
                new LongestConsecutiveSequenceInBinaryTree.Node(null, null, 5);
        LongestConsecutiveSequenceInBinaryTree.Node node4 =
                new LongestConsecutiveSequenceInBinaryTree.Node(node6, node7, 3);
        LongestConsecutiveSequenceInBinaryTree.Node node3 =
                new LongestConsecutiveSequenceInBinaryTree.Node(node4, node5, 2);
        LongestConsecutiveSequenceInBinaryTree.Node node2 =
                new LongestConsecutiveSequenceInBinaryTree.Node(null, null, -1);
        LongestConsecutiveSequenceInBinaryTree.Node rootNode =
                new LongestConsecutiveSequenceInBinaryTree.Node(node2, node3, 1);

        Assert.assertEquals(4, longestConsecutiveSequenceInBinaryTree
                .longestConsecutiveSequence(rootNode));
    }

    @Test
    public void testCase4() {
        LongestConsecutiveSequenceInBinaryTree.Node node7 =
                new LongestConsecutiveSequenceInBinaryTree.Node(null, null, 70);
        LongestConsecutiveSequenceInBinaryTree.Node node6 =
                new LongestConsecutiveSequenceInBinaryTree.Node(node7, null, 60);
        LongestConsecutiveSequenceInBinaryTree.Node node5 =
                new LongestConsecutiveSequenceInBinaryTree.Node(null, null, 50);
        LongestConsecutiveSequenceInBinaryTree.Node node4 =
                new LongestConsecutiveSequenceInBinaryTree.Node(node6, node7, 40);
        LongestConsecutiveSequenceInBinaryTree.Node node3 =
                new LongestConsecutiveSequenceInBinaryTree.Node(node4, node5, 30);
        LongestConsecutiveSequenceInBinaryTree.Node node2 =
                new LongestConsecutiveSequenceInBinaryTree.Node(null, null, 20);
        LongestConsecutiveSequenceInBinaryTree.Node rootNode =
                new LongestConsecutiveSequenceInBinaryTree.Node(node2, node3, 10);

        Assert.assertEquals(-1, longestConsecutiveSequenceInBinaryTree
                .longestConsecutiveSequence(rootNode));
    }
    @Test
    public void testCase5() {
        LongestConsecutiveSequenceInBinaryTree.Node node7 =
                new LongestConsecutiveSequenceInBinaryTree.Node(null, null, 61);
        LongestConsecutiveSequenceInBinaryTree.Node node6 =
                new LongestConsecutiveSequenceInBinaryTree.Node(node7, null, 60);
        LongestConsecutiveSequenceInBinaryTree.Node node5 =
                new LongestConsecutiveSequenceInBinaryTree.Node(null, null, 50);
        LongestConsecutiveSequenceInBinaryTree.Node node4 =
                new LongestConsecutiveSequenceInBinaryTree.Node(node6, node7, 40);
        LongestConsecutiveSequenceInBinaryTree.Node node3 =
                new LongestConsecutiveSequenceInBinaryTree.Node(node4, node5, 30);
        LongestConsecutiveSequenceInBinaryTree.Node node2 =
                new LongestConsecutiveSequenceInBinaryTree.Node(null, null, 20);
        LongestConsecutiveSequenceInBinaryTree.Node rootNode =
                new LongestConsecutiveSequenceInBinaryTree.Node(node2, node3, 10);

        Assert.assertEquals(2, longestConsecutiveSequenceInBinaryTree
                .longestConsecutiveSequence(rootNode));
    }
}