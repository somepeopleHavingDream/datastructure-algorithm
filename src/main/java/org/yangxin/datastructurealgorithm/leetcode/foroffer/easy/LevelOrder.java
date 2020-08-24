package org.yangxin.datastructurealgorithm.leetcode.foroffer.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 从上到下打印二叉树
 *
 * @author yangxin
 * 2020/08/24 17:31
 */
@SuppressWarnings("DuplicatedCode")
public class LevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        // 判空
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> resultList = new ArrayList<>();
        levelOrder(root, resultList);

        return resultList;
    }

    private static List<Integer> levelOrder(TreeNode root, List<List<Integer>> resultList) {
        // 判空
        if (root == null) {
            return Collections.emptyList();
        }

        // 先将自身节点包装成临时集合，再放入到结果集合中
        List<Integer> selfList = new ArrayList<>();
        selfList.add(root.val);
        resultList.add(selfList);

        // 处理孩子节点
        List<Integer> leftList = levelOrder(root.left, resultList);
        List<Integer> rightList = levelOrder(root.right, resultList);
        if (leftList.size() != 0 && rightList.size() != 0) {
            leftList.addAll(rightList);
            resultList.add(leftList);
        } else if (leftList.size() == 0) {
            resultList.add(rightList);
        } else {
            resultList.add(leftList);
        }

        return selfList;
    }

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
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.right = node5;

        System.out.println(levelOrder(node1));
    }

    /**
     * @author yangxin
     * 2020/08/24 17:33
     */
    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
