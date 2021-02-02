package com.fourthis4.leetcode;

/**
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意：字符串长度 和 k 不会超过 104。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        char[] c = s.toCharArray();
        int[] a = new int[26];

        int left = 0;

        int max = 0;

        for (int i = 0; i < c.length; i++) {
            a[c[i] - 'A']++;
            max = Math.max(max, a[c[i] - 'A']);
            if (i - left + 1 - max > k) {
                a[c[left] - 'A']--;
                left++;
            }
        }

        return c.length - left;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();

        System.out.println(obj.characterReplacement("AABA", 0));
    }
}
