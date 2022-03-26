package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

/**
 * @author yangxin
 * 2022/3/24 23:01
 */
@SuppressWarnings("DuplicatedCode")
public class InvertBinaryTree {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(4);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(7);
//        TreeNode node4 = new TreeNode(1);
//        TreeNode node5 = new TreeNode(3);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node7 = new TreeNode(9);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;

        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        printTree(invertTree(node1));
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
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

    private static TreeNode invertTree(TreeNode root) {
        // 确定终止条件
        if (root == null) {
            return null;
        }

        // 编写单层逻辑
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
