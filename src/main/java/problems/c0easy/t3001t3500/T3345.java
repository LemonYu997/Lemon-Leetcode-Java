package problems.c0easy.t3001t3500;

/**
 * 3345 最小可整除数位乘积 I https://leetcode.cn/problems/smallest-divisible-digit-product-i/description/
 * 给你两个整数 n 和 t 。请你返回大于等于 n 的 最小 整数，且该整数的 各数位之积 能被 t 整除。
 *
 * 示例：
 * 输入1：n = 10, t = 2
 * 输出1：10
 *
 * 输入2：n = 15, t = 3
 * 输出2：16
 */
public class T3345 {
    /**
     * 自己实现：根据题意模拟
     */
    public int smallestNumber(int n, int t) {
        // 从 n 递增，计算每一个数的乘积
        while (getA(n) % t != 0) {
            n++;
        }
        return n;
    }

    public int getA(int n) {
        int a = 1;
        while (n > 0) {
            a *= n % 10;
            n /= 10;
        }
        return a;
    }

    /**
     * 社区解法：优化写法
     */
    public int smallestNumber1(int n, int t) {
        for (int i = n; ;i++) {
            int prod = 1;
            for (int x = i; x > 0; x /= 10) {
                prod *= x % 10;
            }
            if (prod % t == 0) {
                return i;
            }
        }
    }
}