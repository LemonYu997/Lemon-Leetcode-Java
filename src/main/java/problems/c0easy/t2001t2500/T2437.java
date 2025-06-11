package problems.c0easy.t2001t2500;

/**
 * 2437 有效时间的数目 https://leetcode.cn/problems/number-of-valid-clock-times/description/
 * 给你一个长度为 5 的字符串 time ，表示一个电子时钟当前的时间，格式为 "hh:mm" 。
 * 最早 可能的时间是 "00:00" ，最晚 可能的时间是 "23:59" 。
 * 在字符串 time 中，被字符 ? 替换掉的数位是 未知的 ，被替换的数字可能是 0 到 9 中的任何一个。
 * 请你返回一个整数 answer ，将每一个 ? 都用 0 到 9 中一个数字替换后，可以得到的有效时间的数目。
 *
 * 示例：
 * 输入1：time = "?5:00"
 * 输出1:2
 *
 * 输入2：time = "0?:0?"
 * 输出2：100
 *
 * 输入3：time = "??:??"
 * 输出3：1440
 */
public class T2437 {
    /**
     * 自己实现：分情况计算
     * 时钟只能取 24 以下的数字，分钟根据 ? 在第一位则是 6种，在第二位则是 10 种
     */
    public int countTime(String time) {
        int ans = 1;
        char a = time.charAt(0);
        char b = time.charAt(1);
        char c = time.charAt(3);
        char d = time.charAt(4);

        if (a == '?' && b == '?') {
            ans *= 24;
        } else if (b == '?') {
            // 如果时钟第一位是 2，则第二位只能是 0 1 2 3
            if (a == '2') {
                ans *= 4;
            } else {
                ans *= 10;
            }
        } else if (a == '?') {
            // 如果时钟第二位 >= 4 则时钟第一位只能是 0 和 1
            if (b <= '9' && b >= '4') {
                ans *= 2;
            } else {
                ans *= 3;
            }
        }

        if (c == '?') {
            ans *= 6;
        }
        if (d == '?') {
            ans *= 10;
        }

        return ans;
    }
}
