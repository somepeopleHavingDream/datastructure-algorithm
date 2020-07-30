package org.yangxin.datastructurealgorithm.leetcode.foroffer.easy;

/**
 * 删除链表的节点
 *
 * @author yangxin
 * 2020/07/30 16:44
 */
public class DeleteNode {

    @SuppressWarnings("ConstantConditions")
    public static ListNode deleteNode(ListNode head, int val) {
        // 判断头结点是否为null
        if (head == null) {
            return null;
        }

        // 如果待删除结点是头结点
        if (head.val == val) {
            return head.next;
        }

        // 找到待删除结点的前一个结点，进行删除操作
        ListNode p = head;
        while (p.next != null && p.next.val != val) {
            p = p.next;
        }
        // 此时p指向待删除结点的前驱结点
        p.next = p.next.next;

        return head;
    }

    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {
        ListNode node1 = new ListNode(-3);
//        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(-99);
//        ListNode node3 = new ListNode(1);
//        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;

        ListNode p = deleteNode(node1, -3);
//        ListNode p = deleteNode(node1, 1);
//        ListNode p = deleteNode(node1, 5);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    /**
     * @author yangxin
     * 2020/07/30 16:47
     */
    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}


