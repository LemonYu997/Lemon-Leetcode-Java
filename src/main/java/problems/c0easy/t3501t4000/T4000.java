package problems.c0easy.t3501t4000;

import java.util.Arrays;

/**
 * 4000 给定数位和的最大整数给定数位和的最大整数 https://leetcode.cn/problems/largest-integer-with-given-digit-sum/description/
 * 给你两个非负整数 n 和 s。
 * 返回满足下述条件的 最大 整数：
 * 最多有 n 位数字。
 * 其各位数字之和等于 s 。
 * 如果不存在这样的整数，则返回 -1。
 *
 * 示例：
 * 输入1：n = 2, s = 9
 * 输出1：90
 *
 * 输入2：n = 2, s = 19
 * 输出2：-1
 *
 * 输入3：n = 5, s = 0
 * 输出3：0
 */
public class T4000 {
    /**
     * 社区解法：贪心
     */
    public int largestInteger(int n, int s) {
        if (s > n * 9) {
            return -1;
        }
        if (s == 0) {
            return 0;
        }

        char[] res = new char[n];
        Arrays.fill(res, '0');
        for (int i = 0; i < n; i++) {
            if (s <= 9) {
                res[i] += (char) s;
                break;
            }
            res[i] = '9';
            s -= 9;
        }
        return Integer.parseInt(String.valueOf(res));
    }
}
