package com.fourthis4.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个类似 Lisp 语句的表达式 expression，求出其计算结果。
 *
 * 表达式语法如下所示:
 *
 * 表达式可以为整数，let 语法，add 语法，mult 语法，或赋值的变量。表达式的结果总是一个整数。
 * (整数可以是正整数、负整数、0)
 * let 语法表示为 (let v1 e1 v2 e2 ... vn en expr), 其中 let语法总是以字符串 "let"来表示，接下来会跟随一个或多个交替变量或表达式，也就是说，第一个变量 v1被分配为表达式 e1 的值，第二个变量 v2 被分配为表达式 e2 的值，以此类推；最终 let 语法的值为 expr表达式的值。
 * add 语法表示为 (add e1 e2)，其中 add 语法总是以字符串 "add"来表示，该语法总是有两个表达式e1、e2, 该语法的最终结果是 e1 表达式的值与 e2 表达式的值之和。
 * mult 语法表示为 (mult e1 e2) ，其中 mult 语法总是以字符串"mult"表示， 该语法总是有两个表达式 e1、e2，该语法的最终结果是 e1 表达式的值与 e2 表达式的值之积。
 * 在该题目中，变量的命名以小写字符开始，之后跟随0个或多个小写字符或数字。为了方便，"add"，"let"，"mult"会被定义为"关键字"，不会在表达式的变量命名中出现。
 * 最后，要说一下作用域的概念。计算变量名所对应的表达式时，在计算上下文中，首先检查最内层作用域（按括号计），然后按顺序依次检查外部作用域。我们将保证每一个测试的表达式都是合法的。有关作用域的更多详细信息，请参阅示例。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/parse-lisp-expression
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ParseLispExpression {

    char space = ' ';
    char left = '(';
    char right = ')';

    public int evaluate(String expression) {

        return evaluate(new HashMap<>(), expression);

    }



    private int mult(Map<String,Integer> value, String value1, String value2){

        return cal(value,value1) * cal(value,value2);
    }

    private int add(Map<String,Integer> value,String value1, String value2){

        return cal(value,value1) + cal(value,value2);
    }

    private int let(Map<String,Integer> value, List<String> str){
        Map<String,Integer> map;
        if(value == null){
            map = new HashMap<>();
        } else {
            map = new HashMap<>(value);
        }
        int size = str.size() / 2;
        for (int i = 0; i < size; i++){
            map.put(str.get(i * 2), cal(map,str.get(i * 2 + 1)));
        }

        return cal(map,str.get(str.size() - 1));
    }

    private int cal(Map<String,Integer> value, String str){

        if(!isEl(str)){
            if (value.containsKey(str)) {
                return value.get(str);
            } else {
                return Integer.parseInt(str);
            }
        } else {
            return evaluate(value,str);
        }
    }

    private int evaluate(Map<String,Integer> value, String str){
        String expr = str.substring(1, str.length() - 1);

        //解析操作数
        int pos = 0;
        while(expr.charAt(pos) != space){
            pos++;
        }
        String opt = expr.substring(0,pos);

        pos++;
        List<String> params = new ArrayList<>();
        while(pos<expr.length()){
            int tmpLeft = pos;
            if(expr.charAt(pos) == left){
                //表达式
                int count = 1;
                while(count !=0){
                    pos++;
                    if (expr.charAt(pos) == left){
                        count++;
                    } else if (expr.charAt(pos) == right){
                        count--;
                    }
                }
                pos++;
                params.add(expr.substring(tmpLeft,pos));
                pos++;
            } else {
                //变量
                while(pos<expr.length() && expr.charAt(pos) != space){
                    pos++;
                }
                params.add(expr.substring(tmpLeft,pos));
                pos++;
            }
        }

        switch (opt){
            case "let": return let(value, params);
            case "mult": return mult(value, params.get(0),params.get(1));
            case "add": return add(value, params.get(0),params.get(1));
            default : return 0;
        }
    }
    private boolean isEl(String str){
        return str.startsWith("(") && str.endsWith(")");
    }

    public static void main(String[] args) {
        ParseLispExpression obj = new ParseLispExpression();

        obj.evaluate("(let x 2 (add (let x 3 (let x 4 x)) x))");
    }
}
