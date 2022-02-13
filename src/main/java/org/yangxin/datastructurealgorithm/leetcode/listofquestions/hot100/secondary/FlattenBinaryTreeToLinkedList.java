package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yangxin
 * 2022/2/13 19:13
 */
public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(5);
//        TreeNode node4 = new TreeNode(3);
//        TreeNode node5 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(6);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.right = node6;

//        TreeNode node1 = null;

        TreeNode node1 = new TreeNode(0);

        flatten(node1);
        printTree(node1);
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }

        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    private static TreeNode last = null;

    private static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);

        root.right = last;
        root.left = null;

        last = root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
