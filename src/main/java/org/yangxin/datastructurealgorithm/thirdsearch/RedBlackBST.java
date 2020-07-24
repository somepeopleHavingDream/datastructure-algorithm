package org.yangxin.datastructurealgorithm.thirdsearch;

/**
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
}
