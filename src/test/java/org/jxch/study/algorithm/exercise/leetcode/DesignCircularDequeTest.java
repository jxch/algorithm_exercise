package org.jxch.study.algorithm.exercise.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * DesignCircularDeque 的测试用例。
 *
 * @author jxch
 * @see DesignCircularDeque
 * @since 1.8
 */
@Slf4j
class DesignCircularDequeTest {

    @Test
    void demo() {
        DesignCircularDeque deque = new DesignCircularDeque(3);
        boolean insertLastB1 = deque.insertLast(1);
        log.info("insertLast(1): [{}], res: {}", deque, insertLastB1);
        boolean insertLastB2 = deque.insertLast(2);
        log.info("insertLast(2): [{}], res: {}", deque, insertLastB2);
        boolean insertFrontB3 = deque.insertFront(3);
        log.info("insertFront(3): [{}], res: {}", deque, insertFrontB3);
        boolean insertFrontB4 = deque.insertFront(4);
        log.info("insertFront(4): [{}], res: {}", deque, insertFrontB4);
        int rear = deque.getRear();
        log.info("getRear(): [{}], res: {}", deque, rear);
        boolean empty = deque.isFull();
        log.info("isFull(): [{}], res: {}", deque, empty);
        boolean deleteLast = deque.deleteLast();
        log.info("deleteLast(): [{}], res: {}", deque, deleteLast);
        boolean insertFront = deque.insertFront(4);
        log.info("insertFront(4): [{}], res: {}", deque, insertFront);
        int front = deque.getFront();
        log.info("getFront(): [{}], res: {}", deque, front);
    }
}