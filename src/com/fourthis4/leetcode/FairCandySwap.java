package com.fourthis4.leetcode;

/**
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 *
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 *
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 *
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fair-candy-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int totalA = 0;
        for (int a : A) {
            totalA += a;
        }

        int totalB = 0;
        for (int b : B) {
            totalB += b;
        }

        int diff = totalA - totalB;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if ((A[i] - B[j]) * 2 == diff){
                    return new int[]{A[i], B[j]};
                }
            }
        }
        return new int[]{0, 0};
    }
}
