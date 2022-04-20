package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/20 16:15
 */
@SuppressWarnings("DuplicatedCode")
public class HouseRobberIii {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(3);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(3);
//        TreeNode node5 = new TreeNode(1);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node3.right = node5;

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;

        System.out.println(rob(node1));
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

    private static int rob(TreeNode root) {
        int[] dp = recursion(root);
        return Math.max(dp[0], dp[1]);
    }

    private static int[] recursion(TreeNode root) {
        // 终止条件
        if (root == null) {
            return new int[2];
        }

        int[] leftDp = recursion(root.left);
        int[] rightDp = recursion(root.right);

        int[] dp = new int[2];
        dp[0] = Math.max(leftDp[0], leftDp[1]) + Math.max(rightDp[0], rightDp[1]);
        dp[1] = root.val + leftDp[0] + rightDp[0];

        return dp;
    }
}
