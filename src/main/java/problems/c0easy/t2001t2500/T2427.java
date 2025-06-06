package problems.c0easy.t2001t2500;

/**
 * 2427 公因子的数目 https://leetcode.cn/problems/number-of-common-factors/description/
 * 给你两个正整数 a 和 b ，返回 a 和 b 的 公 因子的数目。
 *
 * 如果 x 可以同时整除 a 和 b ，则认为 x 是 a 和 b 的一个 公因子 。
 *
 * 示例：
 * 输入1：a = 12, b = 6
 * 输出1：4
 *
 * 输入2：a = 25, b = 30
 * 输出2：2
 */
public class T2427 {
    /**
     * 自己实现；暴力遍历
     */
    public int commonFactors(int a, int b) {
        int n = Math.min(a, b);
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (a % i == 0 && b % i == 0) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 高效解法：辗转相除法先找到最大公约数，减少遍历次数
     */
    public int commonFactors1(int a, int b) {
        int ans = 0;
        int n = gcd(a, b);

        for (int i = 1; i <= n; i++) {
            if (a % i == 0 && b % i == 0) {
                ans++;
            }
        }

        return ans;
    }

    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(a % b, a);
    }

}