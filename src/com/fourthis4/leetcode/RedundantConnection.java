package com.fourthis4.leetcode;

/**
 * 在本问题中, 树指的是一个连通且无环的无向图。
 *
 * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 *
 * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
 *
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/redundant-connection
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int[] t = new int[edges.length + 1];

        for (int i = 0; i < t.length; i++) {
            t[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int rootS = find(edges[i][0], t);
            int rootE = find(edges[i][1], t);

            if (rootS == rootE) {
                return edges[i];
            } else {
                t[rootS] = edges[i][1];
            }
        }

        return edges[edges.length - 1];
    }

    private int find(int i, int[] t) {
        if (t[i] != i ) {
            return find(t[i], t);
        }
        return i;
    }
}
