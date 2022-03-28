package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

/**
 * @author yangxin
 * 2022/3/28 20:59
 */
public class MaximumBinaryTree {

    public static void main(String[] args) {
//        int[] nums = {3, 2, 1, 6, 0, 5};
        int[] nums = {3, 2, 1};

        printTree(constructMaximumBinaryTree(nums));
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

    private static TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private static TreeNode constructMaximumBinaryTree(int[] nums,
                                                       int startIndex,
                                                       int endIndex) {
        // 编写终止条件
        if (startIndex > endIndex) {
            return null;
        }

        /*
            编写单层逻辑
         */

        // 构造根节点
        int maxIndex = startIndex, max = nums[startIndex];
        for (int i = startIndex; i <= endIndex; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(max);

        // 构造左子树
        int leftEnd = maxIndex - 1;
        root.left = constructMaximumBinaryTree(nums, startIndex, leftEnd);

        // 构造右子树
        int rightStart = maxIndex + 1;
        root.right = constructMaximumBinaryTree(nums, rightStart, endIndex);

        return root;
    }
}
