package com.fourthis4.leetcode;

/**
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {

        int max = 0;
        int[] count = new int[50000];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
            max = Math.max(max, count[nums[i]]);
        }
        int left = 0, right = 0;
        count = new int[50000];
        while (true) {
            count[nums[right]]++;
            if (count[nums[right]] == max) {
                right++;
                break;
            }
            right++;
        }

        int cur = max;
        while (true) {
            if (cur == max) {
                if (count[nums[left]] == max) {
                    cur--;
                } else {
                    count[nums[left]]--;
                    left++;
                }
            } else {
                if (right == nums.length){
                    break;
                }
                count[nums[right]]++;
                cur = Math.max(cur, count[nums[right]]);
                count[nums[left]]--;
                right++;
                left++;
            }
        }
        return right - left;
    }

    public static void main(String[] args) {
        DegreeOfAnArray obj = new DegreeOfAnArray();

        int[] nums1 = new int[]{1, 2, 2, 3, 1};

        System.out.println(obj.findShortestSubArray(nums1));

        int[] nums2 = new int[]{1, 2, 2, 3, 1, 4, 2};
        System.out.println(obj.findShortestSubArray(nums2));

    }
}
