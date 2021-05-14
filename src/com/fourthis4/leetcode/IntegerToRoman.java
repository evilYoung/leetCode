package com.fourthis4.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        Map<Integer, String> map = map();

        int mod = 1000;
        String result = "";
        while (mod > 0) {
            int c = num / mod;
            if (c > 0) {
                c = c * mod;
                result = result + map.get(c);
                num = num - c;
            }
            mod = mod / 10;
        }

        return result;
    }


    private Map<Integer,String> map(){
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "I");
        result.put(2, "II");
        result.put(3, "III");
        result.put(4, "IV");
        result.put(5, "V");
        result.put(6, "VI");
        result.put(7, "VII");
        result.put(8, "VIII");
        result.put(9, "IX");
        result.put(10, "X");
        result.put(20, "XX");
        result.put(30, "XXX");
        result.put(40, "XL");
        result.put(50, "L");
        result.put(60, "LX");
        result.put(70, "LXX");
        result.put(80, "LXXX");
        result.put(90, "XC");
        result.put(100, "C");
        result.put(200, "CC");
        result.put(300, "CCC");
        result.put(400, "CD");
        result.put(500, "D");
        result.put(600, "DC");
        result.put(700, "DCC");
        result.put(800, "DCCC");
        result.put(900, "CM");
        result.put(1000, "M");
        result.put(2000, "MM");
        result.put(3000, "MMM");

        return result;
    }

    public static void main(String[] args) {
        IntegerToRoman obj = new IntegerToRoman();

        obj.intToRoman(3);
    }
}
