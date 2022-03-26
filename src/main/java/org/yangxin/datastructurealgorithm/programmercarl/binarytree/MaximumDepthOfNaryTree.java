package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

import java.util.Arrays;
import java.util.List;

/**
 * @author yangxin
 * 2022/3/26 16:54
 */
@SuppressWarnings("DuplicatedCode")
public class MaximumDepthOfNaryTree {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> nodeList1 = Arrays.asList(node2, node3, node4);
        List<Node> nodeList2 = Arrays.asList(node5, node6);
        node1.children = nodeList1;
        node2.children = nodeList2;

        System.out.println(maxDepth(node1));
    }

    private static class Node {

        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    private static int maxDepth(Node root) {
        // 编写终止条件
        if (root == null) {
            return 0;
        }

        // 编写单层逻辑
        List<Node> children = root.children;
        if (children == null || children.size() == 0) {
            return 1;
        }

        int max = Integer.MIN_VALUE;
        for (Node child : children) {
            max = Math.max(max, maxDepth(child));
        }

        return max + 1;
    }
}
