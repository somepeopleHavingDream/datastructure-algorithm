package org.yangxin.datastructurealgorithm.leetcode.listofquestions.foroffer.easy;

/**
 * 链表中倒数第k个节点
 *
 * @author yangxin
 * 2020/08/05 17:43
 */
public class GetKthFromEnd {

    public static ListNode getKthFromEnd(ListNode head, int k) {
        // 计算出链表有多长
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }

        int step = length - k;
        p = head;
        for (int i = 0; i < step; i++) {
            p = p.next;
        }

        return p;
    }

    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode from = getKthFromEnd(node1, 2);
        while (from != null) {
            System.out.println(from.val);
            from = from.next;
        }
    }

    /**
     * @author yangxin
     * 2020/08/05 17:43
     */
    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
