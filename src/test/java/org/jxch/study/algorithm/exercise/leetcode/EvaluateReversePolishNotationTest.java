package org.jxch.study.algorithm.exercise.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * EvaluateReversePolishNotation 的测试用例
 *
 * @author jxch
 * @see EvaluateReversePolishNotation
 * @since 1.8
 */
@Slf4j
class EvaluateReversePolishNotationTest {

    @Test
    void evalRPN() {
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        int rpn = evaluateReversePolishNotation.evalRPN(new String[]{"4", "13", "5", "/", "+"});
        log.info(String.valueOf(rpn));
    }
}