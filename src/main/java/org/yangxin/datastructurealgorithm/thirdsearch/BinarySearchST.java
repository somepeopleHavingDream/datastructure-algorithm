package org.yangxin.datastructurealgorithm.thirdsearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二分查找（基于有序数组）
 *
 * @author yangxin
 * 2020/07/03 09:10
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private final Key[] keys;
    private final Value[] values;
    private int N;

    public BinarySearchST(int capacity) {
        // 调整数组大小的标准代码
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }

        int i = rank(key);
//        if (i < N && keys[i].compareTo(key) == 0) {
//            return values[i];
//        } else {
//            return null;
//        }
        return i < N && keys[i].compareTo(key) == 0 ? values[i] : null;
    }

    /**
     * 非递归的二分查找
     */
    private int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return lo;
    }

    /**
     * 递归的二分查找
     */
    public int rank(Key key, int lo, int hi) {
        if (hi < lo) {
            return lo;
        }

        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0) {
            return rank(key, lo, mid - 1);
        } else if (cmp > 0) {
            return rank(key, mid + 1, hi);
        } else {
            return mid;
        }
    }

    public void put(Key key, Value value) {
        // 查找键，找到时更新键，否则创建新的元素
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }

        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public void delete(Key key) {

    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }

    public Key select(int k) {
        return keys[k];
    }

    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    public Key floor(Key key) {
        return null;
    }

//    public Iterable<Key> keys(Key lo, Key hi) {
//        Queue<Key> queue = new LinkedList<>();
//        for (int i = rank(lo); i < rank(hi); i++) {
//            queue.add(keys[i]);
//        }
//
//        if (contains)
//    }

    private boolean isEmpty() {
        return size() == 0;
    }
}
