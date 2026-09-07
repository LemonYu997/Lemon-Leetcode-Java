package problems.c0easy.t3501t4000;

/**
 * 3959 判定好整数 https://leetcode.cn/problems/check-good-integer/description/
 * 给你一个正整数 n。
 * 令 digitSum 表示 n 的各位数字之和，令 squareSum 表示 n 的各位数字平方之和。
 * 如果一个整数满足 squareSum - digitSum >= 50，则称它是 好整数 。
 * 如果 n 是好整数，返回 true；否则，返回 false。
 *
 * 示例：
 * 输入1：n = 1000
 * 输出1：false
 *
 * 输入2：n = 19
 * 输出2：true
 */
public class T3959 {
    /**
     * 自己实现：根据题意模拟
     */
    public boolean checkGoodInteger(int n) {
        int squareSum = 0;
        int digitSum = 0;

        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            digitSum += digit;
            squareSum += digit * digit;
        }

        return squareSum - digitSum >= 50;
    }

    /**
     * 社区解法：优化写法
     */
    public boolean checkGoodInteger1(int n) {
        int diff = 0;
        while (n > 0) {
            int d = n % 10;
            diff += d * d - d;
            n /= 10;
        }
        return diff >= 50;
    }
}
