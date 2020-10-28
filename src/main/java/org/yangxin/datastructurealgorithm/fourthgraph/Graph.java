package org.yangxin.datastructurealgorithm.fourthgraph;

/**
 * 表示无向图的数据类型
 *
 * @author yangxin
 * 2020/10/15 11:36
 */
public class Graph {

    /**
     * 顶点数目
     */
    private final int V;

    /**
     * 边的数目
     */
    private int E;

    /**
     * 邻接表
     */
    private final Bag<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;

        // 创建邻接表
        adj = (Bag<Integer>[]) new Bag[V];
        // 将所有链表初始化为空
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    /**
     * 计算v的度数
     */
    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int ignored : G.adj(v)) {
            degree++;
        }
        return degree;
    }

    /**
     * 计算所有顶点的最大度数
     */
    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            if (degree(G, v) > max) {
                max = degree(G, v);
            }
        }
        return max;
    }

    /**
     * 计算所有顶点的平均度数
     */
    public static double avgDegree(Graph G) {
        return 2 * G.E() / G.V();
    }

    /**
     * 计算自环的个数
     */
    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v == w) {
                    count++;
                }
            }
        }

        // 每条边都被记过两次
        return count / 2;
    }

    /**
     * 图的连接表的字符串表示（Graph的实例方法）
     */
    public String toString() {
        StringBuilder s = new StringBuilder(V + " vertices, " + E + " edges\n");
        for (int v = 0; v < V; v++) {
            s.append(v).append(": ");
            for (int w : this.adj(v)) {
                s.append(w).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    private int E() {
        return E;
    }

    private int V() {
        return V;
    }

    private Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public void addEdge(int v, int w) {
        // 将w添加到v的链表中
        adj[v].add(w);
        // 将v添加到w的链表中
        adj[w].add(v);
        E++;
    }
}
