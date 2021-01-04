package com.fourthis4.leetcode;

import java.util.Arrays;

public class Q53 {

    public int count;

    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }


    private void perm(int[] num, int start, int len) {

        if (start == len - 1) {
            int[] slot = new int[2 * len];

            int shift = 0;
            for (int i = 0; i < num.length; i++) {
                int slotPoint = i + shift;
                if (slot[slotPoint] > 0){
                    shift++;
                    i--;
                    continue;
                }
                if (slotPoint + num[i] + 1 >= slot.length || slot[slotPoint + num[i] + 1] > 1) {
                    return;
                } else {
//                    slot[slotPoint] = num[i];
//                    if (slotPoint > 0) {
//                        if (slot[slotPoint - 1] - slot[slotPoint] == 1
//                                && (slotPoint -1 - num[i - 1] - 1 >= 0)
//                                && slot[slotPoint -1 - num[i - 1] - 1] != slot[slotPoint - 1]) {
//                            return;
//                        }
//                    }
                    slot[slotPoint + num[i] + 1] = num[i];
                }
            }
            System.out.println(Arrays.toString(slot));
            count++;
        } else {

            for (int i = start; i < len; i++) {

                swap(num, start, i);

                perm(num, start + 1, len);

                swap(num, start, i);
            }
        }
    }

    public void print(int[] num) {
        perm(num, 0, num.length);
    }
    public static void main(String[] args) {
        int n = 11;

        int[] num = new int[n];

        for (int i = 0; i < num.length; i++) {
            num[i] = i + 1;
        }

        Q53 q53 = new Q53();

        q53.print(num);

        System.out.println(q53.count);
    }
}
