package com.fourthis4.leetcode;

/**
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 *
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
 *
 * 如果是，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-the-sentence-is-pangram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckIfTheSentenceIsPangram {
    public boolean checkIfPangram(String sentence) {
        int result = 0;

        for (int i = 0; i < sentence.length(); i++) {
            result = result | (1 << (sentence.charAt(i) - 'a'));
        }

        return 0b11111111111111111111111111 == result;
    }
}
