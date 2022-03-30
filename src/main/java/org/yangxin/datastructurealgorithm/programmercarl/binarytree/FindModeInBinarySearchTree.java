package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangxin
 * 2022/3/29 22:47
 */
public class FindModeInBinarySearchTree {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(2);
//        node1.right = node2;
//        node2.left = node3;

        TreeNode node1 = new TreeNode(0);

        System.out.println(Arrays.toString(findMode(node1)));
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

    private static TreeNode prev;
    private static int count;
    private static int maxCount = Integer.MIN_VALUE;
    private static final List<Integer> RESULT = new LinkedList<>();

    private static int[] findMode(TreeNode root) {
        inorder(root);
        return RESULT.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void inorder(TreeNode root) {
        // 编写终止条件
        if (root == null) {
            return;
        }

        // 编写单层逻辑
        inorder(root.left);

        if (prev == null) {
            count = 1;
        } else if (prev.val == root.val){
            count++;
        } else {
            count = 1;
        }
        prev = root;

        if (count == maxCount) {
            RESULT.add(root.val);
        }
        if (count > maxCount) {
            RESULT.clear();
            RESULT.add(root.val);
        }

        maxCount = Math.max(maxCount, count);

        inorder(root.right);
    }
}
