package problems.c0easy.t3501t4000;

/**
 * 3986 统计起止时间经过的秒数 https://leetcode.cn/problems/number-of-elapsed-seconds-between-two-times/description/
 * 给你两个有效时间 startTime 和 endTime，它们均以字符串形式表示，格式为 "HH:MM:SS"。
 * 返回从 startTime 到 endTime 经过的秒数（包含两个端点）。
 *
 * 示例：
 * 输入1：startTime = "01:00:00", endTime = "01:00:25"
 * 输出1：25
 *
 * 输入2：startTime = "12:34:56", endTime = "13:00:00"
 * 输出2：1504
 */
public class T3986 {
    /**
     * 自己实现：根据题意计算，计算秒数差即可
     */
    public int secondsBetweenTimes(String startTime, String endTime) {
        String[] ss = startTime.split(":");
        int start = Integer.parseInt(ss[0]) * 60 * 60 + Integer.parseInt(ss[1]) * 60 + Integer.parseInt(ss[2]);
        String[] es = endTime.split(":");
        int end = Integer.parseInt(es[0]) * 60 * 60 + Integer.parseInt(es[1]) * 60 + Integer.parseInt(es[2]);
        return end - start;
    }

    /**
     * 社区解法：优化写法
     */
    public int secondsBetweenTimes1(String startTime, String endTime) {
        return parse(endTime) - parse(startTime);
    }

    private int parse(String time) {
        char[] t = time.toCharArray();
        int hour = (t[0] - '0') * 10 + (t[1] - '0');
        int minute = (t[3] - '0') * 10 + (t[4] - '0');
        int second = (t[6] - '0') * 10 + (t[7] - '0');
        return hour * 60 * 60 + minute * 60 + second;
    }
}
