package org.yangxin.datastructurealgorithm.thirdsearch;

/**
 * 红黑树的一种等价的定义
 * 红链接均为左链接
 * 没有任何一个结点同时和两条红链接相连
 * 该树是完美黑色平衡的，即任意空链接到根节点的路径上的黑链接数量相同
 *
 * @author yangxin
 * 2020/07/24 11:53
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    /**
     * @author yangxin
     * 2020/07/24 11:54
     */
    private class Node {

        /**
         * 键
         */
        Key key;

        /**
         * 相关联的值
         */
        Value value;

        /**
         * 左右子树
         */
        Node left, right;

        /**
         * 这课子树中的结点总数
         */
        int N;

        /**
         * 由其父结点指向它的链接的颜色
         */
        boolean color;

        Node(Key key, Value value, int N, boolean color) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }

        return x.color == RED;
    }

    /**
     * 左旋转，它对应的方法接受一条指向红黑树中的某个结点的链接作为参数。
     * 假设被指向的结点的右链接是红色的，这个方法会对树进行必要的调整并返回一个指向包含同一组键的子树并且其左链接为红色的根节点的链接
     */
    Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private int size(Node x) {
        return x == null ? 0 : x.N;
    }
}
