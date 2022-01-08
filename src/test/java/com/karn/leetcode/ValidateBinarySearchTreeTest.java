package com.karn.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateBinarySearchTreeTest {

    private ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();

    @Test
    public void testCase1() {
        ValidateBinarySearchTree.TreeNode treeNode7 =
                new ValidateBinarySearchTree.TreeNode(null, null, 6);
        ValidateBinarySearchTree.TreeNode treeNode6 =
                new ValidateBinarySearchTree.TreeNode(null, null, 3);
        ValidateBinarySearchTree.TreeNode treeNode3 =
                new ValidateBinarySearchTree.TreeNode(treeNode6, treeNode7, 4);
        ValidateBinarySearchTree.TreeNode treeNode2 =
                new ValidateBinarySearchTree.TreeNode(null, null, 1);
        ValidateBinarySearchTree.TreeNode treeNode1 =
                new ValidateBinarySearchTree.TreeNode(treeNode2, treeNode3, 5);

        assertFalse(validateBinarySearchTree.isValidBST(treeNode1));
    }

    //    [5,4,6,null,null,3,7]
    @Test
    public void testCase2() {
        ValidateBinarySearchTree.TreeNode treeNode7 =
                new ValidateBinarySearchTree.TreeNode(null, null, 7);
        ValidateBinarySearchTree.TreeNode treeNode6 =
                new ValidateBinarySearchTree.TreeNode(null, null, 3);
        ValidateBinarySearchTree.TreeNode treeNode3 =
                new ValidateBinarySearchTree.TreeNode(treeNode6, treeNode7, 6);
        ValidateBinarySearchTree.TreeNode treeNode2 =
                new ValidateBinarySearchTree.TreeNode(null, null, 4);
        ValidateBinarySearchTree.TreeNode treeNode1 =
                new ValidateBinarySearchTree.TreeNode(treeNode2, treeNode3, 5);

        assertFalse(validateBinarySearchTree.isValidBST(treeNode1));
    }
    @Test
    public void testCase3() {
        ValidateBinarySearchTree.TreeNode treeNode3 =
                new ValidateBinarySearchTree.TreeNode(null, null, 2);
        ValidateBinarySearchTree.TreeNode treeNode2 =
                new ValidateBinarySearchTree.TreeNode(null, null, 2);
        ValidateBinarySearchTree.TreeNode treeNode1 =
                new ValidateBinarySearchTree.TreeNode(treeNode2, treeNode3, 2);

        assertFalse(validateBinarySearchTree.isValidBST(treeNode1));
    }

    @Test
    public void testCase4() {
        ValidateBinarySearchTree.TreeNode treeNode7 =
                new ValidateBinarySearchTree.TreeNode(null, null, 6);
        ValidateBinarySearchTree.TreeNode treeNode6 =
                new ValidateBinarySearchTree.TreeNode(treeNode7, null, 9);
        ValidateBinarySearchTree.TreeNode treeNode5 =
                new ValidateBinarySearchTree.TreeNode(null, null, 4);
        ValidateBinarySearchTree.TreeNode treeNode4 =
                new ValidateBinarySearchTree.TreeNode(null, null, 2);
        ValidateBinarySearchTree.TreeNode treeNode3 =
                new ValidateBinarySearchTree.TreeNode(treeNode5, treeNode6, 7);
        ValidateBinarySearchTree.TreeNode treeNode2 =
                new ValidateBinarySearchTree.TreeNode(null, treeNode4, 1);
        ValidateBinarySearchTree.TreeNode treeNode1 =
                new ValidateBinarySearchTree.TreeNode(treeNode2, treeNode3, 3);

        assertFalse(validateBinarySearchTree.isValidBST(treeNode1));
    }

    @Test
    public void testCase5() {
        ValidateBinarySearchTree.TreeNode treeNode7 =
                new ValidateBinarySearchTree.TreeNode(null, null, 8);
        ValidateBinarySearchTree.TreeNode treeNode6 =
                new ValidateBinarySearchTree.TreeNode(treeNode7, null, 9);
        ValidateBinarySearchTree.TreeNode treeNode5 =
                new ValidateBinarySearchTree.TreeNode(null, null, 4);
        ValidateBinarySearchTree.TreeNode treeNode4 =
                new ValidateBinarySearchTree.TreeNode(null, null, 2);
        ValidateBinarySearchTree.TreeNode treeNode3 =
                new ValidateBinarySearchTree.TreeNode(treeNode5, treeNode6, 7);
        ValidateBinarySearchTree.TreeNode treeNode2 =
                new ValidateBinarySearchTree.TreeNode(null, treeNode4, 1);
        ValidateBinarySearchTree.TreeNode treeNode1 =
                new ValidateBinarySearchTree.TreeNode(treeNode2, treeNode3, 3);

        assertTrue(validateBinarySearchTree.isValidBST(treeNode1));
    }

    @Test
    public void testCase6(){
//        [24,-60,null,-60,-6]
        ValidateBinarySearchTree.TreeNode treeNode4 =
                new ValidateBinarySearchTree.TreeNode(null, null, -6);
        ValidateBinarySearchTree.TreeNode treeNode3 =
                new ValidateBinarySearchTree.TreeNode(null, null, -60);
        ValidateBinarySearchTree.TreeNode treeNode2 =
                new ValidateBinarySearchTree.TreeNode(treeNode3, treeNode4, -60);
        ValidateBinarySearchTree.TreeNode treeNode1 =
                new ValidateBinarySearchTree.TreeNode(treeNode2, null, 24);

        assertFalse(validateBinarySearchTree.isValidBST(treeNode1));
    }
    @Test
    public void testCase7(){
        ValidateBinarySearchTree.TreeNode treeNode2 =
                new ValidateBinarySearchTree.TreeNode(null, null, 2147483647);
        ValidateBinarySearchTree.TreeNode treeNode1 =
                new ValidateBinarySearchTree.TreeNode(null, treeNode2, -2147483648);

        assertTrue(validateBinarySearchTree.isValidBST(treeNode1));
    }
//    [-2147483648,null,]
}