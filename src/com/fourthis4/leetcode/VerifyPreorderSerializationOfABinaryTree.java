package com.fourthis4.leetcode;

/**
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 *
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 *
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 *
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        String[] item = preorder.split(",");

        int cur = 0;
        int i = 0;

        while (cur >= 0 && i < item.length) {
            if (!"#".equals(item[i])) {
                cur++;
            } else {
                cur--;
            }
            i++;
        }

        return cur == -1 && i == item.length;
    }

    public boolean isValidSerialization2(String preorder) {
        int cur = 0;
        int i = 0;

        while (cur > -2 && i < preorder.length()) {
            if (',' == preorder.charAt(i)) {
                cur++;
            } else if ('#' == preorder.charAt(i)) {
                cur = cur - 2;
            }
            i++;
        }

        return cur == -2 && i == preorder.length();
    }

    public static void main(String[] args) {
        VerifyPreorderSerializationOfABinaryTree obj = new VerifyPreorderSerializationOfABinaryTree();

        System.out.println(obj.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));

        System.out.println(obj.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
