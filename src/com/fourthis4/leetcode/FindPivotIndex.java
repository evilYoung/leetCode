package com.fourthis4.leetcode;

/**
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 *
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-pivot-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {

        if (nums.length == 0) {
            return -1;
        }
        int right = 0;

        for (int num : nums) {
            right += num;
        }

        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            right -= nums[i];

            if (left == right){
                return i;
            } else {
                left += nums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex obj = new FindPivotIndex();

        int[] nums = new int[]{1, 7, 3, 6, 5, 6};

        int[] nums_2 = new int[]{1};

        System.out.println(obj.pivotIndex(nums));
        System.out.println(obj.pivotIndex(nums_2));
    }
}
