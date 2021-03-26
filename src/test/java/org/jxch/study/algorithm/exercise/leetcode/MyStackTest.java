package org.jxch.study.algorithm.exercise.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * MyStack 的测试用例
 *
 * @author jxch
 * @see MyStack
 * @since 1.8
 */
@Slf4j
class MyStackTest {

    @Test
    public void demo() {
        MyStack myStack = new MyStack();
        log.info("stack: {}", myStack);
        myStack.push(1);
        log.info("push(1), stack: {}", myStack);
        myStack.push(2);
        log.info("push(2), stack: {}", myStack);
        myStack.push(3);
        log.info("push(3), stack: {}", myStack);
        int pop = myStack.pop();
        log.info("pop: {}, stack: {}", pop, myStack);
        int top = myStack.top();
        log.info("top: {}, stack: {}", top, myStack);
    }
}