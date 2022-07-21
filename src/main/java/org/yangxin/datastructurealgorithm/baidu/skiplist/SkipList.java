package org.yangxin.datastructurealgorithm.baidu.skiplist;

import java.security.SecureRandom;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yangxin
 * 2022/7/21 20:28
 */
@SuppressWarnings({"unchecked", "unused"})
public class SkipList<E extends Comparable<? super E>> {

    /**
     * 概率因子
     */
    private static final double UP_RATE = 0.5;

    /**
     * 整个跳表的开始结点
     */
    private Node<E> head;

    /**
     * 保存查询过程中下沉点的结点
     */
    private final Deque<Node<E>> stack = new LinkedList<>();

    private final SecureRandom random = new SecureRandom();

    public SkipList() {
        head = new Node<>(null);
    }

    /**
     * 组成跳表的结点
     *
     * @param <E>
     */
    public static class Node<E extends Comparable<? super E>> {

        /**
         * 结点保存的值
         */
        public E value;

        /**
         * 结点的下结点
         */
        public Node<E> down;

        /**
         * 结点的右结点
         */
        public Node<E> right;

        public Node(E value) {
            this.value = value;
        }
    }

    /**
     * 用于查找value应该在的结点的位置，返回value的前结点
     *
     * @param value 值
     * @return 结点
     */
    private Node<E> findPredecessor(Object value) {
        stack.clear();

//        while (true) {
            for (Node<E> q = head, r = q.right, d; ;) {
                if (r != null) {
                    // 如果查找的值大于当前结点的右节点值，则继续往右查找
                    if (((Comparable<? super E>) value).compareTo(r.value) > 0) {
                        q = r;
                        r = r.right;
                        continue;
                    }
                }

                // 验证到最底层，返回最底层的结点
                if ((d = q.down) == null) {
                    return q;
                }
                stack.push(q);
                q = d;
                r = d.right;
            }
//        }
    }

    public Node<E> search(E value) {
        if (value == null) {
            throw new NullPointerException();
        }

        Node<E> preNode = findPredecessor(value);
        if (preNode.right == null) {
            // 说明跳表中最大值都小于value
            return null;
        }

        if (value.compareTo(preNode.right.value) == 0) {
            return preNode.right;
        }

        return null;
    }

    public void add(E value) {
        if (value == null) {
            throw new NullPointerException();
        }

        Node<E> preNode = findPredecessor(value);
        if (preNode.right != null && value.compareTo(preNode.right.value) == 0) {
            // 说明已经存在
            return;
        }

        // 插入链表
        Node<E> node = new Node<>(value);
        node.right = preNode.right;
        preNode.right = node;

        Node<E> up, down;
        for (;;) {
            // 对结点进行升级，根据随机数判断
            if (random.nextDouble() < UP_RATE) {
                break;
            }

            down = node;
            // 初始化上结点，并把底层结点加到上结点的down属性
            node = new Node<>(value);
            node.down = down;

            // stack存放查询的时候保存的下沉结点，如果stack为空，随机升级成功，说明跳表层级往上升一级
            if (stack.isEmpty()) {
                Node<E> newHead = new Node<>(null);
                // 旧头结点作为新结点的下级结点
                newHead.down = head;
                newHead.right = node;
                head = newHead;
                break;
            }

            // 从stack中取出下沉时的结点，也就是找到了升级结点的前结点
            up = stack.pop();
            node.right = up.right;
            up.right =  node;
        }
    }

    public void delete(E value) {
        if (value == null) {
            throw new NullPointerException();
        }

        Node<E> preNode = findPredecessor(value);
        if (preNode.right != null && value.compareTo(preNode.right.value) != 0) {
            // 当前层元素不存在
            return;
        }

        for (;;) {
            if (preNode.right == null || value.compareTo(preNode.right.value) != 0) {
                break;
            }

            // 移除结点
            preNode.right = preNode.right.right;
            if (head.right == null && head.down != null) {
                head = head.down;
            }
            if (stack.isEmpty()) {
                break;
            }
            preNode = stack.pop();
        }
    }

    /**
     * 分层打印
     */
    public void print() {
        for (Node<E> c = head;;) {
            for (Node<E> r = c.right;;) {
                if (r == null) {
                    System.out.println();
                    break;
                }

                System.out.print(r.value + ", ");
                r = r.right;
            }

            if (c.down == null) {
                break;
            }
            c = c.down;
        }
    }
}
