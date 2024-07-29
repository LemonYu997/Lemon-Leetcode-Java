package problems.c0easy.t1501t2000;

import java.util.*;

/**
 * 1507 转变日期格式 https://leetcode.cn/problems/reformat-date/description/
 * 给你一个字符串 date ，它的格式为 Day Month Year ，其中：
 * 1、Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
 * 2、Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} 中的一个元素。
 * 3、Year 的范围在 ​[1900, 2100] 之间。
 * 请你将字符串转变为 YYYY-MM-DD 的格式，其中：
 * 1、YYYY 表示 4 位的年份。
 * 2、MM 表示 2 位的月份。
 * 3、DD 表示 2 位的天数。
 *
 * 示例：
 * 输入1：date = "20th Oct 2052"
 * 输出1："2052-10-20"
 *
 * 输入2：date = "6th Jun 1933"
 * 输出2："1933-06-06"
 *
 * 输入3：date = "26th May 1960"
 * 输出3："1960-05-26"
 */
public class T1507 {
    /**
     * 自己实现：根据题意模拟
     */
    public String reformatDate(String date) {
        String[] ms = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < ms.length; i++) {
            map.put(ms[i], i + 1);
        }
        String[] ss = date.split(" ");

        int y = Integer.parseInt(ss[2]);
        int m = map.get(ss[1]);
        int d = Integer.parseInt(ss[0].substring(0, ss[0].length() - 2));

        return String.format("%d-%02d-%02d", y, m , d);
    }
}
