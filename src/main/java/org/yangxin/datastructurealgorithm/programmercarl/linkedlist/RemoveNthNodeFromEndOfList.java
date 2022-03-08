package org.yangxin.datastructurealgorithm.programmercarl.linkedlist;

/**
 * @author yangxin
 * 2022/3/8 21:37
 */
@SuppressWarnings({"DuplicatedCode", "UnnecessaryLocalVariable", "SameParameterValue"})
public class RemoveNthNodeFromEndOfList {

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

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;

        printLinkedList(removeNthFromEnd(node1, 1));
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

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        // 先让快指针走n+1步
        ListNode slow = dummyHead, fast = dummyHead;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        // 快指针慢指针同时走
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // 此时慢指针指向待删除结点的前一个结点
        slow.next = slow.next.next;

        return dummyHead.next;
    }
}
