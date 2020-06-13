package org.yangxin.datastructurealgorithm.firstbasic;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yangxin
 * 2020/06/13 16:51
 */
public class UFByQuickUnion {

    /**
     * 分量id（以触点作为索引）
     */
    private final int[] id;

    /**
     * 分量数量
     */
    private int count;

    public UFByQuickUnion(int N) {
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
        // 找出分量的名称
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        // 将p和q的根节点统一
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        id[pRoot] = qRoot;
        count--;
    }

    /**
     * 解决动态连通性问题
     */
    public static void main(String[] args) {
        // 读取触点数量
        int N = 10;
        // 初始化N个分量
        UFByQuickFind ufByQuickFind = new UFByQuickFind(N);
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
            if (ufByQuickFind.connected(p, q)) {
                continue;
            }
            // 归并分量
            ufByQuickFind.union(p, q);
            // 打印连接
            System.out.println(p + " " + q);
        }
        System.out.println(ufByQuickFind.count() + " components");
    }
}
