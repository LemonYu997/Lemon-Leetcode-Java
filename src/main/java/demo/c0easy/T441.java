package demo.c0easy;

/**
 * 441 排列硬币 https://leetcode.cn/problems/arranging-coins/
 * 总共有n枚硬币，并计划它们按阶梯状排列
 * 对于一个由k行组成的阶梯，其第i行必须正好有i枚硬币，阶梯的最后一行可能是不完整的
 * 给定一个数字n，返回可形成完整阶梯行的总行数
 *
 * 示例：
 * 输入1：n = 5
 * 输出1:2
 * 备注：因为第三行不完整，所以返回 2 。
 *
 * 输入2：n = 8
 * 输出2：3
 */
public class T441 {
    /**
     * 自己实现：根据定义
     */
    public int arrangeCoins(int n) {
        int i = 1;
        while (true) {
            n = n - i;
            if (n < 0) {
                return i - 1;
            }
            i++;
        }
    }

    /**
     * 官方解法1：二分查找
     * 根据等差数列求和公式，前k个完整阶梯行所需的硬币数量为 (k * (k+1)) / 2
     */
    public int arrangeCoins1(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
