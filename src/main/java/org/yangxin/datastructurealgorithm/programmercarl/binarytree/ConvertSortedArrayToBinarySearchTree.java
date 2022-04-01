package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

/**
 * @author yangxin
 * 2022/4/1 20:49
 */
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
//        int[] nums = {-10, -3, 0, 5, 9};
        int[] nums = {3, 1};

        printTree(sortedArrayToBst(nums));
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

    private static TreeNode sortedArrayToBst(int[] nums) {
        return buildBst(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBst(int[] nums, int left, int right) {
        // 编写终止条件
        if (left > right)  {
            return null;
        }

        // 编写单层逻辑
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBst(nums, left, mid - 1);
        root.right = buildBst(nums, mid + 1, right);

        return root;
    }
}
