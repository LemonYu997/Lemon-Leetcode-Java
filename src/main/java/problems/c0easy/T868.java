package problems.c0easy;

/**
 * 868 二进制间距 https://leetcode.cn/problems/binary-gap/
 * 给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。
 * 如果不存在两个相邻的 1，返回 0 。
 * 如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。
 * 两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"1001" 中的两个 1 的距离为 3
 *
 * 示例：
 * 输入1：n = 22
 * 输出1：2
 * 备注：22 的二进制是 "10110" 。
 *
 * 输入2：n = 8
 * 输出2：0
 * 备注：8 的二进制是 "1000" 。
 *
 * 输入3：n = 5
 * 输出3：2
 * 备注：5 的二进制是 "101" 。
 */
public class T868 {
    /**
     * 自己实现：用 % 2的形式遍历每一个二进制位
     */
    public int binaryGap(int n) {
        int count = -1;
        int ans = 0;
        while (n != 0) {
            // 遇到第一个1进行初始化
            if (n % 2 == 1 && count == -1) {
                count = 0;
            } else if (n % 2 == 1) {
                //遇到当前 1 仍需计算距离
                count++;
                ans = Math.max(ans, count);
                // 重置间隔
                count = 0;
            } else if (count != -1) {
                // 如果已经有过一个1
                // 遇到0就加上间隔
                count++;
            }
            //下一个二进制位
            n /= 2;
        }

        return ans;
    }

    /**
     * 官方解法：位运算
     */
    public int binaryGap1(int n) {
        int last = -1;
        int ans = 0;
        for (int i = 0; n != 0; i++) {
            if (((n & 1) == 1)) {
                if (last != -1) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
            n >>= 1;
        }

        return ans;
    }
}