package problems.c0easy.t3501t4000;

/**
 * 3633 最早完成陆地和水上游乐设施的时间 I https://leetcode.cn/problems/earliest-finish-time-for-land-and-water-rides-i/description/
 * 给你两种类别的游乐园项目：陆地游乐设施 和 水上游乐设施。
 * 陆地游乐设施
 * landStartTime[i] – 第 i 个陆地游乐设施最早可以开始的时间。
 * landDuration[i] – 第 i 个陆地游乐设施持续的时间。
 * 水上游乐设施
 * waterStartTime[j] – 第 j 个水上游乐设施最早可以开始的时间。
 * waterDuration[j] – 第 j 个水上游乐设施持续的时间。
 * 一位游客必须从 每个 类别中体验 恰好一个 游乐设施，顺序 不限 。
 * 游乐设施可以在其开放时间开始，或 之后任意时间 开始。
 * 如果一个游乐设施在时间 t 开始，它将在时间 t + duration 结束。
 * 完成一个游乐设施后，游客可以立即乘坐另一个（如果它已经开放），或者等待它开放。
 * 返回游客完成这两个游乐设施的 最早可能时间 。
 *
 * 示例：
 * 输入1：landStartTime = [2,8], landDuration = [4,1], waterStartTime = [6], waterDuration = [3]
 * 输出1：9
 *
 * 输入2：landStartTime = [5], landDuration = [3], waterStartTime = [1], waterDuration = [10]
 * 输出2：14
 */
public class T3633 {
    /**
     * 官方解法1：根据题意模拟
     */
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int land = landStartTime[i] + landDuration[i];
                int land_water = Math.max(land, waterStartTime[j]) + waterDuration[j];
                res = Math.min(res, land_water);

                int water = waterStartTime[j] + waterDuration[j];
                int water_land = Math.max(water, landStartTime[i]) + landDuration[i];
                res = Math.min(res, water_land);
            }
        }
        return res;
    }

    /**
     * 官方解法2：线性枚举 + 分类讨论
     */
    private int solve(int[] start1, int[] duration1, int[] start2, int[] duration2) {
        int finish1 = Integer.MAX_VALUE;
        for (int i = 0; i < start1.length; i++) {
            finish1 = Math.min(finish1, start1[i] + duration1[i]);
        }
        int finish2 = Integer.MAX_VALUE;
        for (int i = 0; i < start2.length; i++) {
            finish2 = Math.min(finish2, Math.max(start2[i], finish1) + duration2[i]);
        }
        return finish2;
    }

    public int earliestFinishTime2(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int land_water = solve(landStartTime, landDuration, waterStartTime, waterDuration);
        int water_land = solve(waterStartTime, waterDuration, landStartTime, landDuration);
        return Math.min(land_water, water_land);
    }
}
