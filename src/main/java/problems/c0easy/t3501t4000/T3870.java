package problems.c0easy.t3501t4000;

/**
 * 3870 统计范围内的逗号 https://leetcode.cn/problems/count-commas-in-range/description/
 * 给你一个整数 n。
 * 返回将所有从 [1, n]（包含两端）范围内的整数以 标准 数字格式书写时所用到的 逗号总数。
 * 在 标准 格式中：
 * 从右边开始，每 三位 数字后插入一个逗号。
 * 位数 少于四位 的数字不包含逗号。
 *
 * 示例：
 * 输入1：n = 1002
 * 输出1：3
 *
 * 输入2：n = 998
 * 输出2：0
 *
 * 提示：
 * 1 <= n <= 10^5
 */
public class T3870 {
    /**
     * 自己实现：因为最大值不超过100,000，所以只需要计算超过1000的数量即可
     */
    public int countCommas(int n) {
        return n >= 1000 ? n - 1000 + 1 : 0;
    }

    /**
     * 社区解法：无视长度，通用解法
     */
    public long countCommas1(long n) {
        long ans = 0;
        for (long low = 1000; low <= n; low *= 1000) {
            ans += n - low + 1;
        }
        return ans;
    }
}