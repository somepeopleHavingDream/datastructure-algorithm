package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

/**
 * @author yangxin
 * 2022/3/31 21:56
 */
public class TrimBinarySearchTree {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(0);
//        TreeNode node3 = new TreeNode(2);
//        node1.left = node2;
//        node1.right = node3;

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node4.left = node5;

        printTree(trimBst(node1, 1, 3));
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
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

    private static TreeNode trimBst(TreeNode root, int low, int high) {
        // 编写终止条件
        if (root == null) {
            return null;
        }

        // 编写单层逻辑
        if (root.val > high) {
            return trimBst(root.left, low, high);
        } else if (root.val < low) {
            return trimBst(root.right, low, high);
        } else {
            root.left = trimBst(root.left, low, high);
            root.right = trimBst(root.right, low, high);
            return root;
        }
    }
}
