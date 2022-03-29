package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

/**
 * @author yangxin
 * 2022/3/29 20:54
 */
@SuppressWarnings("DuplicatedCode")
public class MergeTwoBinaryTrees {

    public static void main(String[] args) {
//        TreeNode t11 = new TreeNode(1);
//        TreeNode t12 = new TreeNode(3);
//        TreeNode t13 = new TreeNode(2);
//        TreeNode t14 = new TreeNode(5);
//        t11.left = t12;
//        t11.right = t13;
//        t12.left = t14;
//
//        TreeNode t21 = new TreeNode(2);
//        TreeNode t22 = new TreeNode(1);
//        TreeNode t23 = new TreeNode(3);
//        TreeNode t24 = new TreeNode(4);
//        TreeNode t25 = new TreeNode(7);
//        t21.left = t22;
//        t21.right = t23;
//        t22.right = t24;
//        t23.right = t25;

        TreeNode t11 = new TreeNode(1);

        TreeNode t21 = new TreeNode(1);
        t21.left = new TreeNode(2);

        printTree(mergeTrees(t11, t21));
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

    private static TreeNode mergeTrees(TreeNode root1,TreeNode root2) {
        // 编写终止条件
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        // 编写单层逻辑
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }
}
