package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.sample;

/**
 * @author yangxin
 * 2022/2/6 23:14
 */
public class MergeTwoBinaryTrees {

    public static void main(String[] args) {
        TreeNode t1n1 = new TreeNode(1);
        TreeNode t1n2 = new TreeNode(3);
        TreeNode t1n3 = new TreeNode(2);
        TreeNode t1n4 = new TreeNode(5);
        t1n1.left = t1n2;
        t1n1.right = t1n3;
        t1n2.left = t1n4;

        TreeNode t2n1 = new TreeNode(2);
        TreeNode t2n2 = new TreeNode(1);
        TreeNode t2n3 = new TreeNode(3);
        TreeNode t2n4 = new TreeNode(4);
        TreeNode t2n5 = new TreeNode(7);
        t2n1.left = t2n2;
        t2n1.right = t2n3;
        t2n2.right = t2n4;
        t2n3.right = t2n5;

        printTree(mergeTrees(t1n1, t2n1));
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println(null + "");
            return;
        }

        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    private static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
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
}
