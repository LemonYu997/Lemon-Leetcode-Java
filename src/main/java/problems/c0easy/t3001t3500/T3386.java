package problems.c0easy.t3001t3500;

/**
 * 3386 按下时间最长的按钮 https://leetcode.cn/problems/button-with-longest-push-time/description/
 * 给你一个二维数组 events，表示孩子在键盘上按下一系列按钮触发的按钮事件。
 * 每个 events[i] = [indexi, timei] 表示在时间 timei 时，按下了下标为 indexi 的按钮。
 * 数组按照 time 的递增顺序排序。
 * 按下一个按钮所需的时间是连续两次按钮按下的时间差。按下第一个按钮所需的时间就是其时间戳。
 * 返回按下时间 最长 的按钮的 index。如果有多个按钮的按下时间相同，则返回 index 最小的按钮。
 *
 * 示例：
 * 输入1：events = [[1,2],[2,5],[3,9],[1,15]]
 * 输出1：1
 *
 * 输入2：events = [[10,5],[1,7]]
 * 输出2：10
 */
public class T3386 {
    /**
     * 自己实现：根据题意模拟即可
     */
    public int buttonWithLongestTime(int[][] events) {
        int max = events[0][1];
        int ans = events[0][0];
        int n = events.length;

        for (int i = 1; i < n; i++) {
            int[] p = events[i - 1];
            int[] q = events[i];
            int d = q[1] - p[1];
            if (d > max || d == max && q[0] < ans) {
                ans = q[0];
                max = d;
            }
        }
        return ans;
    }
}
