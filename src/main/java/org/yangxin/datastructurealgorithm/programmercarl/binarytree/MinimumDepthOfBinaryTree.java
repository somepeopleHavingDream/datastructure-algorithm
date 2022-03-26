package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yangxin
 * 2022/3/24 22:13
 */
@SuppressWarnings({"DuplicatedCode"})
public class MinimumDepthOfBinaryTree {

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

//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(3);
//        TreeNode node3 = new TreeNode(4);
//        TreeNode node4 = new TreeNode(5);
//        TreeNode node5 = new TreeNode(6);
//        node1.right = node2;
//        node2.right = node3;
//        node3.right = node4;
//        node4.right = node5;

//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;

        System.out.println(minDepthByLevelOrder(node1));
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

    private static int minDepthByLevelOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            depth++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }

                TreeNode left = node.left;
                TreeNode right = node.right;

                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
                if (left == null && right == null) {
                    return depth;
                }
            }
        }

        return depth;
    }

    private static int minDepthByRecursion(TreeNode root) {
        // 编写终止条件
        if (root == null) {
            return 0;
        }

        // 编写单层逻辑
        int leftDepth = minDepthByRecursion(root.left);
        int rightDepth = minDepthByRecursion(root.right);
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return rightDepth + 1;
        } else if (root.right == null) {
            return leftDepth + 1;
        } else {
            return Math.min(leftDepth, rightDepth) + 1;
        }
    }
}
