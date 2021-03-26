package org.jxch.study.algorithm.exercise.enjoy;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 中缀表达式转后缀表达式，计算后缀表达式。expression 必须用空格空开。
 *
 * @author jxch
 * @since 1.8
 */
public class PostfixExpression {

    /**
     * 中缀表达式转后缀表达式，expression 必须用空格空开
     */
    public Queue<String> convert(String expression) {
        String[] allOperands = expression.split(" ");
        Stack<String> operator = new Stack<>();
        Queue<String> postfixExpOperands = new LinkedList<>();
        for (String operand : allOperands) {
            if (isOperand(operand)) {
                postfixExpOperands.offer(operand);
            } else if (isOperator(operand)) {
                if (operand.equals("(") || operator.size() == 0) {
                    operator.push(operand);
                } else if (operand.equals(")")) {
                    while (!operator.peek().equals("(")) {
                        postfixExpOperands.offer(operator.pop());
                    }
                    operator.pop();
                } else if (operator.peek().equals("(") || priority(operand, operator.peek())) {
                    operator.push(operand);
                } else {
                    while (operator.size() > 0 && !operator.peek().equals("(") && priority(operand, operator.peek())) {
                        postfixExpOperands.offer(operator.pop());
                    }
                    operator.push(operand);
                }
            } else {
                throw new IllegalArgumentException("非法操作数：" + operand);
            }
        }

        while (operator.size() > 0) {
            postfixExpOperands.offer(operator.pop());
        }

        return postfixExpOperands;
    }

    public BigDecimal compute(@NotNull Queue<String> postfixExpOperands) {
        Stack<BigDecimal> operandStack = new Stack<>();
        while (postfixExpOperands.size() > 0) {
            String spilt = postfixExpOperands.poll();
            if (isOperand(spilt)) {
                operandStack.push(new BigDecimal(spilt));
            } else if (isOperator(spilt)) {
                BigDecimal num1 = operandStack.pop();
                BigDecimal num2 = operandStack.pop();
                switch (spilt) {
                    case "+" -> operandStack.push(num1.add(num2));
                    case "-" -> operandStack.push(num1.subtract(num2));
                    case "*" -> operandStack.push(num1.multiply(num2));
                    case "/" -> operandStack.push(num1.divide(num2, RoundingMode.HALF_UP));
                    default -> throw new IllegalArgumentException("非法操作符：" + spilt);
                }
            } else {
                throw new IllegalArgumentException("非法操作符：" + spilt);
            }
        }
        return operandStack.pop();
    }

    public BigDecimal compute(String expression) {
        return compute(convert(expression));
    }

    public boolean isOperand(String operand) {
        try {
            new BigDecimal(operand);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isOperator(String operator) {
        return operator.equals("+") || operator.equals("-")
                || operator.equals("*") || operator.equals("/")
                || operator.equals("(") || operator.equals(")");

    }

    public boolean priority(String operator, String peekOperator) {
        return (operator.equals("*") || operator.equals("/"))
                && (peekOperator.equals("+") || peekOperator.equals("-"));
    }
}
