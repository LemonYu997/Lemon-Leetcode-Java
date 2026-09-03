package problems.c0easy.t3501t4000;

/**
 * 3954 区间内的兼容数字之和 I https://leetcode.cn/problems/sum-of-compatible-numbers-in-range-i/description/
 * 给你两个整数 n 和 k。
 * 如果一个 正 整数 x 同时满足以下两个条件，则称其为 兼容 整数：
 * abs(n - x) <= k
 * (n & x) == 0
 * 返回所有 兼容 整数 x 的总和。
 *
 * 注意：
 * 这里，& 表示 按位与 运算符。
 * 整数 i 和 j 之间的 绝对 差定义为 abs(i - j)。
 *
 * 示例：
 * 输入1：n = 2, k = 3
 * 输出1：10
 *
 * 输入2：n = 5, k = 1
 * 输出2：0
 */
public class T3954 {
    /**
     * 自己实现：根据题意模拟
     */
    public int sumOfGoodIntegers(int n, int k) {
        int ans = 0;

        for (int i = n - k; i <= n + k; i++) {
            if (i > 0 && (n & i) == 0) {
                ans += i;
            }
        }
        return ans;
    }
}
