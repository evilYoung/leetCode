package com.fourthis4.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Comparator.reverseOrder;

/**
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/volume-of-histogram-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class VolumeOfHistogramLcci {

    int[][] index;

    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int sum = 0;
        index = new int[height.length][2];
        for (int i = 0; i < index.length; i++) {
            sum += height[i];
            index[i] = new int[]{height[i], i};
        }
        Arrays.sort(index, Collections.reverseOrder(Comparator.comparingInt(o -> o[0])));

        int[] max = index[0];

        int left = leftSub(0, height);
        int right = rightSub(0, height);
        int s = max[0] * height.length - left - right;

        return s - sum;
    }


    private int leftSub(int idx, int[] height) {
        int[] max = index[idx];

        while (idx < height.length - 1) {
            idx++;
            if (index[idx][1] < max[1]) {
                int left = leftSub(idx, height);
                return (max[0] - index[idx][0]) * max[1] + left;
            }
        }
        return 0;
    }

    private int rightSub(int idx, int[] height) {
        int[] max = index[idx];

        while (idx < height.length - 1) {
            idx++;
            if (index[idx][1] > max[1]) {
                int right = rightSub(idx, height);
                return (max[0] - index[idx][0]) * (height.length - 1 - max[1])  + right;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        VolumeOfHistogramLcci obj = new VolumeOfHistogramLcci();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(obj.trap(height));
    }
}
