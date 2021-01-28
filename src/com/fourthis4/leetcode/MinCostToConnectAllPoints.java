package com.fourthis4.leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 *
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 *
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-to-connect-all-points
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {

        Edge[] edges = new Edge[(points.length * (points.length - 1)) / 2];

        int point = 0;
        for (int i = 0; i < points.length; i++) {

            for (int j = i + 1; j < points.length; j++) {
                edges[point] = new Edge(i, j, dist(points[i], points[j]));
                point++;
            }
        }

        List<Edge> list = Stream.of(edges)
                .sorted(Comparator.comparingInt(Edge::getDist))
                .collect(Collectors.toList());

        int[] union = new int[points.length];
        for (int i = 0; i < union.length; i++) {
            union[i] = i;
        }

        int result = 0;
        for (Edge e : list) {
            if (find(union,e.getA()) != find(union,e.getB())){
                result += e.getDist();
                union(union, e.getA(), e.getB());
            }
        }

        return result;
    }

    private int find(int[] union, int i) {
        if (union[i] != i) {
            return find(union, union[i]);
        }

        return i;
    }

    private void union(int[] union, int a, int b) {
        int aRoot = find(union, a);
        int bRoot = find(union, b);
        union[bRoot] = aRoot;
    }

    private class Edge{

        private int a,b,dist;

        public Edge(int a, int b, int dist) {
            this.a = a;
            this.b = b;
            this.dist = dist;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public int getDist() {
            return dist;
        }
    }
    private int dist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public static void main(String[] args) {
        //[[0,0],[2,2],[3,10],[5,2],[7,0]]

        MinCostToConnectAllPoints obj = new MinCostToConnectAllPoints();

        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(obj.minCostConnectPoints(points));
    }
}
