package problems.c0easy;

import java.time.LocalDate;
import java.util.Locale;

/**
 * 1185 一周中的第几天 https://leetcode.cn/problems/day-of-the-week/description/
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday",
 * "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 *
 * 示例：
 * 输入1：day = 31, month = 8, year = 2019
 * 输出1："Saturday"
 *
 * 输入2：day = 18, month = 7, year = 1999
 * 输出2："Sunday"
 *
 * 输入3：day = 15, month = 8, year = 1993
 * 输出3："Sunday"
 */
public class T1185 {
    /**
     * 自己实现：使用 LocalDate
     */
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        String ans = date.getDayOfWeek().toString();
        // 首字母大写，其余小写
        return ans.substring(0, 1) + ans.substring(1).toLowerCase();
    }

    /**
     * 官方解法：模拟
     * 题目规定 1971年到2100年为有效输入日期
     * 1970年12月31日为星期四，则只需要计算输入日期与其的差值，+3之后对7求余即可
     */
    public String dayOfTheWeek1(int day, int month, int year) {
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        // 输入年份之前的年份的天数贡献 加上之前年份遇到闰年多出来的天数
        int days = 365 * (year - 1971) + (year - 1969) / 4;
        // 输入年份中，输入月份之前的月份贡献的天数
        for (int i = 0; i < month - 1; i++) {
            days += monthDays[i];
        }
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
            days += 1;
        }
        // 输入月份中的天数贡献
        days += day;
        return week[(days + 3) % 7];
    }
}
