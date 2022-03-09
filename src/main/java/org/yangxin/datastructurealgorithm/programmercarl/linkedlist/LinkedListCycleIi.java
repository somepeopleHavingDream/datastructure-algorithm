package org.yangxin.datastructurealgorithm.programmercarl.linkedlist;

import java.util.Optional;

/**
 * @author yangxin
 * 2022/3/8 22:21
 */
public class LinkedListCycleIi {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        node1.next = node2;
//        node2.next = node1;

//        ListNode node1 = new ListNode(1);

//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        node1.next = node2;

        printListNode(detectCycle(node1));
    }

    private static void printListNode(ListNode node) {
        System.out.println(node == null ? null : node.val);
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private static ListNode detectCycle(ListNode head) {
        // 先找到相遇结点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // 再用两个指针分别从头结点和相遇结点触发，再次相遇的结点即为环形入口结点
                ListNode a = head;
                ListNode b = fast;
                while (a != b) {
                    a = a.next;
                    b = b.next;
                }

                return a;
            }
        }

        return null;
    }
}
