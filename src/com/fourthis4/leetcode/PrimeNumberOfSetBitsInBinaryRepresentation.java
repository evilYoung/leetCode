package com.fourthis4.leetcode;

/**
 * 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
 *
 * （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
        //2,3,5,7,11,13,17,19
        int result = 0;
        for (int i = L; i <= R; i++) {
            int count = 0;
            int t = i;
            while (t > 0) {
                count += (t & 1);
                t = t >> 1;
            }

            if (count == 2 || count == 3 || count == 5 || count == 7 || count == 11
                    || count == 13 || count == 17 || count == 19) {
                result++;
            }
        }return result;
    }

    public int countPrimeSetBits2(int L, int R) {
        int mask=0b00100000100010100010100010101100;
        int count=0;
        while(L<=R){
            count+= (mask>> Integer.bitCount(L) & 1);
            L++;
        }
        return count;
    }

    public static void main(String[] args) {
        PrimeNumberOfSetBitsInBinaryRepresentation obj = new PrimeNumberOfSetBitsInBinaryRepresentation();

        System.out.println(obj.countPrimeSetBits(1, 10000) == obj.countPrimeSetBits2(1, 10000));

    }
}
