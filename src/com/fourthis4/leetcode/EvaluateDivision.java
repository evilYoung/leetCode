package com.fourthis4.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 *
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 *
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 *
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-division
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //先转化
        Map<String, Integer> map = new HashMap<>();
        Integer cur = 0;
        for (int i = 0; i < equations.size(); i++) {
            List<String> tmp = equations.get(i);
            if (!map.containsKey(tmp.get(0))) {
                map.put(tmp.get(0), cur);
                cur++;
            }
            if (!map.containsKey(tmp.get(1))) {
                map.put(tmp.get(1), cur);
                cur++;
            }
        }

        int[] union = new int[cur];
        double[] weight = new double[cur];
        for (int i = 0; i < union.length; i++) {
            union[i] = i;
            weight[i] = 1;
        }

        for (int i = 0; i < equations.size(); i++) {
            int a = map.get(equations.get(i).get(0));
            int b = map.get(equations.get(i).get(1));

            union(union, weight, a, b, values[i]);
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            if (!map.containsKey(queries.get(i).get(0)) || !map.containsKey(queries.get(i).get(1))) {
                result[i] = -1D;
            } else {
                double[] a = find(union, weight, map.get(queries.get(i).get(0)));
                double[] b = find(union, weight, map.get(queries.get(i).get(1)));
                if (a[0] == b[0]) {
                    result[i] = a[1] / b[1];
                } else {
                    result[i] = -1D;
                }
            }
        }

        return result;
    }


    private double[] find(int[] union, double[] weight, int i) {
        if (union[i] != i) {
            double[] tmp = find(union, weight, union[i]);
            tmp[1] = tmp[1] * weight[i];
            return tmp;
        }
        return new double[]{i, weight[i]};
    }

    private void union(int[] union, double[] weight, int i, int j, double w) {

        double[] iRoot = find(union, weight, i);
        double[] jRoot = find(union, weight, j);

        union[(int) iRoot[0]] = (int) jRoot[0];
        weight[(int) iRoot[0]] = w * jRoot[1] / iRoot[1];
    }
}
