package problems.c0easy.t2001t2500;

/**
 * 2485 找出中枢整数 https://leetcode.cn/problems/find-the-pivot-integer/description/
 * 给你一个正整数 n ，找出满足下述条件的 中枢整数 x ：
 *
 * 1 和 x 之间的所有元素之和等于 x 和 n 之间所有元素之和。
 * 返回中枢整数 x 。如果不存在中枢整数，则返回 -1 。题目保证对于给定的输入，至多存在一个中枢整数。
 *
 * 示例：
 * 输入1：n = 8
 * 输出1：6
 *
 * 输入2：n = 1
 * 输出2：1
 *
 * 输入3：n = 4
 * 输出3：-1
 */
public class T2485 {
    /**
     * 自己实现：根据题意模拟，遍历两次，先求和再判断
     */
    public int pivotInteger(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        int temp = 0;
        for (int i = 1; i <= n; i++) {
            // 注意当前值不算在两边的和里
            temp += i - 1;
            if (temp == sum - temp - i) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 官方解法：数学计算
     * sum(1, x) = sum(x, n)
     * x = Math.sqrt((n * n + n) / 2)
     */
    public int pivotInteger1(int n) {
        int t = (n * n + n) / 2;
        int x = (int) Math.sqrt(t);
        if (x * x == t) {
            return x;
        }
        return -1;
    }
}
