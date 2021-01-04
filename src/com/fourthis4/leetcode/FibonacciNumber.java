package com.fourthis4.leetcode;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FibonacciNumber {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }


        return fib(n - 1) + fib(n - 2);
    }

    public int fib_1(int n) {
        if (n < 2) {
            return n;
        }

        int a = 0, b = 1, c = 2, r = 0;

        while (c < n) {
            r = a + b;
            a = b;
            b = r;
            c++;
        }

        return r;
    }

}
