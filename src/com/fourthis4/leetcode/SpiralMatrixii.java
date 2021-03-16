package com.fourthis4.leetcode;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralMatrixii {
    public int[][] generateMatrix(int n) {
        int[][] array = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] matrix = new int[n][n];

        int left = 0, right = matrix[0].length - 1, top = 1, bottom = matrix.length - 1;

        int size = n * n;
        int round = 0;
        int[] cur = new int[]{0, -1};

        int i = 0;
        while (i < size) {

            cur[0] = cur[0] + array[round % 4][0];
            cur[1] = cur[1] + array[round % 4][1];

            if (round % 4 == 0 && right <= cur[1]) {
                //右边界
                right--;
                round++;
            } else if (round % 4 == 1 && bottom <= cur[0]) {
                //下边界
                bottom--;
                round++;
            } else if (round % 4 == 2 && left >= cur[1]) {
                //左边界
                left++;
                round++;
            } else if (round % 4 == 3 && top >= cur[0]) {
                //上边界
                top++;
                round++;
            }
            matrix[cur[0]][cur[1]] = i + 1;
            i++;
        }

        return matrix;
    }
}
