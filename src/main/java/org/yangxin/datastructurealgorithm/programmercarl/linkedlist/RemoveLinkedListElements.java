package org.yangxin.datastructurealgorithm.programmercarl.linkedlist;

/**
 * @author yangxin
 * 2022/3/7 20:43
 */
@SuppressWarnings({"WriteOnlyObject", "SameParameterValue"})
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

//        ListNode node1 = new ListNode(7);
//        ListNode node2 = new ListNode(7);
//        ListNode node3 = new ListNode(7);
//        ListNode node4 = new ListNode(7);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;

        ListNode head = removeElements(null, 1);

        printList(head);
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode curr = dummyHead;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
                continue;
            }

            curr = curr.next;
        }

        return dummyHead.next;
    }
}
