package problems.c0easy.t2501t3000;

/**
 * 2798 满足目标工作时长的员工数目 https://leetcode.cn/problems/number-of-employees-who-met-the-target/description/
 * 公司里共有 n 名员工，按从 0 到 n - 1 编号。
 * 每个员工 i 已经在公司工作了 hours[i] 小时。
 * 公司要求每位员工工作 至少 target 小时。
 * 给你一个下标从 0 开始、长度为 n 的非负整数数组 hours 和一个非负整数 target 。
 * 请你用整数表示并返回工作至少 target 小时的员工数。
 *
 * 示例：
 * 输入1：hours = [0,1,2,3,4], target = 2
 * 输出1：3
 *
 * 输入2：hours = [5,1,4,2,2], target = 6
 * 输出2：0
 */
public class T2798 {
    /***
     * 自己实现：根据题意遍历即可
     */
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans = 0;
        for (int hour : hours) {
            if (hour >= target) {
                ans++;
            }
        }
        return ans;
    }
}
