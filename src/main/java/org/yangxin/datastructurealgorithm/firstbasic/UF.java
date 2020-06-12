package org.yangxin.datastructurealgorithm.firstbasic;

/**
 * union-find的实现
 *
 * @author yangxin
 * 2020/06/12 16:34
 */
public class UF {

    /**
     * 分量id（以触点作为索引）
     */
    private int[] id;

    /**
     * 分量数量
     */
    private int count;

    public UF(int N) {
        // 初始化分量id数组
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return  0;
    }

    public void union(int p, int q) {

    }

    public static void main(String[] args) {

    }
}
