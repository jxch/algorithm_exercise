package org.jxch.study.algorithm.exercise.enjoy;

import lombok.extern.slf4j.Slf4j;

/**
 * 保护性暂停模式：
 * 一个线程等待其他线程设置response后，它才能拿到response。
 *
 * @author jxch
 * @since 1.8
 */
@Slf4j
public class GuardedObject<T> {
    private T response;

    public T getResponse() {
        while (response == null) {
            try {
                synchronized (this) {
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

        return response;
    }

    public T getResponse(long millis) {
        long base = System.currentTimeMillis();
        long delay = millis, timePassed;

        while (Thread.currentThread().isAlive() &&
                delay > 0 && response == null) {
            try {
                synchronized (this) {
                    wait(delay);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            timePassed = System.currentTimeMillis() - base;
            delay = millis - timePassed;
        }

        return response;
    }

    public synchronized void setResponse(T response) {
        this.response = response;
        notifyAll();
    }
}
