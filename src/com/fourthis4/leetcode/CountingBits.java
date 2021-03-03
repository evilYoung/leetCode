package com.fourthis4.leetcode;

import java.util.Arrays;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountingBits {
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[1];
        }
        int[] result = new int[num + 1];
        result[1] = 1;
        int power = 0;

        for (int i = 2; i < num + 1; i++) {
            if (i >= (1 << (power+1))){
                power++;
            }
            result[i] = 1 + result[i - (1 << power)];
        }
        return result;
    }

    public static void main(String[] args) {
        CountingBits obj = new CountingBits();

        System.out.println(Arrays.toString(obj.countBits(5)));

    }
}
