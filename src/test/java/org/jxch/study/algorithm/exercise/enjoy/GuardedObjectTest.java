package org.jxch.study.algorithm.exercise.enjoy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author jxch
 * @since 1.8
 * @see GuardedObject
 */
@Slf4j
class GuardedObjectTest {
    public static final GuardedObject<Integer> guardedObject = new GuardedObject<>();
    @Test
    void demo() {
        Thread getterThread = new Thread(()-> {
            log.info("getter started");
            log.info("get response: {}", guardedObject.getResponse());
            log.info("getter end");
        },"getter");
        Thread getterWithTimeThread = new Thread(()-> {
            log.info("getter-time started");
            log.info("get-time response: {}", guardedObject.getResponse(2000));
            log.info("getter-time end");
        },"getter-time");
        Thread setterThread = new Thread(()->{
            log.info("setter started");
            guardedObject.setResponse(100);
            log.info("setter end");
        },"setter");

        getterWithTimeThread.start();
        getterThread.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setterThread.start();

        try {
            setterThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}