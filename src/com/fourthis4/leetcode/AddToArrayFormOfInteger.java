package com.fourthis4.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new LinkedList<>();
        int add = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            int t = K - (K/10)*10;
            int a = A[i];

            result.add(0, (a + t + add) % 10);
            add = (a + t + add) / 10;
            K = K / 10;
        }

        while (K > 0 || add != 0) {
            int t = K - (K / 10) * 10;
            result.add(0, (t + add) % 10);
            add = (t + add) / 10;
            K = K / 10;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,1,5};
        int b = 806;

        AddToArrayFormOfInteger obj = new AddToArrayFormOfInteger();


        obj.addToArrayForm(a, b).forEach(System.out::println);
    }
}
