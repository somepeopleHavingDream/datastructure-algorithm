package org.yangxin.datastructurealgorithm.programmercarl.linkedlist;

/**
 * @author yangxin
 * 2022/3/8 21:59
 */
public class IntersectionOfTwoLinkedListsLcci {

    public static void main(String[] args) {
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 分别统计每条链表的长度
        int lengthA = 0;
        ListNode currA = headA;
        while (currA != null) {
            lengthA++;
            currA = currA.next;
        }

        int lengthB = 0;
        ListNode currB = headB;
        while (currB != null) {
            lengthB++;
            currB = currB.next;
        }

        // 始终让headA指向较长的那个链表
        if (lengthA < lengthB) {
            ListNode tmp = headA;
            headA = headB;
            headB = tmp;
        }

        int step = Math.abs(lengthA - lengthB);

        currA = headA;
        currB = headB;
        for (int i = 0; i < step; i++) {
            currA = currA.next;
        }

        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }

        return currA;
    }
}
