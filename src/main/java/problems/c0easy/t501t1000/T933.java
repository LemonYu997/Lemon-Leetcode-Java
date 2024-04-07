package problems.c0easy.t501t1000;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 933 最近的请求次数 https://leetcode.cn/problems/number-of-recent-calls/
 * 写一个 RecentCounter 类来计算特定时间范围内最近的请求。
 * RecentCounter() 初始化计数器，请求数为 0 。
 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，
 * 并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。
 * 确切地说，返回在 [t-3000, t] 内发生的请求数。
 *
 * 示例：
 * 输入1：["RecentCounter", "ping", "ping", "ping", "ping"]
 * [[], [1], [100], [3001], [3002]]
 * 输出1：[null, 1, 2, 3, 3]
 */
public class T933 {
    /**
     * 官方解法：使用队列
     */
    class RecentCounter {
        Queue<Integer> queue;

        public RecentCounter() {
            queue = new ArrayDeque<>();
        }

        public int ping(int t) {
            queue.offer(t);
            while (queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }
}
