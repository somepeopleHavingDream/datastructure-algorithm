package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

/**
 * @author yangxin
 * 2022/4/1 21:05
 */
public class ConvertBstToGreaterTree {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(4);
//        TreeNode node2 = new TreeNode(1);
//        TreeNode node3 = new TreeNode(6);
//        TreeNode node4 = new TreeNode(0);
//        TreeNode node5 = new TreeNode(2);
//        TreeNode node6 = new TreeNode(5);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node8 = new TreeNode(3);
//        TreeNode node9 = new TreeNode(8);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
//        node5.right = node8;
//        node7.right = node9;

        TreeNode node1 = new TreeNode(0);
        node1.right = new TreeNode(1);

        printTree(convertBst(node1));
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

    private static int prevValue;

    private static TreeNode convertBst(TreeNode root) {
        traverse(root);
        return root;
    }

    private static void traverse(TreeNode root) {
        // 编写终止条件
        if (root == null) {
            return;
        }

        // 编写单层逻辑
        traverse(root.right);

        root.val += prevValue;
        prevValue = root.val;

        traverse(root.left);
    }
}
