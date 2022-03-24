package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yangxin
 * 2022/3/23 22:27
 */
@SuppressWarnings("DuplicatedCode")
public class FindLargestValueInEachTreeRow {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(3);
//        TreeNode node3 = new TreeNode(2);
//        TreeNode node4 = new TreeNode(5);
//        TreeNode node5 = new TreeNode(3);
//        TreeNode node6 = new TreeNode(9);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.right = node6;

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        System.out.println(largestValues(node1));
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

    private static List<Integer> largestValues(TreeNode root) {
        // 检查参数
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new LinkedList<>();

        // 将头结点置入队列，以启动层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }

                // 如果该结点有左子结点
                TreeNode left = node.left;
                if (left != null) {
                    queue.offer(left);
                }

                // 如果该结点有右子结点
                TreeNode right = node.right;
                if (right != null) {
                    queue.offer(right);
                }

                // 将当前层的结点值放入集合中
                max = Math.max(max, node.val);
            }

            result.add(max);
        }

        return result;
    }
}
