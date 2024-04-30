package problems.c0easy.t1001t1500;

/**
 * 1317 将整数转换为两个无零整数的和 https://leetcode.cn/problems/convert-integer-to-the-sum-of-two-no-zero-integers/description/
 * 「无零整数」是十进制表示中 不含任何 0 的正整数。
 * 给你一个整数 n，请你返回一个 由两个整数组成的列表 [A, B]，满足：
 * A 和 B 都是无零整数
 * A + B = n
 * 题目数据保证至少有一个有效的解决方案。
 * 如果存在多个有效解决方案，你可以返回其中任意一个。
 *
 * 示例：
 * 输入1：n = 2
 * 输出1：[1,1]
 *
 * 输入2：n = 11
 * 输出2：[2,9]
 *
 * 输入3：n = 10000
 * 输出3：[1,9999]
 *
 * 输入4：n = 69
 * 输出4：[1,68]
 *
 * 输入5：n = 1010
 * 输出5：[11,999]
 */
public class T1317 {
    /**
     * 官方解法：枚举
     */
    public int[] getNoZeroIntegers(int n) {
        // 从 1 开始与 n - 1 组装
        for (int i = 1; i < n; i++) {
            int b = n - i;
            // i 和 b 均不存在 0 时才有效
            if (!(i + "" + b).contains("0")) {
                return new int[]{i, b};
            }
        }
        return new int[0];
    }
}
