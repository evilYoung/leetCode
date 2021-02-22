package com.fourthis4.leetcode;

/**
 * 在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。
 *
 * 返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumNumberOfKConsecutiveBitFlips {
    public int minKBitFlips(int[] A, int K) {
        int count = 0;
        int[] diff = new int[A.length + 1];
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            total += diff[i];

            if ((A[i] + total) % 2 == 0) {
                count++;

                if (A.length - i < K) {
                    return -1;
                }
                total++;
                diff[i + K]--;
            }
        }
        return count;
    }
}
