package org.yangxin.datastructurealgorithm.fourthgraph;

import java.util.Iterator;

/**
 * @author yangxin
 * 2020/10/15 14:01
 */
public class Bag<Item> implements Iterable<Item> {

    /**
     * 链表的首结点
     */
    private Node first;

    public void add(Item item) {
        // 和Stack的push()方法完全相同
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /**
     * @author yangxin
     * 2020/10/15 14:16
     */
    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {}

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * @author yangxin
     * 2020/10/15 14:13
     */
    private class Node {

        Item item;
        Node next;
    }
}
