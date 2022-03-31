package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

/**
 * @author yangxin
 * 2022/3/31 20:38
 */
@SuppressWarnings({"AlibabaAvoidComplexCondition", "DuplicatedCode"})
public class LowestCommonAncestorOfBinarySearchTree {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(6);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(8);
//        TreeNode node4 = new TreeNode(0);
//        TreeNode node5 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(7);
//        TreeNode node7 = new TreeNode(9);
//        TreeNode node8 = new TreeNode(3);
//        TreeNode node9 = new TreeNode(5);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
//        node5.left = node8;
//        node5.right = node9;

        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        node1.left = node2;

        TreeNode node = lowestCommonAncestor(node1, node1, node2);
        System.out.println(node == null ? "" : node.val);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private static TreeNode lowestCommonAncestor(TreeNode root,TreeNode p, TreeNode q) {
        // 编写终止条件
        if (root == null) {
            return null;
        }

        // 编写单层逻辑
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
