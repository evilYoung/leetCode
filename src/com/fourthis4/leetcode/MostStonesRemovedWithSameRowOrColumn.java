package com.fourthis4.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
 *
 * 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
 *
 * 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MostStonesRemovedWithSameRowOrColumn {
    private static final int size = 10001;

    public int removeStones(int[][] stones) {

        int set = 0;
        int[] union = new int[2 * size];
        int[] exists = new int[2 * size];
        for (int i = 0; i < union.length; i++) {
            union[i] = i;
        }

        for (int i = 0; i < stones.length; i++) {
            int[] xy = stones[i];
            int xSet = xy[0];
            int ySet = xy[1] + size;

            if (exists[xy[0]] == 0 && exists[xy[1] + size] == 0){
                //这个坐标的 x,y 值第一次出现
                set++;
            }else if (exists[xy[0]] == 1 && exists[xy[1] + size] == 1){
                //都遍历过了,如果分属于不同set则说明这是个链接点
                xSet = find(union, xSet);
                ySet = find(union, ySet);

                if (xSet != ySet){
                    set--;
                }
            }

            exists[xy[0]] = 1;
            exists[xy[1] + size] = 1;

            union(union, xSet, ySet);
        }

        return stones.length - set;
    }

    private int find(int[] union, int i) {
        if (union[i] != i) {
            return find(union, union[i]);
        }

        return i;
    }


    private void union(int[] union, int i, int j) {
        int iRoot = find(union, i);
        int jRoot = find(union, j);

        union[iRoot] = jRoot;
    }

    public static void main(String[] args) {
        MostStonesRemovedWithSameRowOrColumn obj = new MostStonesRemovedWithSameRowOrColumn();
        int[][] stones = new int[][]{{0, 1}, {1, 1}};
        obj.removeStones(stones);
    }
}
