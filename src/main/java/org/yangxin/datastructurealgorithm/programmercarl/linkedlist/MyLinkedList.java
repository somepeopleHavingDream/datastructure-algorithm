package org.yangxin.datastructurealgorithm.programmercarl.linkedlist;

/**
 * @author yangxin
 * 2022/3/7 21:09
 */
public class MyLinkedList {

    private static class Node {
        int val;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

    private final Node dummyHead;

    public MyLinkedList() {
        dummyHead = new Node();
    }

    public int get(int index) {
        int i = 0;
        Node curr = dummyHead.next;
        while (curr != null && i++ != index) {
            curr = curr.next;
        }

        return curr == null ? -1 : curr.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = dummyHead.next;
        dummyHead.next = node;
    }

    public void addAtTail(int val) {
        Node curr = dummyHead;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = new Node(val);
    }

    public void addAtIndex(int index, int val) {
        Node curr = dummyHead;
        int i = 0;
        while (curr != null && i++ != index) {
            curr = curr.next;
        }

        if (curr == null) {
            return;
        }

        Node node = new Node(val);
        node.next = curr.next;
        curr.next = node;
    }

    public void deleteAtIndex(int index) {
        Node curr = dummyHead;
        int i = 0;
        while (curr.next != null && i++ != index) {
            curr = curr.next;
        }

        if (curr.next == null) {
            return;
        }

        curr.next = curr.next.next;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(2);
        myLinkedList.deleteAtIndex(1);

        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(3);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(5);
        myLinkedList.addAtTail(5);
        myLinkedList.get(5);
        myLinkedList.deleteAtIndex(6);
        myLinkedList.deleteAtIndex(4);

        myLinkedList.print();
    }

    private void print() {
        Node curr = dummyHead.next;
        while (curr != null) {
            System.out.print(curr.val);
            curr = curr.next;
        }

        System.out.println();
    }
}
