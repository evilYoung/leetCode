package com.fourthis4.leetcode;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        int cur = 0;
        char[] chars = new char[S.length()];

        for (int i = 0; i < S.length(); i++) {
            if (cur == 0) {
                chars[cur] = S.charAt(i);
                cur++;
            } else {
                if (chars[cur - 1] == S.charAt(i)) {
                    cur--;
                } else {
                    chars[cur] = S.charAt(i);
                    cur++;
                }
            }
        }

        return new String(chars, 0, cur);
    }

    public static void main(String[] args) {
        String str = "abbaca";
        RemoveAllAdjacentDuplicatesInString obj = new RemoveAllAdjacentDuplicatesInString();

        obj.removeDuplicates(str);
    }
}
