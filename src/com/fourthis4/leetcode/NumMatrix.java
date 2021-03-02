package com.fourthis4.leetcode;

/**
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 *
 *
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 *  
 *
 * 示例：
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumMatrix {
    private int[][] arr;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            arr = new int[1][1];
            return;
        }
        arr = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int preCol = j == 0 ? 0 : arr[i][j - 1];
                int preRow = i == 0 ? 0 : arr[i - 1][j];
                int pre = (i == 0 || j == 0) ? 0 : arr[i - 1][j - 1];
                arr[i][j] = matrix[i][j] + preCol + preRow - pre;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int pre = (row1 == 0 || col1 == 0) ? 0 : this.arr[row1 - 1][col1 - 1];
        int preCol = (col1 == 0) ? 0 : this.arr[row2][col1 - 1];
        int preRow = (row1 == 0) ? 0 : this.arr[row1 - 1][col2];

        return this.arr[row2][col2] - preCol - preRow + pre;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{-4, -5}};

        NumMatrix obj = new NumMatrix(matrix);

//        System.out.println(obj.sumRegion(0, 0, 0, 0));

//        System.out.println(obj.sumRegion(0, 0, 0, 1));

        System.out.println(obj.sumRegion(0, 1, 0, 1));
    }
}
