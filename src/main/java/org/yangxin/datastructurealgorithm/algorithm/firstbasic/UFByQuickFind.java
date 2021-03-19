package org.yangxin.datastructurealgorithm.algorithm.firstbasic;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * union-find的实现
 * 当程序从输入中读取了整数对pq时，如果已知的所有整数对都不能说明p和q是相连的，那么则将这一对整数写入到输出中。
 * 如果已知的数据可以说明p和q是相连的，那么程序应该忽略pq这对整数并继续处理输入中的下一对整数。
 *
 * @author yangxin
 * 2020/06/12 16:34
 */
public class UFByQuickFind {

    /**
     * 分量id（以触点作为索引）
     */
    private final int[] id;

    /**
     * 分量数量
     */
    private int count;

    public UFByQuickFind(int N) {
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

    /**
     * quick-find算法
     */
    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        // 将p和q归并到相同的分量中
        int pID = find(p);
        int qID = find(q);

        // 如果p和q已经在相同的分量之中则不需要采取任何行动
        if (pID == qID) {
            return;
        }

        // 将p的分量重命名为q的名称
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
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
        UFByQuickFind ufByQuickFind = new UFByQuickFind(N);
        Map<Integer, Integer> map = new LinkedHashMap<>();
//        Map<Integer, Integer> map = new HashMap<>();
        map.put(4, 3);
        map.put(3, 8);
        map.put(6, 5);
        map.put(9, 4);
        map.put(2, 1);
        map.put(5, 0);
        map.put(7, 2);
//        map.put(6, 1);

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
