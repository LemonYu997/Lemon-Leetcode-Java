package problems.c0easy.t3501t4000;

/**
 * 3950 恰好一对连续置位 https://leetcode.cn/problems/exactly-one-consecutive-set-bits-pair/description/
 * 给你一个整数 n 。
 * 如果其二进制表示中 恰好 仅包含 一对 相邻的置位 ，则返回 true ，否则返回 false 。
 * 整数中的 置位 是指其 二进制 表示中的 1 。
 *
 * 示例：
 * 输入1：n = 6
 * 输出1：true
 *
 * 输入2：n = 5
 * 输出2：false
 */
public class T3950 {
    /**
     * 自己实现：根据题意判断即可
     */
    public boolean consecutiveSetBits(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1' && s.charAt(i - 1) == '1') {
                count++;
            }
        }
        return count == 1;
    }

    /**
     * 社区解法：位运算
     */
    public boolean consecutiveSetBits1(int n) {
        int cnt = 0;
        for (; n > 1; n >>= 1) {
            // 最低两位都是 1
            if ((n & 3) == 3) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}