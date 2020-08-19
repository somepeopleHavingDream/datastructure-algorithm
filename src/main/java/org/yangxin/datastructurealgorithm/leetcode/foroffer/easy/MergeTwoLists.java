package org.yangxin.datastructurealgorithm.leetcode.foroffer.easy;

/**
 * 合并两个排序的链表
 *
 * @author yangxin
 * 2020/08/19 09:35
 */
public class MergeTwoLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 两条链表中存在任意一条链表为null的情况
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode p1 = l1, p2 = l2;
        ListNode head = new ListNode(-1);
        ListNode p3 = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p3.next = p1;
                p1 = p1.next;
            } else {
                p3.next = p2;
                p2 = p2.next;
            }
            p3 = p3.next;
        }

        if (p1 == null) {
            p3.next = p2;
        }
        if (p2 == null) {
            p3.next = p1;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1Node1 = new ListNode(1);
        ListNode l1Node2 = new ListNode(2);
        ListNode l1Node3 = new ListNode(4);
        l1Node1.next = l1Node2;
        l1Node2.next = l1Node3;

        ListNode l2Node1 = new ListNode(1);
        ListNode l2Node2 = new ListNode(3);
        ListNode l2Node3 = new ListNode(4);
        l2Node1.next = l2Node2;
        l2Node2.next = l2Node3;

        ListNode p = mergeTwoLists(l1Node1, l2Node1);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    /**
     * @author yangxin
     * 2020/08/19 09:37
     */
    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
