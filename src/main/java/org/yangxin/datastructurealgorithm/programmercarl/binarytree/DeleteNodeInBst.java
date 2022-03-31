package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

/**
 * @author yangxin
 * 2022/3/31 21:32
 */
public class DeleteNodeInBst {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(5);
//        TreeNode node2 = new TreeNode(3);
//        TreeNode node3 = new TreeNode(6);
//        TreeNode node4 = new TreeNode(2);
//        TreeNode node5 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(7);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.right = node6;

//        TreeNode node1 = new TreeNode(5);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(6);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(7);
//        node1.left = node2;
//        node1.right = node3;
//        node2.right = node4;
//        node3.right = node5;

        TreeNode node1 = null;

        printTree(deleteNode(node1, 0));
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

    private static TreeNode deleteNode(TreeNode root, int key) {
        // 编写终止条件
        if (root == null) {
            return null;
        }

        // 编写单层逻辑
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode curr = root.right;
                while (curr.left != null) {
                    curr = curr.left;
                }

                curr.left = root.left;
                TreeNode right = root.right;
                root.left = null;
                root.right = null;
                return right;
            }
        }

        return root;
    }
}
