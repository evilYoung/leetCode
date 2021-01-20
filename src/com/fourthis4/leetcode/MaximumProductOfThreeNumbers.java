package com.fourthis4.leetcode;

/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 */
public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (min1 > nums[i]) {
                min2 = min1;
                min1 = nums[i];
            } else if (min2 > nums[i]) {
                min2 = nums[i];
            }

            if (max3 < nums[i]) {
                max1 = max2;
                max2 = max3;
                max3 = nums[i];
            } else if (max2 < nums[i]) {
                max1 = max2;
                max2 = nums[i];
            } else if (max1 < nums[i]) {
                max1 = nums[i];
            }
        }

        return Math.max(max1 * max2 * max3, min1 * min2 * max3);
    }

    public static void main(String[] args) {
        MaximumProductOfThreeNumbers obj = new MaximumProductOfThreeNumbers();

        obj.maximumProduct(new int[]{-100,-98,-1,2,3,4});
    }
}
