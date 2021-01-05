package com.fourthis4.leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class ReverseInteger {

    public int reverse(int x) {

        char[] c = String.valueOf(x).toCharArray();

        int start = 0;
        //判断符号
        if (c[0] == '-') {
            start = 1;
        }

        //去掉尾部0
        char[] b = new char[0];;
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] == '0') {
                continue;
            }
            b = new char[i + 1];
            System.arraycopy(c, 0, b, 0, i + 1);
            break;
        }

        //反转
        for (int i = 0; i < b.length/2; i++) {
            char tmp = b[i + start];
            b[i + start] = b[b.length - 1 - i];
            b[b.length - 1 - i] = tmp;
        }

        String s = String.valueOf(b);

        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        ReverseInteger obj = new ReverseInteger();

        obj.reverse(123);
    }

}
