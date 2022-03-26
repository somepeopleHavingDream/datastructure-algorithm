package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangxin
 * 2022/3/26 18:46
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(5);
//        node1.left = node2;
//        node1.right = node3;
//        node2.right = node4;

        TreeNode node1 = new TreeNode(1);

        System.out.println(binaryTreePaths(node1));
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

    private static List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<TreeNode> path = new LinkedList<>();
        List<String> result = new ArrayList<>();
        getPath(root, path, result);

        return result;
    }

    private static void getPath(TreeNode root, List<TreeNode> path, List<String> result) {
        path.add(root);

        // 编写终止条件
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) {
            result.add(getPathString(path));
            return;
        }

        // 编写单层逻辑
        if (left != null){
            getPath(left, path, result);
            path.remove(path.size() - 1);
        }
        if (right != null) {
            getPath(right, path, result);
            path.remove(path.size() - 1);
        }
    }

    private static String getPathString(List<TreeNode> path) {
        StringBuilder builder = new StringBuilder();

        int size = path.size();
        for (int i = 0; i < size - 1; i++) {
            builder.append(path.get(i).val)
                    .append("->");
        }
        builder.append(path.get(size - 1).val);

        return builder.toString();
    }
}
