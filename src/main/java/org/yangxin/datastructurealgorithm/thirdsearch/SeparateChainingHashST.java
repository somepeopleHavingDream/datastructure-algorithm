package org.yangxin.datastructurealgorithm.thirdsearch;

/**
 * 基于拉链法的散列表
 *
 * @author yangxin
 * 2020/09/03 11:31
 */
@SuppressWarnings({"unused", "RedundantSuppression"})
public class SeparateChainingHashST<Key, Value> {

    /**
     * 键值对总数
     */
    private int N;

    /**
     * 散列表的大小
     */
    private final int M;

    /**
     * 存放列表对象的数组
     */
    private final SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    @SuppressWarnings("unchecked")
    public SeparateChainingHashST(int M) {
        // 创建M条链表
        this.M = M;

        // 在创建st[]时需要进行类型转换，因为Java不允许泛型的数组。
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
    }
}