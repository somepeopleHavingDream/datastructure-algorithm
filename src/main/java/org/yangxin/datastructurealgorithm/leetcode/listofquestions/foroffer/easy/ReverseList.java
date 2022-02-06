package org.yangxin.datastructurealgorithm.leetcode.listofquestions.foroffer.easy;

/**
 * 反转链表
 *
 * @author yangxin
 * 2020/08/05 17:50
 */
public class ReverseList {

    public static ListNode reverseList(ListNode head) {
        ListNode suc = head, pre = null;
        while (suc != null) {
            ListNode tmp = suc;
            suc = suc.next;

            tmp.next = pre;
            pre = tmp;
        }

        return pre;
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

        ListNode from = reverseList(node1);
        while (from != null) {
            System.out.println(from.val);
            from = from.next;
        }
    }

    /**
     * @author yangxin
     * 2020/08/05 17:50
     */
    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
