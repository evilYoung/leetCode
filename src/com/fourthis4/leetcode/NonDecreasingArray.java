package com.fourthis4.leetcode;

/**
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {

        int pre = Integer.MIN_VALUE;

        int needChange = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < nums[i - 1]) {

                if (needChange > 0) {
                    return false;
                }

                if (i == nums.length - 1) {
                    return true;
                }
                needChange++;

                if (nums[i] > nums[i + 1]) {
                    return false;
                }

                if (pre > nums[i] && nums[i - 1] > nums[i + 1]) {
                    return false;
                }

                if (pre > nums[i]){
                    pre = nums[i - 1];
                } else {
                    pre = nums[i];
                }

            } else {
                pre = nums[i - 1];
            }
        }

        return needChange < 2;
    }
}
