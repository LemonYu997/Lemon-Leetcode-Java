package problems.c0easy.t2001t2500;

/**
 * 2224 转化时间需要的最少操作数 https://leetcode.cn/problems/minimum-number-of-operations-to-convert-time/description/
 * 给你两个字符串 current 和 correct ，表示两个 24 小时制时间 。
 * 24 小时制时间 按 "HH:MM" 进行格式化，其中 HH 在 00 和 23 之间，而 MM 在 00 和 59 之间。
 * 最早的 24 小时制时间为 00:00 ，最晚的是 23:59 。
 * 在一步操作中，你可以将 current 这个时间增加 1、5、15 或 60 分钟。你可以执行这一操作 任意 次数。
 * 返回将 current 转化为 correct 需要的 最少操作数 。
 *
 * 示例：
 * 输入1：current = "02:30", correct = "04:35"
 * 输出1:3
 *
 * 输入2：current = "11:00", correct = "11:01"
 * 输出2:1
 */
public class T2224 {
    /**
     * 自己实现：将两个时间都转为分钟，计算差值
     */
    public int convertTime(String current, String correct) {
        // 区分时和分
        String[] curs = current.split(":");
        String[] cors = correct.split(":");

        int ans = 0;

        // 目标时间与当前时间所差的分钟数
        int temp = (60 * Integer.parseInt(cors[0]) + Integer.parseInt(cors[1]))
                - (60 * Integer.parseInt(curs[0]) + Integer.parseInt(curs[1]));

        // 可以加 60 分钟的次数
        ans += temp / 60;
        temp = temp % 60;
        // 可以加 15 分钟的次数
        ans += temp / 15;
        temp = temp % 15;
        // 可以加 5 分钟的次数
        ans += temp / 5;
        temp = temp % 5;
        // 可以加 1 分钟的次数
        ans += temp;

        return ans;
    }

    /**
     * 官方解法：优化代码片段
     */
    public int convertTime1(String current, String correct) {
        // 区分时和分
        String[] curs = current.split(":");
        String[] cors = correct.split(":");

        int ans = 0;

        // 目标时间与当前时间所差的分钟数
        int temp = (60 * Integer.parseInt(cors[0]) + Integer.parseInt(cors[1]))
                - (60 * Integer.parseInt(curs[0]) + Integer.parseInt(curs[1]));

        int[] ops = new int[]{60, 15, 5, 1};
        for (int op : ops) {
            ans += temp / op;
            temp %= op;
        }
        return ans;
    }
}