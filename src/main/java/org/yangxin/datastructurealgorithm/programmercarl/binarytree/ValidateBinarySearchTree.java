package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

/**
 * @author yangxin
 * 2022/3/29 21:31
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

//        TreeNode node1 = new TreeNode(5);
//        TreeNode node2 = new TreeNode(1);
//        TreeNode node3 = new TreeNode(4);
//        TreeNode node4 = new TreeNode(3);
//        TreeNode node5 = new TreeNode(6);
//        node1.left = node2;
//        node1.right = node3;
//        node3.left = node4;
//        node3.right = node5;

//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(2);
//        node1.left = node2;
//        node1.right = node3;

        System.out.println(isValidBst(node1));
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

    private static TreeNode maxNode;

    private static boolean isValidBst(TreeNode root) {
        // 编写终止条件
        if (root == null) {
            return true;
        }

        // 编写单层逻辑
        boolean valid = isValidBst(root.left);
        if (!valid) {
            return false;
        }

        if (maxNode != null && maxNode.val >= root.val) {
            return false;
        }

        maxNode = root;
        return isValidBst(root.right);
    }
}
