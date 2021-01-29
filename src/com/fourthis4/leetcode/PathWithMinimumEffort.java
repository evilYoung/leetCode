package com.fourthis4.leetcode;

import java.util.Arrays;

/**
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 *
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 *
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-with-minimum-effort
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathWithMinimumEffort {

    private static final int[][] directions = {{0,1},{-1,0},{0,-1},{1,0}};

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] maxDiff = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(maxDiff[i], Integer.MAX_VALUE);
        }

        int[][] point = new int[1][2];
        point[0] = new int[]{0, 0};
        maxDiff[0][0] = 0;
        int size = 1;

        while (size != 0) {
            int[][] tmpPoint = new int[size * 3][2];
            int tmp = 0;
            for (int i = 0; i < size; i++) {
                int[] xy = point[i];
                for (int j = 0; j < directions.length; j++) {
                    if (isIn(xy, directions[j], rows, cols)
                            && maxDiff[xy[0] + directions[j][0]][xy[1] + directions[j][1]] > maxDiff[xy[0]][xy[1]]) {

                        maxDiff[xy[0] + directions[j][0]][xy[1] + directions[j][1]]
                                = Math.min(Math.max(Math.abs(heights[xy[0] + directions[j][0]][xy[1] + directions[j][1]] - heights[xy[0]][xy[1]]),
                                maxDiff[xy[0]][xy[1]]),maxDiff[xy[0] + directions[j][0]][xy[1] + directions[j][1]]);

                        tmpPoint[tmp] = new int[]{xy[0] + directions[j][0], xy[1] + directions[j][1]};
                        tmp++;
                    }
                }
            }

            size = tmp;
            point = tmpPoint;
        }

        return maxDiff[rows - 1][cols - 1];
    }

    private boolean isIn(int[] xy, int[] direction, int maxRow, int maxCol) {
        return xy[0] + direction[0] >= 0
                && xy[0] + direction[0] < maxRow
                && xy[1] + direction[1] >= 0
                && xy[1] + direction[1] < maxCol;
    }

    public static void main(String[] args) {
        int[][] h = new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};

        int[][] h2 = new int[][]{{1, 10, 6, 7, 9, 10, 4, 9}};
        //[[8,6,8,1,4,1],
        // [10,3,1,8,9,10],
        // [1,5,6,9,8,5],
        // [10,4,6,7,3,3],
        // [6,6,9,1,3,3],
        // [3,1,10,3,4,1],
        // [6,1,6,10,7,10]]

        int[][] h3 = new int[][]{{8, 6, 8, 1, 4, 1}, {10, 3, 1, 8, 9, 10}, {1, 5, 6, 9, 8, 5}, {10, 4, 6, 7, 3, 3},
                {6, 6, 9, 1, 3, 3}, {3, 1, 10, 3, 4, 1}, {6, 1, 6, 10, 7, 10}};
        PathWithMinimumEffort obj = new PathWithMinimumEffort();

        System.out.println(obj.minimumEffortPath(h3));
    }
}
