package org.yangxin.datastructurealgorithm.programmercarl.linkedlist;

/**
 * @author yangxin
 * 2022/3/7 21:42
 */
@SuppressWarnings({"DuplicatedCode", "SameParameterValue"})
public class ReverseLinkedList {

    public static void main(String[] args) {
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        node1.next = node2;

        printLinkedList(reverseList(null));
//        printLinkedList(reverseList(node1));
    }

    private static void printLinkedList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            curr = curr.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private static ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = tmp;
        }

        return prev;
    }
}
