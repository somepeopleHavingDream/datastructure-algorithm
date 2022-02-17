package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

import javax.swing.tree.TreeNode;
import java.util.Arrays;

/**
 * @author yangxin
 * 2022/2/16 21:17
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
//        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        int[] preorder = {-1}, inorder = {-1};
        printTree(buildTree(preorder, inorder));
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

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (root.val != inorder[i]) {
                continue;
            }

            root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + i),
                    Arrays.copyOfRange(inorder, 0, i));
            root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length),
                    Arrays.copyOfRange(inorder, i + 1, inorder.length));
        }

        return root;
    }
}
