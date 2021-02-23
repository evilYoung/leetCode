package com.fourthis4.leetcode;

/**
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 *
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 *
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 *
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/grumpy-bookstore-owner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int grumpyAdd = 0;
        int normal = 0;
        for (int i = 0; i < X; i++) {
            normal += customers[i] * (1 - grumpy[i]);
            grumpyAdd += customers[i] * grumpy[i];
        }
        int maxGrumpy = grumpyAdd;
        for (int i = X; i < customers.length; i++) {
            normal += customers[i] * (1 - grumpy[i]);
            grumpyAdd = grumpyAdd + (customers[i] * grumpy[i]) - (customers[i - X] * grumpy[i - X]);
            maxGrumpy = Math.max(maxGrumpy, grumpyAdd);
        }
        return normal + maxGrumpy;
    }

    public static void main(String[] args) {
        GrumpyBookstoreOwner obj = new GrumpyBookstoreOwner();

        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};

        System.out.println(obj.maxSatisfied(customers, grumpy, 3));
    }
}
