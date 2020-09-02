package org.yangxin.datastructurealgorithm.leetcode.foroffer.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 从上到下打印二叉树
 *
 * @author yangxin
 * 2020/08/24 17:31
 */
@SuppressWarnings("DuplicatedCode")
public class LevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        // 如果根节点为null，则直接返回空集
        if (root == null) {
            return Collections.emptyList();
        }

        // 层序遍历，用队列
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        queue.add(root);
        collectAndEnqueue(queue, resultList);

        return resultList;
    }

    /**
     * 将当前队列中的元素出队，并将当前节点的孩子节点出队
     */
    private static void collectAndEnqueue(Queue<TreeNode> queue, List<List<Integer>> resultList) {
        // 如果队列中有元素，则出队并收集到集合中返回
        List<TreeNode> currentNodeList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            currentNodeList.add(poll);
        }

        resultList.add(currentNodeList.stream().map(treeNode -> treeNode.val).collect(Collectors.toList()));

        // 再将下一层级的元素入队
        for (TreeNode treeNode : currentNodeList) {
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }

        if (!queue.isEmpty()) {
            collectAndEnqueue(queue, resultList);
        }
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
        node3.right = node5;

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
