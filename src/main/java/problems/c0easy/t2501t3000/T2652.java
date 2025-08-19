package problems.c0easy.t2501t3000;

/**
 * 2652 倍数求和 https://leetcode.cn/problems/sum-multiples/description/
 * 给你一个正整数 n ，请你计算在 [1，n] 范围内能被 3、5、7 整除的所有整数之和。
 * 返回一个整数，用于表示给定范围内所有满足约束条件的数字之和。
 *
 * 示例：
 * 输入1：n = 7
 * 输出1：21
 *
 * 输入2：n = 10
 * 输出2：40
 *
 * 输入3：n = 9
 * 输出3：30
 */
public class T2652 {
    /**
     * 自己实现：根据题意模拟
     */
    public int sumOfMultiples(int n) {
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                ans += i;
            }
        }

        return ans;
    }
}
