package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

/**
 * @author yangxin
 * 2022/3/26 16:21
 */
@SuppressWarnings("DuplicatedCode")
public class SymmetricTree {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(2);
//        TreeNode node4 = new TreeNode(3);
//        TreeNode node5 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node7 = new TreeNode(3);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node5;

        System.out.println(isSymmetric(node1));
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

    private static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        // 确定终止条件
        if (left == null && right == null) {
            return true;
        } else if (left == null) {
            return false;
        } else if (right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }

        // 编写单层逻辑
        boolean leftSame = isSymmetric(left.left, right.right);
        boolean rightSame = isSymmetric(left.right, right.left);
        return leftSame && rightSame;
    }
}
