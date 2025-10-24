package problems.c0easy.t2501t3000;

/**
 * 2894 分类求和并作差 https://leetcode.cn/problems/divisible-and-non-divisible-sums-difference/description/
 * 给你两个正整数 n 和 m 。
 * 现定义两个整数 num1 和 num2 ，如下所示：
 * num1：范围 [1, n] 内所有 无法被 m 整除 的整数之和。
 * num2：范围 [1, n] 内所有 能够被 m 整除 的整数之和。
 * 返回整数 num1 - num2
 *
 * 示例：
 * 输入1：n = 10, m = 3
 * 输出1：19
 *
 * 输入2：n = 5, m = 6
 * 输出2：15
 *
 * 输入3：n = 5, m = 1
 * 输出3：-15
 */
public class T2894 {
    /**
     * 自己实现：根据题意模拟即可
     */
    public int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m != 0) {
                num1 += i;
            } else {
                num2 += i;
            }
        }
        return num1 - num2;
    }

    /**
     * 官方解法：数学推导
     */
    public int differenceOfSums1(int n, int m) {
        int k = n / m;
        return n * (n + 1) / 2 - k * (k + 1) * m;
    }
}