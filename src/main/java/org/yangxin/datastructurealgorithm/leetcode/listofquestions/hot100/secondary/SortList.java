package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

/**
 * @author yangxin
 * 2022/2/20 16:07
 */
public class SortList {

    public static void main(String[] args) {
//        ListNode node1 = new ListNode(4);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(1);
//        ListNode node4 = new ListNode(3);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;

        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode head = sortList(node1);
        printList(head);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
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

    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head, q = head, pre = null;
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }

        pre.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(p);
        return mergeSort(left, right);
    }

    private static ListNode mergeSort(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = new ListNode(left.val);
                left = left.next;
            } else {
                cur.next = new ListNode(right.val);
                right = right.next;
            }
            cur = cur.next;
        }

        if (left != null) {
            cur.next = left;
        }
        if (right != null) {
            cur.next = right;
        }

        return dummyHead.next;
    }
}
