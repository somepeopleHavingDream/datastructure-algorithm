package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yangxin
 * 2022/3/24 21:51
 */
@SuppressWarnings("DuplicatedCode")
public class PopulatingNextRightPointersInEachNodeIi {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;

        Node root = connect(node1);
        System.out.println(root == null ? "" : root.val);
    }

    private static class Node {

        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();

        root.next = null;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (curr == null) {
                    continue;
                }

                curr.next = i == size - 1 ? null : queue.peek();

                Node left = curr.left;
                if (left != null) {
                    queue.offer(left);
                }
                Node right = curr.right;
                if (right != null) {
                    queue.offer(right);
                }
            }
        }

        return root;
    }
}
