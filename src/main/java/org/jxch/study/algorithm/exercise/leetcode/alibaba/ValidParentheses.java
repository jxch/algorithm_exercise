package org.jxch.study.algorithm.exercise.leetcode.alibaba;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 *
 * @author jxch
 * @since 1.8
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> operand = new Stack<>();
        for (char aChar : chars) {
            if (operand.isEmpty()) {
                operand.push(aChar);
            } else {
                Character peek = operand.peek();
                if ((aChar == ')' && peek == '(') ||
                        (aChar == '}' && peek == '{') ||
                        (aChar == ']' && peek == '[')) {
                    operand.pop();
                } else {
                    operand.push(aChar);
                }
            }
        }
        return operand.isEmpty();
    }
}
