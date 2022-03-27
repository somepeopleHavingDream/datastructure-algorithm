package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

/**
 * @author yangxin
 * 2022/3/27 18:51
 */
public class PathSum {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(5);
//        TreeNode node2 = new TreeNode(4);
//        TreeNode node3 = new TreeNode(8);
//        TreeNode node4 = new TreeNode(11);
//        TreeNode node5 = new TreeNode(13);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node8 = new TreeNode(2);
//        TreeNode node9 = new TreeNode(1);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left= node4;
//        node3.left = node5;
//        node3.right = node6;
//        node4.left = node7;
//        node4.right = node8;
//        node6.right = node9;

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        System.out.println(hasPathSum(node1, 5));
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

    private static boolean hasPathSum(TreeNode root, int targetSum) {
        // 编写终止条件
        if (root == null) {
            return false;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        int target = targetSum - root.val;
        if (left == null && right == null && target == 0) {
            return true;
        } else if (left == null && right == null) {
            return false;
        }

        // 编写单层逻辑
        if (left != null) {
            if (hasPathSum(left, target)) {
                return true;
            }
        }
        if (right != null) {
            return hasPathSum(right, target);
        }

        return false;
    }
}
