package problems.c0easy.t1001t1500;

import java.util.Arrays;

/**
 * 1450 在既定时间做作业的学生人数 https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time/description/
 * 给你两个整数数组 startTime（开始时间）和 endTime（结束时间），
 * 并指定一个整数 queryTime 作为查询时间。
 * 已知，第 i 名学生在 startTime[i] 时开始写作业并于 endTime[i] 时完成作业。
 * 请返回在查询时间 queryTime 时正在做作业的学生人数。形式上，
 * 返回能够使 queryTime 处于区间 [startTime[i], endTime[i]]（含）的学生人数。
 *
 * 示例：
 * 输入1：startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
 * 输出1：1
 *
 * 输入2：startTime = [4], endTime = [4], queryTime = 4
 * 输出2：1
 *
 * 输入3：startTime = [4], endTime = [4], queryTime = 5
 * 输出3:0
 *
 * 输入4：startTime = [1,1,1,1], endTime = [1,3,2,4], queryTime = 7
 * 输出4：0
 *
 * 输入5：startTime = [9,8,7,6,5,4,3,2,1], endTime = [10,10,10,10,10,10,10,10,10], queryTime = 5
 * 输出5：5
 */
public class T1450 {
    /**
     * 自己实现：只要判断 startTime[i] <= queryTime <= endTime[i] 即可
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 官方解法：差分数组
     */
    public int busyStudent1(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int maxEndTime = Arrays.stream(endTime).max().getAsInt();
        if (queryTime > maxEndTime) {
            return 0;
        }
        int[] cnt = new int[maxEndTime + 2];
        for (int i = 0; i < n; i++) {
            cnt[startTime[i]]++;
            cnt[endTime[i] + 1]--;
        }
        int ans = 0;
        for (int i = 0; i <= queryTime; i++) {
            ans += cnt[i];
        }
        return ans;
    }
}
