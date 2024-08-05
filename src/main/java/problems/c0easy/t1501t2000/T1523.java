package problems.c0easy.t1501t2000;

/**
 * 1523 在区间范围内统计奇数数目 https://leetcode.cn/problems/count-odd-numbers-in-an-interval-range/description/
 * 给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
 *
 * 示例：
 * 输入1：low = 3, high = 7
 * 输出1：3
 *
 * 输入2：low = 8, high = 10
 * 输出2：1
 */
public class T1523 {
    /**
     * 自己实现：遍历即可
     * 数据量太大会超出时间限制
     */
    public int countOdds(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; i++) {
            if (i % 2 == 1) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 自己实现：数学规律，偶数和奇数时各占一半的，可以 (high - low) / 2 = n
     * 如果 low 或 high 其中有奇数，再加 1
     * 如 3-8，有 3、5、7 三个 = (8 - 3) / 2 + 1 = 3
     */
    public int countOdds1(int low, int high) {
        int ans = (high - low) / 2;
        if (high % 2 == 1 || low % 2 == 1) {
            ans++;
        }
        return ans;
    }

    /**
     * 官方解法：前缀和
     * 定义 pre(x) 为 [0,x] 区间内的奇数个数
     * 则 pre(x) = (x+1) / 2
     * 所以答案为 pre(high) - pre(low - 1)
     */
    public int countOdds2(int low, int high) {
        return pre(high) - pre(low - 1);
    }

    public int pre(int x) {
        return (x + 1) >> 1;
    }
}
