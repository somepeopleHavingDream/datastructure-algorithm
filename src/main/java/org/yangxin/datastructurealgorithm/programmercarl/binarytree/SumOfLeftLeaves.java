package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

/**
 * @author yangxin
 * 2022/3/27 17:55
 */
public class SumOfLeftLeaves {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(3);
//        TreeNode node2 = new TreeNode(9);
//        TreeNode node3 = new TreeNode(10);
//        TreeNode node4 = new TreeNode(15);
//        TreeNode node5 = new TreeNode(7);
//        node1.left = node2;
//        node1.right = node3;
//        node3.left = node4;
//        node3.right = node5;

        TreeNode node1  = new TreeNode(1);

        System.out.println(sumOfLeftLeaves(node1));
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

    public static int sumOfLeftLeaves(TreeNode root) {
        // 编写终止条件
        if (root == null) {
            return 0;
        }

        // 编写单层逻辑
        int currentSum = 0;
        TreeNode left = root.left;
        if (left != null && left.left == null && left.right == null) {
            currentSum = left.val;
        }

        return currentSum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
