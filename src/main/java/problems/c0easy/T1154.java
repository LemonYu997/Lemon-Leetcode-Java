package problems.c0easy;

import java.util.Calendar;

/**
 * 1154 一年中的第几天 https://leetcode.cn/problems/day-of-the-year/description/
 * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。返回该日期是当年的第几天。
 *
 * 示例：
 * 输入1：date = "2019-01-09"
 * 输出1:9
 *
 * 输入2：date = "2019-02-10"
 * 输出2：41
 */
public class T1154 {
    /**
     * 官方解法：模拟推算
     */
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));

        int[] amount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            // 闰年2月多一天
            amount[1]++;
        }

        int ans = 0;
        for (int i = 0; i < month - 1; i++) {
            ans += amount[i];
        }
        return ans + day;
    }
}
