package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yangxin
 * 2022/3/27 18:10
 */
@SuppressWarnings("DuplicatedCode")
public class FindBottomLeftTreeValue {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(1);
//        TreeNode node3 = new TreeNode(3);
//        node1.left = node2;
//        node1.right = node3;

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node5.left = node7;

        System.out.println(findBottomLeftValue(node1));
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

    private static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int bottomLeftTreeValue = -1;
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

                if (i == 0) {
                    bottomLeftTreeValue = node.val;
                }
            }
        }

        return bottomLeftTreeValue;
    }
}
