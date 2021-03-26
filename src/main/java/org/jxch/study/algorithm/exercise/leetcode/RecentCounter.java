package org.jxch.study.algorithm.exercise.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请你实现 RecentCounter 类：
 * <p>
 * RecentCounter() 初始化计数器，请求数为 0 。
 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 * 保证 每次对 ping 的调用都使用比之前更大的 t 值。
 *
 * @author jxch
 * @see <a href="https://leetcode-cn.com/problems/number-of-recent-calls/">力扣：933. 最近的请求次数</a>
 * @since 1.8
 */
public class RecentCounter {
    private final Queue<Integer> pingQueue;

    public RecentCounter() {
        pingQueue = new LinkedList<>();
    }

    public int ping(int t) {
        int start = t - 3000;
        pingQueue.offer(t);
        while (pingQueue.size()>0) {
            if (pingQueue.peek() < start) {
                pingQueue.poll();
            } else {
                break;
            }
        }
        return pingQueue.size();
    }
}
