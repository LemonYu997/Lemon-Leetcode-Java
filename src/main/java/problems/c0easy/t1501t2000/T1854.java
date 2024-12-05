package problems.c0easy.t1501t2000;

/**
 * 1854 人口最多的年份 https://leetcode.cn/problems/maximum-population-year/description/
 * 给你一个二维整数数组 logs ，其中每个 logs[i] = [birthi, deathi] 表示第 i 个人的出生和死亡年份。
 * 年份 x 的 人口 定义为这一年期间活着的人的数目。第 i 个人被计入年份 x 的人口需要满足：
 * x 在闭区间 [birthi, deathi - 1] 内。注意，人不应当计入他们死亡当年的人口中。
 * 返回 人口最多 且 最早 的年份。
 *
 * 示例：
 * 输入1：logs = [[1993,1999],[2000,2010]]
 * 输出1：1993
 *
 * 输入2：logs = [[1950,1961],[1960,1971],[1970,1981]]
 * 输出2：1960
 *
 * 1 <= logs.length <= 100
 * 1950 <= birthi < deathi <= 2050
 */
public class T1854 {
    /**
     * 官方解法：差分数组
     * 遍历每个人的出生与死亡年份，维护每一年的如人口变化量
     */
    public int maximumPopulation(int[][] logs) {
        // 根据题意：1950 <= birthi < deathi <= 2050，因此只需要维护长度为 102 的数组即可
        int offset = 1950;  // 起始年份是 1950（偏移量）
        int[] peopleDelta = new int[102];
        // 统计每一年的如人口变化量，这里只统计发生变化时的年份数据
        for (int i = 0; i < logs.length; i++) {
            // 出生时数量 + 1，死亡时数量 - 1
            peopleDelta[logs[i][0] - offset]++;
            peopleDelta[logs[i][1] - offset]--;
        }

        // 找到人口最多的年份
        int peopleCount = 0;
        int maxCount = 0;
        int whichYear = 0;

        // 遍历每一年
        for (int i = 0; i < peopleDelta.length; i++) {
            // 当前人口数
            peopleCount += peopleDelta[i];
            if (peopleCount > maxCount) {
                maxCount = peopleCount;
                whichYear = i + offset;
            }
        }

        return whichYear;
    }
}
