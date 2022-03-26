package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

/**
 * @author yangxin
 * 2022/3/26 17:50
 */
@SuppressWarnings("DuplicatedCode")
public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(2);
//        TreeNode node4 = new TreeNode(3);
//        TreeNode node5 = new TreeNode(3);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node7 = new TreeNode(4);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node4.left = node6;
//        node4.right = node7;

//        TreeNode node1 = null;

//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(2);
//        TreeNode node4 = new TreeNode(3);
//        TreeNode node5 = new TreeNode(3);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node7 = new TreeNode(4);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node3.right = node5;
//        node4.left = node6;
//        node5.right = node7;

//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        node1.left = node2;
//        node2.left = node3;
//        node3.left = node4;
//        node4.left = node5;

        System.out.println(isBalanced(node1));
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

    private static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1) {
            return false;
        } else {
            return Math.abs(leftHeight - rightHeight) <= 1;
        }
    }

    private static int getHeight(TreeNode root) {
        // 编写终止条件
        if (root == null) {
            return 0;
        }

        // 编写单层逻辑
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        } else if (Math.abs(leftHeight- rightHeight) <= 1) {
            return Math.max(leftHeight, rightHeight) + 1;
        } else {
            return -1;
        }
    }
}
