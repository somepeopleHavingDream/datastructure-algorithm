package org.yangxin.datastructurealgorithm.leetcode.foroffer.easy;

import javax.swing.tree.TreeNode;

/**
 * 对称的二叉树
 *
 * @author yangxin
 * 2020/08/19 17:41
 */
public class IsSymmetric {

    public static boolean isSymmetric(TreeNode root) {
        return false;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println(isSymmetric(node1));
    }

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
