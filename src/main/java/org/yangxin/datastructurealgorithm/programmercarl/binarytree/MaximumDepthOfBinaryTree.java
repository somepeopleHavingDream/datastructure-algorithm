package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yangxin
 * 2022/3/24 22:13
 */
@SuppressWarnings({"DuplicatedCode", "AlibabaRemoveCommentedCode"})
public class MaximumDepthOfBinaryTree {

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

//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        node1.right = node2;

//        System.out.println(maxDepthByLevelOrder(node1));
        System.out.println(maxDepthByRecursion(node1));
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

    private static int maxDepthByLevelOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }

                TreeNode left = node.left;
                if (left != null) {
                    queue.offer(left);
                }
                TreeNode right = node.right;
                if (right != null) {
                    queue.offer(right);
                }
            }

            depth++;
        }

        return depth;
    }

    private static int maxDepthByRecursion(TreeNode root) {
        // 确定终止条件
        if (root == null) {
            return 0;
        }

        // 编写单层逻辑
        return Math.max(maxDepthByRecursion(root.left), maxDepthByRecursion(root.right)) + 1;
    }
}
