package problems.c0easy.t3501t4000;

/**
 * 3827 统计单比特整数 https://leetcode.cn/problems/count-monobit-integers/description/
 * 给你一个整数 n。
 * 如果一个整数的二进制表示中所有位都相同，则称其为 单比特数（Monobit）。
 * 返回范围[0, n]（包括两端）内 单比特数 的个数。
 *
 * 示例：
 * 输入1：n = 1
 * 输出1：2
 *
 * 输入3：n = 4
 * 输出3：3
 */
public class T3827 {
    /**
     * 社区解法：一行
     */
    public int countMonobit(int n) {
        // int最长32位，则减去前导零长度则可知剩下的有效位数是多少，每多一位则多一种可能
        // 这里加一是因为多了一个 0 本身这种可能
        return 32 - Integer.numberOfLeadingZeros(n + 1);
    }
}
