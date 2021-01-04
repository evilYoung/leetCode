package com.fourthis4.leetcode;

/**
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 */
public class BitwiseAndOfNumbersRange {
    /**
     * 0 -> 0000
     * 1 -> 0001
     * 2 -> 0010
     * 3 -> 0011
     * 4 -> 0100
     * 5 -> 0101
     * 6 -> 0110
     * 7 -> 0111
     * 8 -> 1000
     * 9 -> 1001
     * 10 -> 1010
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n = n & (n - 1);
        }
        return n;
    }
    public static void main(String[] args) {
        BitwiseAndOfNumbersRange obj = new BitwiseAndOfNumbersRange();

        System.out.println(obj.rangeBitwiseAnd(5, 7));

        System.out.println(obj.rangeBitwiseAnd(0, 1));

        System.out.println(obj.rangeBitwiseAnd(1, 3));
    }
}
