package com.fourthis4.leetcode;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] showCount = new int[26];

        char[] s1c = s1.toCharArray();
        for (int i = 0; i < s1c.length; i++) {
            showCount[s1c[i] - 'a']++;
        }

        char[] s2c = s2.toCharArray();

        int count = 0;

        for (int i = 0; i < s2c.length; i++) {
            if (showCount[s2c[i] - 'a'] == 0 && count > 0) {

                while (count > 0) {
                    if (s2c[i] == s2c[i - count]) {
                        break;
                    } else {
                        showCount[s2c[i - count] - 'a']++;
                    }
                    count--;
                }

            } else if (showCount[s2c[i] - 'a'] > 0) {
                count++;
                showCount[s2c[i] - 'a']--;
                if ( count == s1.length()) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        PermutationInString obj = new PermutationInString();

        System.out.println(obj.checkInclusion("ab", "eidboaoo"));
        System.out.println(obj.checkInclusion("adc", "dcda"));
    }
}
