package com.fourthis4.leetcode;

/**
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 *
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *
 * 注意，您的结果中 不应 包含任何括号。
 *
 *  
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseSubstringsBetweenEachPairOfParentheses {
    public String reverseParentheses(String s) {
        int bracketsCount = 0;
        int[] bracketStack = new int[s.length() / 3 + 1];
        int point = 0;
        int[] bracketMap = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                bracketStack[point++] = i;
                bracketsCount++;
            } else if (')' == s.charAt(i)) {
                bracketsCount++;
                bracketMap[i] = bracketStack[point - 1];
                bracketMap[bracketStack[--point]] = i;
            }
        }

        char[] c = new char[s.length() - bracketsCount];
        int cur = 0;
        int arrow = 1;

        while (point < s.length()) {
            if ('(' == s.charAt(point) || ')' == s.charAt(point)){
                arrow = -arrow;
                point = bracketMap[point];
            } else {
                c[cur++] = s.charAt(point);
            }
            point += arrow;
        }

        return new String(c);
    }

}
