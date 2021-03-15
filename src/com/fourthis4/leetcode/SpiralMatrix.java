package com.fourthis4.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] array = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int left = 0, right = matrix[0].length - 1, top = 1, bottom = matrix.length - 1;

        int round = 0;
        int[] cur = new int[]{0, -1};
        int size = matrix.length * matrix[0].length;

        List<Integer> result = new ArrayList<>();
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

            result.add(matrix[cur[0]][cur[1]]);
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix3 = new int[][]{{3}, {2}};
        SpiralMatrix obj = new SpiralMatrix();

        System.out.println(obj.spiralOrder(matrix));

        System.out.println(obj.spiralOrder(matrix2));

        System.out.println(obj.spiralOrder(matrix3));

    }
}
