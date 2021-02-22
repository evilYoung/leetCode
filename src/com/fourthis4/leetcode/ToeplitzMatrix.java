package com.fourthis4.leetcode;

/**
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 *
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/toeplitz-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int[] pre = matrix[0];

        for (int i = 1; i < matrix.length; i++) {

            for (int j = 0; j < pre.length - 1; j++) {
                if (matrix[i][j + 1] != pre[j]) {
                    return false;
                }
            }

            pre = matrix[i];
        }
        return true;
    }
}
