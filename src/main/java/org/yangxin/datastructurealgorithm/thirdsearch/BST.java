package org.yangxin.datastructurealgorithm.thirdsearch;

/**
 * 基于二叉查找树的符号表
 *
 * @author yangxin
 * 2020/07/22 14:08
 */
public class BST<Key extends Comparable<Key>, Value> {

    /**
     * 二叉查找树的根节点
     */
    private Node root;

    /**
     * @author yangxin
     * 2020/07/22 14:09
     */
    private class Node {

        /**
         * 键
         */
        private Key key;

        /**
         * 值
         */
        private Value value;

        /**
         * 指向子树的链接
         */
        private Node left, right;

        /**
         * 以该结点为根的子树中的结点总数
         */
        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }

        public int size() {
            return size(root);
        }

        private int size(Node x) {
            return x == null ? 0 : x.N;
        }

        public Value get(Key key) {
            return get(root, key);
        }

        private Value get(Node x, Key key) {
            // 在以x为根节点的子树中查找并返回key所对应的值
            // 如果找不到则返回null
            if (x == null) {
                return null;
            }

            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                return get(x.left, key);
            } else if (cmp > 0) {
                return get(x.right, key);
            } else {
                return x.value;
            }
        }

        public void put(Key key, Value value) {
            // 查找key，找到则更新它的值，否则为它创建一个新的结点
            root = put(root, key, value);
        }

        private Node put(Node x, Key key, Value value) {
            // 如果key存在于以x为根节点的子树中则更新它的值
            // 否则将以key和value为键值对的新结点插入到该子树中
            if (x == null) {
                return new Node(key, value, 1);
            }

            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x.left = put(x.left, key, value);
            } else if (cmp > 0) {
                x.right = put(x.right, key, value);
            } else {
                x.value = value;
            }

            x.N = size(x.left) + size(x.right) + 1;

            return x;
        }

        public Key min() {
            return min(root).key;
        }

        private Node min(Node x) {
            return x.left == null ? x : min(x.left);
        }

        public Key max() {
            return max(root).key;
        }

        private Node max(Node x) {
            return x.right == null ? x : max(x.right);
        }

        public Key floor(Key key) {
            Node x = floor(root, key);
            if (x == null) {
                return null;
            }

            return x.key;
        }

        private Node floor(Node x, Key key) {
            if (x == null) {
                return null;
            }

            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return x;
            }
            if (cmp < 0) {
                return floor(x.left, key);
            }

            Node t = floor(x.right, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }

        public Key select(int k) {
            return select(root, k).key;
        }

        private Node select(Node x, int k) {
            // 返回排名为k的结点
            if (x == null) {
                return null;
            }

            int t = size(x.left);
            if (t > k) {
                return select(x.left, k);
            } else if (t < k) {
                return select(x.right, k - t - 1);
            } else {
                return x;
            }
        }

        public int rank(Key key) {
            return rank(key, root);
        }

        private int rank(Key key, Node x) {
            // 返回以x为根节点的子树中小于x.key的键的数量
            if (x == null) {
                return 0;
            }

            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                return rank(key, x.left);
            } else if (cmp > 0) {
                return 1 + size(x.left) + rank(key, x.right);
            } else {
                return size(x.left);
            }
        }
    }
}
