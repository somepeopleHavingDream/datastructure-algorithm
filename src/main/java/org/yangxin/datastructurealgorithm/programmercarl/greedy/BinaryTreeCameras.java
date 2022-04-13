package org.yangxin.datastructurealgorithm.programmercarl.greedy;

/**
 * @author yangxin
 * 2022/4/13 21:21
 */
@SuppressWarnings("AlibabaUndefineMagicConstant")
public class BinaryTreeCameras {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;

//        TreeNode node1 = new TreeNode(0);
//        TreeNode node2 = new TreeNode(0);
//        TreeNode node3 = new TreeNode(0);
//        TreeNode node4 = new TreeNode(0);
//        TreeNode node5 = new TreeNode(0);
//        node1.left = node2;
//        node2.left = node3;
//        node3.left = node4;
//        node4.right = node5;

        System.out.println(minCameraCover(node1));
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

    private static int count = 0;

    private static int minCameraCover(TreeNode root) {
        int returnVal = traverse(root);
        return returnVal == 0 ? ++count : count;
    }

    private static int traverse(TreeNode root) {
        /*
            0，无覆盖
            1，需要安装
            2，被覆盖
         */

        // 终止条件
        if (root == null) {
            return 2;
        }

        // 单层逻辑
        int left = traverse(root.left);
        int right = traverse(root.right);

        // 左右孩子都有一个被覆盖
        if (left == 2 && right == 2) {
            return 0;
        }

        // 左右孩子至少有一个未被覆盖
        if (left == 0 || right == 0) {
            // 需要安装监控
            count++;
            return 1;
        }

        // 左右孩子至少有一个需要安装
        if (left == 1 || right == 1) {
            // 不需要安装
            return 2;
        }

        return -1;
    }
}
