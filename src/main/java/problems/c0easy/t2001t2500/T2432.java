package problems.c0easy.t2001t2500;

/**
 * 2432 处理用时最长的那个任务的员工 https://leetcode.cn/problems/the-employee-that-worked-on-the-longest-task/description/
 * 共有 n 位员工，每位员工都有一个从 0 到 n - 1 的唯一 id 。
 * 给你一个二维整数数组 logs ，其中 logs[i] = [idi, leaveTimei] ：
 * idi 是处理第 i 个任务的员工的 id ，且
 * leaveTimei 是员工完成第 i 个任务的时刻。所有 leaveTimei 的值都是 唯一 的。
 * 注意，第 i 个任务在第 (i - 1) 个任务结束后立即开始，且第 0 个任务从时刻 0 开始。
 * 返回处理用时最长的那个任务的员工的 id 。如果存在两个或多个员工同时满足，则返回几人中 最小 的 id 。
 *
 * 示例：
 * 输入1：n = 10, logs = [[0,3],[2,5],[0,9],[1,15]]
 * 输出1:1
 *
 * 输入2：n = 26, logs = [[1,1],[3,7],[2,12],[7,17]]
 * 输出2：3
 *
 * 输入3：n = 2, logs = [[0,10],[1,20]]
 * 输出3:0
 */
public class T2432 {
    /**
     * 自己实现：根据题意遍历一遍即可
     */
    public int hardestWorker(int n, int[][] logs) {
        int ans = logs[0][0];
        // 初始任务消耗时间
        int max = logs[0][1];

        for (int i = 1; i < logs.length; i++) {
            int cost = logs[i][1] - logs[i - 1][1];
            // 计算当前任务时间，如果更大则更新
            if (cost == max) {
                ans = Math.min(logs[i][0], ans);
            } else if (cost > max) {
                max = logs[i][1] - logs[i - 1][1];
                ans = logs[i][0];
            }
        }

        return ans;
    }
}
