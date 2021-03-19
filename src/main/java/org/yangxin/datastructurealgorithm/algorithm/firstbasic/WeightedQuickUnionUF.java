package org.yangxin.datastructurealgorithm.algorithm.firstbasic;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * union-find算法的实现（加权quick-union算法）
 *
 * @author yangxin
 * 2020/06/15 16:20
 */
public class WeightedQuickUnionUF {

    /**
     * 父链接数组（由触点索引）
     */
    private final int[] id;

    /**
     * （由触点索引的）各个根节点所对应的分量的大小
     */
    private int[] sz;

    /**
     * 联通分量的数量
     */
    private int count;

    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) {
        // 跟随链接找到根节点
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }

        // 将小树的根节点连接到大树的根节点
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    /**
     * 解决动态连通性问题
     */
    public static void main(String[] args) {
        // 读取触点数量
        int N = 10;
        // 初始化N个分量
        WeightedQuickUnionUF weightedQuickUnionUF = new WeightedQuickUnionUF(N);
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(4, 3);
        map.put(3, 8);
        map.put(6, 5);
        map.put(9, 4);
        map.put(2, 1);
        map.put(5, 0);
        map.put(7, 2);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 读取整数对
            Integer p = entry.getKey();
            Integer q = entry.getValue();

            // 如果已经联通则忽略
            if (weightedQuickUnionUF.connected(p, q)) {
                continue;
            }
            // 归并分量
            weightedQuickUnionUF.union(p, q);
            // 打印连接
            System.out.println(p + " " + q);
        }
        System.out.println(weightedQuickUnionUF.count() + " components");
    }
}
