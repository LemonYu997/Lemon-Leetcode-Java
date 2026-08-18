package problems.c0easy.t3501t4000;

/**
 * 3908 有效数字整数 https://leetcode.cn/problems/valid-digit-number/description/
 * 给你一个整数 n 和一个数字 x。
 * 如果一个数字满足以下条件，则认为它是 有效 的：
 * 它包含 至少一个 数字 x，并且
 * 它 不以 数字 x 开头。
 * 如果 n 是 有效 的，请返回 true，否则返回 false。
 *
 * 示例：
 * 输入1：n = 101, x = 0
 * 输出1：true
 *
 * 输入2：n = 232, x = 2
 * 输出2：false
 *
 * 输入3：n = 5, x = 1
 * 输出3：false
 */
public class T3908 {
    /**
     * 自己实现：根据题意模拟
     */
    public boolean validDigit(int n, int x) {
        String s = String.valueOf(n);
        if (s.charAt(0) - '0' == x) {
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) - '0' == x) {
                return true;
            }
        }
        return false;
    }

    /**
     * 社区解法：优化写法
     */
    public boolean validDigit1(int n, int x) {
        boolean hasX = false;
        for (; n >= 10; n /= 10) {
            if (n % 10 == x) {
                hasX = true;
            }
        }
        return hasX && n != x;
    }
}