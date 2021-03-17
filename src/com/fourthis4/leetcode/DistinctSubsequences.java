package com.fourthis4.leetcode;

/**
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distinct-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DistinctSubsequences {
    private int[][] cache;
    public int numDistinct(String s, String t) {
        cache = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                cache[i][j] = -1;
            }
        }

        return distinct(s, 0, t, 0);
    }


    private int distinct(String s, int sStart, String t, int tStart) {
        int r1 = 0;
        int r2 = 0;
        while (sStart < s.length() && tStart < t.length()) {
            if (s.charAt(sStart) != t.charAt(tStart)) {
                sStart++;
            } else {
                if (cache[sStart + 1][tStart] != -1) {
                    r1 = cache[sStart + 1][tStart];
                } else {
                    r1 = distinct(s, sStart + 1, t, tStart);
                    cache[sStart + 1][tStart] = r1;
                }
                if (tStart == t.length() - 1) {
                    r2 = 1;
                }else {
                    if (cache[sStart + 1][tStart + 1] != -1) {
                        r2 = cache[sStart + 1][tStart + 1];
                    } else {
                        r2 = distinct(s, sStart + 1, t, tStart + 1);
                        cache[sStart + 1][tStart + 1] = r2;
                    }
                }
                break;
            }
        }
        return r1 + r2;
    }

    public static void main(String[] args) {
        DistinctSubsequences obj = new DistinctSubsequences();

        long start = System.currentTimeMillis();
        System.out.println(obj.numDistinct("rabbbit", "rabbit"));

        long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start));
        start = end;

        System.out.println(obj.numDistinct("babgbag","bag"));
        end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start));
        start = end;

        System.out.println(obj.numDistinct("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc", "bcddceeeebecbc"));
        end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start));
        start = end;
    }
}
