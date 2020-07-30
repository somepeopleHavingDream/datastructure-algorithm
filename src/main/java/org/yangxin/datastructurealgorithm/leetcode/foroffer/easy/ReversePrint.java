package org.yangxin.datastructurealgorithm.leetcode.foroffer.easy;

import java.util.Arrays;

/**
 * 从头到尾打印链表
 *
 * @author yangxin
 * 2020/07/24 10:12
 */
public class ReversePrint {

    public static int[] reversePrint(ListNode head) {
        // 先知道链表有多长
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }

        // 构建一个相对链表逆序的等长度数组
        p = head;
        int[] result = new int[length];
        for (int i = result.length - 1; i >= 0 && p != null; i--) {
            result[i] = p.val;
            p = p.next;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        System.out.println(Arrays.toString(reversePrint(node1)));
    }

    /**
     * @author yangxin
     * 2020/07/24 10:13
     */
    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}


