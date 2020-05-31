package com.java.algorithm;

import java.util.Stack;

/**
 * 算法P80，Dijkstra双栈求算数表达是的值
 *
 * @program: algorithm
 * @author: liumq
 * @create: 2020-05-31 13:26
 **/
public class Evaluate {

    public static void main(String[] args) {
        Double aDouble = evaluateNum("(1+((2+3)*(4*5)))");
        System.out.println(aDouble);
    }


    public static Double evaluateNum(String str) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String s = String.valueOf(chars[i]);
            if (s.equals("(")) ;
            else if (s.equals("+")) {
                ops.push(s);
            } else if (s.equals("-")) {
                ops.push(s);
            } else if (s.equals("*")) {
                ops.push(s);
            } else if (s.equals("/")) {
                ops.push(s);
            } else if (s.equals("sqrt")) {
                ops.push(s);
            } else if (s.equals(")")) {
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) {
                    v = vals.pop() + v;
                }
                if (op.equals("-")) {
                    v = vals.pop() - v;
                }
                if (op.equals("*")) {
                    v = vals.pop() * v;
                }
                if (op.equals("/")) {
                    v = vals.pop() / v;
                }
                if (op.equals("sqrt")) {
                    v = Math.sqrt(v);
                }
                vals.push(v);
            } else {
                vals.push(Double.parseDouble(s));
            }
        }
        return vals.pop();
    }
}
