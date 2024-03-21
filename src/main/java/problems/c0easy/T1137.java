package problems.c0easy;

/**
 * 1137 第 N 个泰波那契数 https://leetcode.cn/problems/n-th-tribonacci-number/description/
 * 泰波那契序列 Tn 定义如下：
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 * 示例：
 * 输入1：n = 4
 * 输出1：4
 *
 * 输入2：n = 25
 * 输出2：1389537
 */
public class T1137 {
    /**
     * 自己实现：递归
     * n 多的时候会超时
     */
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    /**
     * 自己实现：动态规划 + 滚动数组
     */
    public int tribonacci1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int p = 0;
        int q = 0;
        int r = 1;
        int s = 1;
        for (int i = 3; i <= n; i++) {
            p = q;
            q = r;
            r = s;
            s = p + q + r;
        }

        return s;
    }
}
