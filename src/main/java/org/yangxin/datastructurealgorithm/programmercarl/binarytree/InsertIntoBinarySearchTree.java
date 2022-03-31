package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

/**
 * @author yangxin
 * 2022/3/31 21:01
 */
@SuppressWarnings("DuplicatedCode")
public class InsertIntoBinarySearchTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        printTree(insertIntoBst(node1, 5));
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

    private static TreeNode insertIntoBst(TreeNode root, int val) {
        // 编写终止条件
        if (root == null) {
            return new TreeNode(val);
        }

        // 编写单层逻辑
        if (val < root.val) {
            root.left = insertIntoBst(root.left, val);
        } else if (val > root.val) {
            root.right = insertIntoBst(root.right, val);
        }

        return root;
    }
}
