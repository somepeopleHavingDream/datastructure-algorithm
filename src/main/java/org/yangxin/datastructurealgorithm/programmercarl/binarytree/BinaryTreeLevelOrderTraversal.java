package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

import java.util.*;

/**
 * @author yangxin
 * 2022/3/23 22:27
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

//        TreeNode node1 = null;

        TreeNode node1 = new TreeNode(1);

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
        // 检查参数
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new LinkedList<>();

        // 将头结点置入队列，以启动层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // 处理当前层的结点
            List<Integer> tmp = new ArrayList<>();
            result.add(tmp);

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
                tmp.add(node.val);
            }
        }

        return result;
    }
}
