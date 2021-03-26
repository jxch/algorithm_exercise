package org.jxch.study.algorithm.exercise.leetcode;

import java.util.Stack;

/**
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * @author jxch
 * @see <a href="https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/">力扣：150. 逆波兰表达式求值</a>
 * @since 1.8
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                Integer num1 = operands.pop();
                Integer num2 = operands.pop();
                switch (token) {
                    case "+" -> operands.push(num2 + num1);
                    case "-" -> operands.push(num2 - num1);
                    case "*" -> operands.push(num2 * num1);
                    case "/" -> operands.push(num2 / num1);
                }
            } else {
                operands.push(Integer.parseInt(token));
            }
        }
        return operands.pop();
    }

    public boolean isOperator(String operator) {
        return operator.equals("+") || operator.equals("-")
                || operator.equals("*") || operator.equals("/");

    }
}
