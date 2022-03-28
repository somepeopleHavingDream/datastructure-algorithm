package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

import java.util.Arrays;

/**
 * @author yangxin
 * 2022/3/27 21:15
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

//        int[] inorder = {-1};
//        int[] postorder = {-1};

        printTree(buildTree(inorder, postorder));
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

    private static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private static TreeNode buildTree(int[] inorder, int inorderStartIndex, int inorderEndIndex,
                                      int[] postorder, int postorderStartIndex, int postorderEndIndex) {
        // 编写终止条件
        if (postorderStartIndex > postorderEndIndex) {
            return null;
        }

        /*
            编写单层逻辑
         */

        // 构造根节点
        TreeNode root = new TreeNode(postorder[postorderEndIndex]);

        // 构造左子树
        int leftInorderEndIndex = calcInorderEndIndex(inorder, root.val);
        int leftPostorderEndIndex = calcPostorderEndIndex(postorderStartIndex,
                leftInorderEndIndex - inorderStartIndex + 1);
        root.left = buildTree(inorder, inorderStartIndex, leftInorderEndIndex,
                postorder, postorderStartIndex, leftPostorderEndIndex);

        // 构造右子树
        int rightInorderStartIndex = leftInorderEndIndex + 2;
        int rightPostorderStartIndex = leftPostorderEndIndex + 1;
        int rightPostorderEndIndex = postorderEndIndex - 1;
        root.right = buildTree(inorder, rightInorderStartIndex, inorderEndIndex,
                postorder, rightPostorderStartIndex, rightPostorderEndIndex);

        return root;
    }

    private static int calcPostorderEndIndex(int postorderStartIndex,
                                             int length) {
        return postorderStartIndex + length - 1;
    }

    private static int calcInorderEndIndex(int[] inorder, int val) {
        int i = 0;
        for (; i < inorder.length; i++) {
            if (inorder[i] == val) {
                return i - 1;
            }
        }

        return -1;
    }
}
