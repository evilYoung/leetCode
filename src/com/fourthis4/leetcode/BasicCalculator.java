package com.fourthis4.leetcode;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BasicCalculator {

    int cur = 0;

    public int calculate(String s) {
        int result = 0;
        int tmp = 0;
        int[] op = new int[s.length()];
        op[0] = 1;
        int opCur = 0;
        int opLast = 1;

        for (int i = 0; i < s.length(); i++) {
            if (' ' == s.charAt(i)) {
                continue;
            } else if ('-' == s.charAt(i) || '+' == s.charAt(i)) {
                result = result + (tmp * op[opCur] * opLast);

                if ('-' == s.charAt(i)) {
                    opLast = -1;
                } else {
                    opLast = 1;
                }
                tmp = 0;
            } else if ('(' == s.charAt(i)) {
                opCur++;
                op[opCur] = op[opCur - 1] * opLast;
                opLast = 1;
            } else if (')' == s.charAt(i)) {
                result = result + (tmp * op[opCur] * opLast);
                tmp = 0;
                opCur--;
            } else {
                tmp = tmp * 10 + (s.charAt(i) - '0');
            }
        }
        result = result + (tmp * op[opCur] * opLast);
        return result;
    }

    public Node parse(String s) {
        int tmp = 0;
        Node left = null;
        Node right = null;
        Node op = null;
        while (cur < s.length()) {
            //先解析左
            if (' ' == s.charAt(cur)) {
                cur++;
                continue;
            } else if ('(' == s.charAt(cur)) {
                cur++;
                if (op == null) {
                    left = parse(s);
                } else {
                    right = parse(s);
                }
            } else if ('+' == s.charAt(cur) || '-' == s.charAt(cur)) {
                cur++;
                if (op != null) {
                    op.left = left;
                    right = new Node();
                    right.num = tmp;
                    tmp = 0;
                    op.right = right;

                    left = op;
                    right = parse(s);
                    op = new Node();
                    if ('+' == s.charAt(cur-1)) {
                        op.op = 1;
                    } else {
                        op.op = -1;
                    }
                    op.left = left;
                    op.right = right;
                } else {
                    op = new Node();
                    if ('+' == s.charAt(cur-1)) {
                        op.op = 1;
                    } else {
                        op.op = -1;
                    }

                    left = new Node();
                    left.num = tmp;
                    tmp = 0;
                    op.left = left;
                }

            } else if (')' == s.charAt(cur)) {
                cur++;
                op = new Node();
                op.num = tmp;
                return op;
            } else {
                int curNum = s.charAt(cur) - '0';
                tmp = tmp * 10 + curNum;
                cur++;
            }
        }
        if (op == null) {
            op = new Node();
            op.num = tmp;
        }
        return op;
    }
    class Node {
        Node left;
        Node right;
        int num;
        int op = 0;
    }

    public void modify(int i) {
        i++;
    }

    public static void main(String[] args) {
        BasicCalculator obj = new BasicCalculator();

//        Node node = obj.parse("(1+2+(4+ 45+2)-3)+ (6+8)");

        System.out.println(obj.calculate("(1+2-(4+ 45+2)-3)+ (6+8)-1"));

    }

}
