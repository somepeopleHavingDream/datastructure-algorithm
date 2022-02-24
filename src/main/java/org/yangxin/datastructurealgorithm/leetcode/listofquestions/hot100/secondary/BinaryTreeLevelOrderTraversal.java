package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

import java.util.*;

/**
 * @author yangxin
 * 2022/2/24 21:54
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(3);
//        TreeNode node2 = new TreeNode(9);
//        TreeNode node3 = new TreeNode(20);
//        TreeNode node4 = new TreeNode(15);
//        TreeNode node5 = new TreeNode(7);
//        node1.left = node2;
//        node1.right = node3;
//        node3.left = node4;
//        node3.right = node5;

//        TreeNode node1 = new TreeNode(1);

        TreeNode node1 = new TreeNode();
        System.out.println(levelOrder(node1));
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

    private static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();

        // 先将头结点入队，以启动接下来的流程
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            result.add(tmp);

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    break;
                }

                tmp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }
}
