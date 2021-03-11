package com.fourthis4.leetcode;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 *
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 *
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BasicCalculatorii {
    public int calculate(String s) {
        int a = 0, b = 0;

        int[] t = next(s, 0);
        b = t[0];

        int i = t[1];
        while (i < s.length()) {
            if (' ' == s.charAt(i)) {
                i++;
                continue;
            } else if ('-' == s.charAt(i) || '+' == s.charAt(i)) {
                a = a + b;
                t = next(s, i + 1);
                if ('-' == s.charAt(i)) {
                    b = -t[0];
                } else {
                    b = t[0];
                }
                i = t[1];
            } else {
                t = next(s, i + 1);
                if ('*' == s.charAt(i)) {
                    b = b * t[0];
                } else {
                    b = b / t[0];
                }
                i = t[1];
            }
        }
        return a + b;
    }

    private int[] next(String s, int i) {
        int tmp = 0;
        for (int j = i; j < s.length(); j++) {
            if (' ' == s.charAt(j)) {
                continue;
            } else if ('-' == s.charAt(j) || '+' == s.charAt(j)
                    || '*' == s.charAt(j) || '/' == s.charAt(j)){
                return new int[]{tmp, j};
            } else {
                tmp = tmp * 10 + (s.charAt(j) - '0');
            }
        }
        return new int[]{tmp, s.length()};
    }

    public static void main(String[] args) {
        BasicCalculatorii obj = new BasicCalculatorii();

        System.out.println(obj.calculate(" 3+5 / 2 "));
    }
}
