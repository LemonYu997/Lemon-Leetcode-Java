package problems.c0easy.t3501t4000;

/**
 * 3683 完成一个任务的最早时间 https://leetcode.cn/problems/earliest-time-to-finish-one-task/description/
 * 给你一个二维整数数组 tasks，其中 tasks[i] = [si, ti]。
 * 数组中的每个 [si, ti] 表示一个任务，该任务的开始时间为 si，完成该任务需要 ti 个时间单位。
 * 返回至少完成一个任务的最早时间。
 *
 * 示例：
 * 输入1：tasks = [[1,6],[2,3]]
 * 输出1：5
 *
 * 输入2：tasks = [[100,100],[100,100],[100,100]]
 * 输出2：200
 */
public class T3683 {
    /**
     * 自己实现：找到和最小的即可
     */
    public int earliestTime(int[][] tasks) {
        int ans = Integer.MAX_VALUE;

        for (int[] task : tasks) {
            ans = Math.min(ans, task[0] + task[1]);
        }

        return ans;
    }
}
