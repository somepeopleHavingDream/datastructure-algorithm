package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yangxin
 * 2022/3/27 18:51
 */
@SuppressWarnings("SameParameterValue")
public class PathSumIi {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(5);
//        TreeNode node2 = new TreeNode(4);
//        TreeNode node3 = new TreeNode(8);
//        TreeNode node4 = new TreeNode(11);
//        TreeNode node5 = new TreeNode(13);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node8 = new TreeNode(2);
//        TreeNode node9 = new TreeNode(5);
//        TreeNode node10 = new TreeNode(1);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left= node4;
//        node3.left = node5;
//        node3.right = node6;
//        node4.left = node7;
//        node4.right = node8;
//        node6.left = node9;
//        node6.right = node10;

//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        node1.left = node2;
//        node1.right = node3;

        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);

        System.out.println(pathSum(node1, 0));
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

    private static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        pathSum(root, targetSum, tmp, result);

        return result;
    }

    private static void pathSum(TreeNode root, int targetSum, List<Integer> tmp, List<List<Integer>> result) {
        // 编写终止条件
        if (root == null) {
            return;
        }

        tmp.add(root.val);
        int target = targetSum - root.val;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null && target == 0) {
            result.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
            return;
        } else if (left == null && right == null) {
            tmp.remove(tmp.size() - 1);
            return;
        }

        // 编写单层逻辑
        pathSum(left, target, tmp, result);
        pathSum(right, target, tmp, result);
        tmp.remove(tmp.size() - 1);
    }
}
