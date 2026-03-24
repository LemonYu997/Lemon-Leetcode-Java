package problems.c0easy.t3001t3500;

/**
 * 3370 仅含置位位的最小整数仅含置位位的最小整数 https://leetcode.cn/problems/smallest-number-with-all-set-bits/description/
 * 给你一个正整数 n。
 * 返回 大于等于 n 且二进制表示仅包含 置位 位的 最小 整数 x 。
 * 置位 位指的是二进制表示中值为 1 的位。
 *
 * 示例：
 * 输入1：n = 5
 * 输出1：7
 *
 * 输入2：n = 10
 * 输出2：15
 *
 * 输入3：n = 3
 * 输出3：3
 */
public class T3370 {
    /**
     * 自己实现：根据题意模拟，将所有位均变为1即可
     */
    public int smallestNumber(int n) {
        String binaryString = Integer.toBinaryString(n);
        String target = binaryString.replace('0', '1');
        return Integer.parseInt(target, 2);
    }
}
