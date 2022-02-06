package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.sample;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangxin
 * 2022/2/6 16:20
 */
public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;

        System.out.println(inorderTraversal(node1));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    private static void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
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
