package org.yangxin.datastructurealgorithm.leetcode.listofquestions.foroffer.easy;

/**
 * 二叉树的镜像
 *
 * @author yangxin
 * 2020/08/19 10:19
 */
public class MirrorTree {

    public static TreeNode mirrorTree(TreeNode root) {
        if (root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            mirrorTree(root.left);
            mirrorTree(root.right);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        TreeNode root = mirrorTree(node1);
        printTree(root);
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    /**
     * @author yangxin
     * 2020/08/19 10:19
     */
    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
