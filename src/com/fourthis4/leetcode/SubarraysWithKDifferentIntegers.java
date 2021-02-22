package com.fourthis4.leetcode;

/**
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定不同的子数组为好子数组。
 *
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 *
 * 返回 A 中好子数组的数目。
 *
 *  
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarrays-with-k-different-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubarraysWithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] A, int K) {
        return subarraysWithKDistinct2(A, K) - subarraysWithKDistinct2(A, K - 1);
    }
    public int subarraysWithKDistinct2(int[] A, int K) {
        int[] showCount = new int[A.length + 1];
        int total = 0, diff = 0, left = 0, right = 0;

        while (right < A.length) {
            int cur = A[right];
            if (showCount[cur] == 0) {
                diff++;
            }
            showCount[cur]++;
            while (diff > K) {
                showCount[A[left]]--;
                if (showCount[A[left]] == 0) {
                    diff--;
                }
                total += right - left;
                left++;
            }
            right++;
        }
        total += (right - left + 1) * (right - left) / 2;
        return total;
    }
    public static void main(String[] args) {
        SubarraysWithKDifferentIntegers obj = new SubarraysWithKDifferentIntegers();

        int[] arr = new int[]{1, 2, 1, 2, 3};
        System.out.println(obj.subarraysWithKDistinct(arr, 2));

        int[] arr2 = new int[]{1, 2, 1, 3, 4};
        System.out.println(obj.subarraysWithKDistinct(arr2, 3));
    }
}
