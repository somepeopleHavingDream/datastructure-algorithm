package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

/**
 * @author yangxin
 * 2022/3/29 21:54
 */
public class MinimumAbsoluteDifferenceInBst {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(4);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(6);
//        TreeNode node4 = new TreeNode(1);
//        TreeNode node5 = new TreeNode(3);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(48);
        TreeNode node4 = new TreeNode(12);
        TreeNode node5 = new TreeNode(49);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(getMinimumDifference(node1));
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

    private static TreeNode prev;
    private static Integer result = Integer.MAX_VALUE;

    private static int getMinimumDifference(TreeNode root) {
        inorder(root);
        return result;
    }

    private static void inorder(TreeNode root) {
        // 编写终止条件
        if (root == null) {
            return;
        }

        // 编写单层逻辑
        inorder(root.left);

        if (prev != null) {
            result = Math.min(result, root.val - prev.val);
        }
        prev = root;

        inorder(root.right);
    }
}
