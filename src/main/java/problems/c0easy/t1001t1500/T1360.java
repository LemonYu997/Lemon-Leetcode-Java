package problems.c0easy.t1001t1500;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 1360 日期之间隔几天 https://leetcode.cn/problems/number-of-days-between-two-dates/
 * 请你编写一个程序来计算两个日期之间隔了多少天。
 * 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
 *
 * 示例：
 * 输入1：date1 = "2019-06-29", date2 = "2019-06-30"
 * 输出1：1
 *
 * 输入2：date1 = "2020-01-15", date2 = "2019-12-31"
 * 输出2：15
 *
 * 闰年：
 * 公元年份非4的倍数，为365天平年。
 * 公元年份为4的倍数但非100的倍数，为366天闰年。
 * 公元年份为100的倍数但非400的倍数，（1700年、1800年及1900年）为平年。
 * 公元年份为400的倍数，（1600年及2000年）为闰年。
 */
public class T1360 {
    /**
     * 官方解法：API版本
     * leetcode网站不支持
     */
    public int daysBetweenDates(String date1, String date2) {
        LocalDate d1 = LocalDate.parse(date1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate d2 = LocalDate.parse(date2, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int result = (int) (d2.toEpochDay() - d1.toEpochDay());
        return d1.isAfter(d2) ? result * (-1) : result;
    }

    /**
     * 官方解法：转为整数，暴力计算
     * 题目限制输入日期最早为1971年，因此可以计算两个日期与 1971年1月1日 之间的差值
     */
    public int daysBetweenDates1(String date1, String date2) {
        return Math.abs(dateToInt1(date1) - dateToInt1(date2));
    }

    /**
     * 计算 输入日期 与 1971年1月1日 之间的差值
     */
    public int dateToInt1(String date) {
        int year, month, day;
        String[] dates = date.split("-");
        year = Integer.parseInt(dates[0]);
        month = Integer.parseInt(dates[1]);
        day = Integer.parseInt(dates[2]);
        // 索引 0 是 12 月
        int[] monthLength = {31, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        int ans = 0;

        while (year != 1971 || month != 1 || day != 1) {
            ans++;
            // 更新年月日
            if (--day == 0) {
                if (--month == 0) {
                    year--;
                }
            }
            if (day == 0) {
                day = monthLength[month];
                // 闰年需要 + 1
                if (month == 2 && ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0))) {
                    day++;
                }
            }
            if (month == 0) {
                month = 12;
            }
        }

        return ans;
    }

    /**
     * 官方解法：优化上述解法，先计算距离当前年 1月1日的 差值，再计算差多少年即可
     */
    public int daysBetweenDates2(String date1, String date2) {
        return Math.abs(dateToInt2(date1) - dateToInt2(date2));
    }

    public int dateToInt2(String date) {
        int year, month, day;
        String[] dates = date.split("-");
        year = Integer.parseInt(dates[0]);
        month = Integer.parseInt(dates[1]);
        day = Integer.parseInt(dates[2]);
        // 索引 0 是 12 月
        int[] monthLength = {31, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        // 当月的天数
        int ans = day - 1;
        // 当年的天数（需要判断是否为闰年）
        while (month != 0) {
            month--;
            ans += monthLength[month];
            // 闰年需要 + 1
            if (month == 2 && ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0))) {
                ans++;
            }
        }
        // 计算年 和 闰年
        ans += 365 * (year - 1971);
        ans += (year - 1) / 4 - 1971 / 4;
        ans -= (year - 1) / 100 - 1971 / 100;
        ans += (year - 1) / 400 - 1971 / 400;
        return ans;
    }
}
