package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.sample;

/**
 * @author yangxin
 * 2022/2/6 17:46
 */
@SuppressWarnings({"DuplicatedCode", "CommentedOutCode"})
public class DiameterOfBinaryTree {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;

//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        node1.left = node2;

//        TreeNode node1 = new TreeNode(1);

        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(1);
        node1.left = node2;
        node2.left = node3;

        System.out.println(diameterOfBinaryTree(node1));
    }

    private static Integer maxDiameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        diameterOfBinaryTree0(root);
        return maxDiameter;
    }

    private static int diameterOfBinaryTree0(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDiameter = root.left == null ? 0 : diameterOfBinaryTree0(root.left) + 1;
        int rightDiameter = root.right == null ? 0 : diameterOfBinaryTree0(root.right) + 1;

        maxDiameter = Math.max(maxDiameter, leftDiameter + rightDiameter);
        return Math.max(leftDiameter, rightDiameter);
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
