package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

/**
 * @author yangxin
 * 2022/2/9 20:31
 */
@SuppressWarnings("DuplicatedCode")
public class AddTwoNumbers {

    public static void main(String[] args) {
//        ListNode l1n1 = new ListNode(2);
//        ListNode l1n2 = new ListNode(4);
//        ListNode l1n3 = new ListNode(3);
//        l1n1.next = l1n2;
//        l1n2.next = l1n3;
//
//        ListNode l2n1 = new ListNode(5);
//        ListNode l2n2 = new ListNode(6);
//        ListNode l2n3 = new ListNode(4);
//        l2n1.next = l2n2;
//        l2n2.next = l2n3;


//        ListNode l1n1 = new ListNode(0);
//        ListNode l2n1 = new ListNode(0);


        ListNode l1n1 = new ListNode(9);
        ListNode l1n2 = new ListNode(9);
        ListNode l1n3 = new ListNode(9);
        ListNode l1n4 = new ListNode(9);
        ListNode l1n5 = new ListNode(9);
        ListNode l1n6 = new ListNode(9);
        ListNode l1n7 = new ListNode(9);
        l1n1.next = l1n2;
        l1n2.next = l1n3;
        l1n3.next = l1n4;
        l1n4.next = l1n5;
        l1n5.next = l1n6;
        l1n6.next = l1n7;

        ListNode l2n1 = new ListNode(9);
        ListNode l2n2 = new ListNode(9);
        ListNode l2n3 = new ListNode(9);
        ListNode l2n4 = new ListNode(9);
        l2n1.next = l2n2;
        l2n2.next = l2n3;
        l2n3.next = l2n4;

        ListNode listNode = addTwoNumbers(l1n1, l2n1);
        printList(listNode);
    }

    private static void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode cursor = head;

        while (l1 != null || l2 != null || carry != 0) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int val = v1 + v2 + carry;

            carry = val / 10;
            ListNode listNode = new ListNode(val % 10);
            cursor.next = listNode;
            cursor = listNode;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return head.next;
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
}
