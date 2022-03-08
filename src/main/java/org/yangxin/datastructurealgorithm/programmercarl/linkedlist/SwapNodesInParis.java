package org.yangxin.datastructurealgorithm.programmercarl.linkedlist;

/**
 * @author yangxin
 * 2022/3/7 21:59
 */
public class SwapNodesInParis {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

//        ListNode node1 = new ListNode(1);

//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        node1.next = node2;
//        node2.next = node3;

        printLinkedList(swapPairs(node1));
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

    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode prev = dummyHead;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            curr.next =  curr.next.next;
            prev.next.next = curr;

            prev = curr;
            curr = curr.next;
        }

        return dummyHead.next;
    }
}
