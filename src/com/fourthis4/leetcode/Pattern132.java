package com.fourthis4.leetcode;

/**
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 *
 * 注意：n 的值小于15000。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/132-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Pattern132 {
    public boolean find132pattern(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    max = Math.max(max, nums[j]);
                    if (max > nums[j]) {
                        return true;
                    }
                }
            }
            max = Integer.MIN_VALUE;
        }

        return false;
    }
}
