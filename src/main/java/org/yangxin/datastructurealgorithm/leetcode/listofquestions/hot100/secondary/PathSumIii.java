package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

/**
 * @author yangxin
 * 2022/4/28 17:24
 */
public class PathSumIii {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(10);
//        TreeNode node2 = new TreeNode(5);
//        TreeNode node3 = new TreeNode(-3);
//        TreeNode node4 = new TreeNode(3);
//        TreeNode node5 = new TreeNode(2);
//        TreeNode node6 = new TreeNode(11);
//        TreeNode node7 = new TreeNode(3);
//        TreeNode node8 = new TreeNode(-2);
//        TreeNode node9 = new TreeNode(1);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.right = node6;
//        node4.left = node7;
//        node4.right = node8;
//        node5.right = node9;

//        TreeNode node1 = new TreeNode(5);
//        TreeNode node2 = new TreeNode(4);
//        TreeNode node3 = new TreeNode(8);
//        TreeNode node4 = new TreeNode(11);
//        TreeNode node5 = new TreeNode(13);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node8 = new TreeNode(2);
//        TreeNode node9 = new TreeNode(5);
//        TreeNode node10 = new TreeNode(1);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node3.left = node5;
//        node3.right = node6;
//        node4.left = node7;
//        node4.right = node8;
//        node6.left = node9;
//        node6.right = node10;

//        TreeNode node1 = new TreeNode(-2);
//        node1.right = new TreeNode(-3);

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(-2);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(-2);
        TreeNode node7 = new TreeNode(-1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node4.left = node7;

        System.out.println(pathSum(node1, -1));
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

    private static int pathNum;

    private static int pathSum(TreeNode root, int targetSum) {
        dps(root, targetSum);
        return pathNum;
    }

    private static void dps(TreeNode root, int targetSum) {
        // 编写终止条件
        if (root == null) {
            return;
        }

        // 编写单层逻辑
        // 每个结点都有可能是路径的起点
        dpsSum(root, targetSum);
        dps(root.left, targetSum);
        dps(root.right, targetSum);
    }

    private static void dpsSum(TreeNode root, int targetSum) {
        // 编写终止条件
        if (root == null) {
            return;
        }

        // 编写单层逻辑
        int rootVal = root.val;
        if (root.val == targetSum) {
            pathNum++;
        }

        int remainingVal = targetSum - rootVal;
        dpsSum(root.left, remainingVal);
        dpsSum(root.right, remainingVal);
    }
}
