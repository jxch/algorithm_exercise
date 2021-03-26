package org.jxch.study.algorithm.exercise.enjoy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PostfixExpression 的测试用例。
 *
 * @author jxch
 * @see PostfixExpression
 * @since 1.8
 */
@Slf4j
class PostfixExpressionTest {

    @Test
    void compute() {
        PostfixExpression postfixExpression = new PostfixExpression();
        log.info(postfixExpression.compute("( 1 + 1.1 ) * 8").toString());
    }
}