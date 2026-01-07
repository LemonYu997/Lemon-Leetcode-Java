package problems.c0easy.t3001t3500;

/**
 * 3114 替换字符可以得到的最晚时间 https://leetcode.cn/problems/latest-time-you-can-obtain-after-replacing-characters/description/
 * 给你一个字符串 s，表示一个 12 小时制的时间格式，其中一些数字（可能没有）被 "?" 替换。
 * 12 小时制时间格式为 "HH:MM" ，其中 HH 的取值范围为 00 至 11，MM 的取值范围为 00 至 59。
 * 最早的时间为 00:00，最晚的时间为 11:59。
 * 你需要将 s 中的 所有 "?" 字符替换为数字，
 * 使得结果字符串代表的时间是一个 有效 的 12 小时制时间，并且是可能的 最晚 时间。
 * 返回结果字符串。
 *
 * 示例：
 * 输入1：s = "1?:?4"
 * 输出1："11:54"
 *
 * 输入2： s = "0?:5?"
 * 输出2： "09:59"
 */
public class T3114 {
    /**
     * 自己实现：根据题意模拟
     */
    public String findLatestTime(String s) {
        char c1 = s.charAt(0);
        char c2 = s.charAt(1);
        char c3 = s.charAt(3);
        char c4 = s.charAt(4);

        if (c1 == '?') {
            if (c2 != '?' && c2 > '1') {
                c1 = '0';
            } else {
                c1 = '1';
            }
        }
        if (c2 == '?') {
            // 首位为0时 第二位最高为 9，首位为1时，第二位最高为 2
            if (c1 == '0') {
                c2 = '9';
            } else {
                c2 = '1';
            }
        }
        if (c3 == '?') {
            c3 = '5';
        }
        if (c4 == '?') {
            c4 = '9';
        }

        StringBuilder sb = new StringBuilder();
        sb.append(c1).append(c2).append(":").append(c3).append(c4);

        return sb.toString();
    }

    /**
     * 社区解法：优化写法
     */
    public String findLatestTime1(String s) {
        char[] t = s.toCharArray();
        if (t[0] == '?') {
            t[0] = t[1] == '?' || t[1] <= '1' ? '1' : '0';
        }
        if (t[1] == '?') {
            t[1] = t[0] == '1' ? '1' : '9';
        }
        if (t[3] == '?') {
            t[3] = '5';
        }
        if (t[4] == '?') {
            t[4] = '9';
        }
        return new String(t);
    }
}