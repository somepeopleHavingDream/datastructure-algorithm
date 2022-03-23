package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yangxin
 * 2022/3/23 22:57
 */
@SuppressWarnings("DuplicatedCode")
public class BinaryTreeRightSideView {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(5);
//        TreeNode node5 = new TreeNode(4);
//        node1.left = node2;
//        node1.right = node3;
//        node2.right = node4;
//        node3.right = node5;

//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(3);
//        node1.right = node2;

        TreeNode node1 = null;

        System.out.println(rightSideView(node1));
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

    private static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();

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

                if (i == size - 1) {
                    result.add(node.val);
                }
            }
        }

        return result;
    }
}
