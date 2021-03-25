package org.jxch.study.algorithm.exercise.enjoy;

import lombok.extern.slf4j.Slf4j;

/**
 * 三个线程，一个打印A，一个打印B，一个打印C。按顺序打印ABC四次。
 *
 * @author jxch
 * @since 1.8
 */
@Slf4j
public class ABCThreads {
    private volatile char flag = 'Z';

    public void print(char printFlag, char condition) {
        for (int i = 0; i < 4; i++) {
            synchronized (this) {
                boolean isPrint = false;
                while (!isPrint) {
                    if (this.flag == 'Z' || condition == this.flag) {
                        log.info(String.valueOf(printFlag));
                        isPrint = true;
                    } else if (condition != this.flag) {
                        try {
                            wait();
                            if (condition == this.flag) {
                                log.info(String.valueOf(printFlag));
                                isPrint = true;
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                this.flag = printFlag;
                notifyAll();
            }
        }
    }

    public void start() {
        new Thread(() -> print('A', 'C'), "A").start();
        new Thread(() -> print('B', 'A'), "B").start();
        new Thread(() -> print('C', 'B'), "C").start();
    }
}
