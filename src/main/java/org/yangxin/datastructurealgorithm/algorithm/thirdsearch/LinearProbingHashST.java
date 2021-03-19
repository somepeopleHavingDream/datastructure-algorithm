package org.yangxin.datastructurealgorithm.algorithm.thirdsearch;

import java.util.Objects;

/**
 * 基于线性探测的散列表
 *
 * @author yangxin
 * 2020/09/03 17:49
 */
public class LinearProbingHashST<Key, Value> {

    /**
     * 符号表中键值对的总数
     */
    private int N;

    /**
     * 线性探测表的大小
     */
    private int M = 16;

    /**
     * 键
     */
    private Key[] keys;

    /**
     * 值
     */
    private Value[] values;

    @SuppressWarnings("unchecked")
    public LinearProbingHashST() {
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    @SuppressWarnings("unchecked")
    public LinearProbingHashST(int cap) {
        M = cap;
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7ffffff) % M;
    }

    /**
     * 调整线性探测散列表
     */
    private void resize(int cap) {
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<>(cap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                t.put(keys[i], values[i]);
            }
        }
        keys = t.keys;
        values = t.values;
        M = t.M;
    }

    private void put(Key key, Value value) {
        // 将M加倍
        if (N >= M / 2) {
            resize(2 * M);
        }

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (Objects.equals(keys[i], key)) {
                values[i] = value;
                return;
            }
        }

        keys[i] = key;
        values[i] = value;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (Objects.equals(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }
}
