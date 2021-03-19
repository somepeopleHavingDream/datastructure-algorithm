package org.yangxin.datastructurealgorithm.algorithm.thirdsearch;

/**
 * 顺序查找（基于无序链表）
 *
 * @author yangxin
 * 2020/06/23 09:40
 */
public class SequentialSearchST<Key, Value> {

    /**
     * 链表首结点
     */
    private Node first;

    /**
     * 链表结点的定义
     *
     * @author yangxin
     * 2020/06/23 09:42
     */
    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {
        // 查找给定的键，返回相关联的值
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                // 命中
                return x.val;
            }
        }
        // 未命中
        return null;
    }

    public void put(Key key, Value val) {
        // 查找给定的键，找到则更新其值，否则在表中新建结点
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                // 命中，更新
                x.val = val;
                return;
            }
        }
        // 未命中，新建结点
        first = new Node(key, val, first);
    }
}
