package com.fourthis4.leetcode;

/**
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 *
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 *
 * 返回 A 的最大湍流子数组的长度。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-turbulent-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] arr) {

        int max = 0;
        int flag = 0;

        int start = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int compare = Integer.compare(arr[i], arr[i + 1]);

            if (compare == 0) {
                max = Math.max(max, i + 1 - start);
                start = i + 1;
                flag = 0;
            } else if (flag == 0 || (flag == 1 && compare == -1) || (flag == -1 && compare == 1)) {
                flag = compare;
            } else {
                max = Math.max(max, i + 1 - start);
                start = i ;
                flag = compare;
            }
        }

        return Math.max(max, arr.length - start);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9};

        int[] arr2 = new int[]{9, 9};
        LongestTurbulentSubarray obj = new LongestTurbulentSubarray();

        System.out.println(obj.maxTurbulenceSize(arr));
        System.out.println(obj.maxTurbulenceSize(arr2));
    }
}
