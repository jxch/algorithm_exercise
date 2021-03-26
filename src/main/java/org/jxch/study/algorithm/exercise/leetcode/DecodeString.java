package org.jxch.study.algorithm.exercise.leetcode;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
 *
 * @author jxch
 * @see <a href="https://leetcode-cn.com/problems/decode-string/">力扣：394. 字符串解码</a>
 * @since 1.8
 */
public class DecodeString {

    public String decodeString(String s) {
        String regular = "\\d+\\[[a-zA-Z]+]";
        Pattern pattern = Pattern.compile(regular);

        while (Pattern.matches(".*" + regular + ".*", s)) {
            Matcher matcher = pattern.matcher(s);
            matcher.find();
            String substring = s.substring(matcher.start(), matcher.end());
            String[] split = substring.split("\\[");
            split[1] = split[1].substring(0, split[1].length() - 1);
            int number = Integer.parseInt(split[0]);
            s = s.substring(0, matcher.start()) + split[1].repeat(Math.max(0, number)) + s.substring(matcher.end());
        }

        return s;
    }

    public String decodeStringByStack(String s) {
        char[] chars = s.toCharArray();
        Stack<String> operandStack = new Stack<>();
        for (char aChar : chars) {
            if (aChar == ']') {
                StringBuilder builder = new StringBuilder();
                while (!operandStack.peek().equals("[")) {
                    builder.insert(0, operandStack.pop());
                }
                operandStack.pop();
                StringBuilder numberString = new StringBuilder();
                while (!operandStack.isEmpty() && isNumber(operandStack.peek())) {
                    numberString.insert(0, operandStack.pop());
                }
                int number = Integer.parseInt(numberString.toString());
                operandStack.push(builder.toString().repeat(number));
            } else {
                operandStack.push(String.valueOf(aChar));
            }
        }

        StringBuilder builder = new StringBuilder();
        for (String operand : operandStack) {
            builder.append(operand);
        }
        return builder.toString();
    }

    public boolean isNumber(String number) {
        return number.length() == 1 && Character.isDigit(number.charAt(0));
    }
}
