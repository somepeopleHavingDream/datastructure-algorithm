package org.yangxin.datastructurealgorithm.programmercarl.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangxin
 * 2022/3/26 14:22
 */
@SuppressWarnings("DuplicatedCode")
public class NaryTreePostorderTraversal {

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

        System.out.println(postorder(node1));
    }

    private static class Node {

        public int val;
        public List<Node> children;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    private static List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private static void postorder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        List<Node> children = root.children;
        if (children == null) {
            result.add(root.val);
            return;
        }

        for (Node child : children) {
            postorder(child, result);
        }

        result.add(root.val);
    }
}
