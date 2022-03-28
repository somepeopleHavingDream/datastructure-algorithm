package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

/**
 * @author yangxin
 * 2022/3/27 21:15
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
//        int[] preorder = {3, 9, 20, 15, 7};
//        int[] inorder = {9, 3, 15, 20, 7};

        int[] preorder = {-1};
        int[] inorder = {-1};

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
        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private static TreeNode buildTree(int[] preorder, int preStartIndex, int preEndIndex,
                                      int[] inorder, int inStartIndex, int inEndIndex) {
        // 编写终止条件
        if (preStartIndex > preEndIndex) {
            return null;
        }

        /*
            编写单层逻辑
         */

        // 构建当前结点
        int currentValue = preorder[preStartIndex];
        TreeNode root = new TreeNode(currentValue);

        // 构建左子树
        int leftInEndIndex = calcLeftInEndIndex(inorder, inStartIndex, inEndIndex, currentValue);
        int leftPreStartIndex = preStartIndex + 1;
        int leftPreEndIndex = calLeftPreEndIndex(leftPreStartIndex, leftInEndIndex - inStartIndex + 1);
        root.left = buildTree(preorder, leftPreStartIndex, leftPreEndIndex,
                inorder, inStartIndex, leftInEndIndex);

        // 构建右子树
        int rightInStartIndex = leftInEndIndex + 2;
        int rightPreStartIndex = leftPreEndIndex + 1;
        root.right = buildTree(preorder, rightPreStartIndex, preEndIndex,
                inorder, rightInStartIndex, inEndIndex);

        return root;
    }

    private static int calLeftPreEndIndex(int leftPreStartIndex, int length) {
        return leftPreStartIndex + length - 1;
    }

    private static int calcLeftInEndIndex(int[] inorder, int inStartIndex, int inEndIndex, int currentValue) {
        int i = inStartIndex;
        for (; i <= inEndIndex; i++) {
            if (inorder[i] == currentValue) {
                return i - 1;
            }
        }

        return -1;
    }
}
