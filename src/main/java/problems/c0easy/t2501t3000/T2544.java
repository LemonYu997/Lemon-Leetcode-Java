package problems.c0easy.t2501t3000;

/**
 * 2544 交替数字和 https://leetcode.cn/problems/alternating-digit-sum/description/
 * 给你一个正整数 n 。n 中的每一位数字都会按下述规则分配一个符号：
 * 最高有效位 上的数字分配到 正 号。
 * 剩余每位上数字的符号都与其相邻数字相反。
 * 返回所有数字及其对应符号的和。
 *
 * 示例：
 * 输入1：n = 521
 * 输出1：4
 *
 * 输入2：n = 111
 * 输出2：1
 *
 * 输入3：n = 886996
 * 输出3：0
 */
public class T2544 {
    /**
     * 自己实现：根据题意模拟
     */
    public int alternateDigitSum(int n) {
        int ans = 0;
        String num = String.valueOf(n);
        boolean flag = true;

        for (int i = 0; i < num.length(); i++) {
            int temp = num.charAt(i) - '0';
            if (flag) {
                ans += temp;
            } else {
                ans -= temp;
            }
            flag = !flag;
        }

        return ans;
    }

    /**
     * 官方解法
     */
    public int alternateDigitSum1(int n) {
        int res = 0;
        int sign = 1;

        while (n > 0) {
            res += n % 10 * sign;
            // 注意即使算到最高位后这里还是会取一次反
            sign = -sign;
            n /= 10;
        }

        // 如果 n 位数为偶数，则 sign 此时为正数（但是第一位取得是负数，因此这里要重新乘以 -1)
        // 如果 n 位数为奇数，则 sign 此时为负数（但是第一位取得是正数，因此这里 -sign = 1)
        return -sign * res;
    }
}
