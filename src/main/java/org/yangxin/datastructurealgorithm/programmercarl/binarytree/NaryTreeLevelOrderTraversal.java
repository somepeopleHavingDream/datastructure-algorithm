package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

import java.util.*;

/**
 * @author yangxin
 * 2022/3/24 21:30
 */
public class NaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.children = Arrays.asList(node2, node3, node4);
        node2.children = Arrays.asList(node5, node6);

        System.out.println(levelOrder(node1));
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

    public static List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new LinkedList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> tmp = new LinkedList<>();
            result.add(tmp);

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node == null) {
                    continue;
                }

                tmp.add(node.val);

                List<Node> children = node.children;
                if (children == null || children.size() == 0) {
                    continue;
                }

                for (Node child : children) {
                    queue.offer(child);
                }
            }
        }

        return result;
    }
}
