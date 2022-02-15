package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

/**
 * @author yangxin
 * 2022/2/15 20:07
 */
@SuppressWarnings("UnnecessaryLocalVariable")
public class ConvertBstToGreaterTree {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(4);
//        TreeNode node2 = new TreeNode(1);
//        TreeNode node3 = new TreeNode(6);
//        TreeNode node4 = new TreeNode(0);
//        TreeNode node5 = new TreeNode(2);
//        TreeNode node6 = new TreeNode(5);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node8 = new TreeNode(3);
//        TreeNode node9 = new TreeNode(8);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
//        node5.right = node8;
//        node7.right = node9;

        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        node1.right = node2;

        printTree(convertBst(node1));
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

    private static int sum;

    private static TreeNode convertBst(TreeNode root) {
        if (root != null) {
            convertBst(root.right);
            int tmp = root.val;
            root.val += sum;
            sum += tmp;
            convertBst(root.left);

            return root;
        }

        return null;
    }
}
