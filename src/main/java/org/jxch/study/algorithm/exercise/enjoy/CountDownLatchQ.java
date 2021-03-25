package org.jxch.study.algorithm.exercise.enjoy;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 一个线程执行到第五条的时候，另一个线程退出。
 *
 * @author jxch
 * @since 1.8
 */
@Slf4j
public class CountDownLatchQ {
    public void demo() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread t1 = new Thread(() -> {
            log.info("t1 进入");
            try {
                for (int i = 1; i <= 10; i++) {
                    // 模拟业务执行，耗时 1s
                    TimeUnit.SECONDS.sleep(1);
                    log.info("t1 执行第 {} 条", i);
                    if (i == 5) {
                        countDownLatch.countDown();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            try {
                log.info("t2 进入");
                countDownLatch.await();
                log.info("t2 退出");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
