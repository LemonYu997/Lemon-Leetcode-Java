package problems.c0easy.t1001t1500;

/**
 * 1009 十进制整数的反码 https://leetcode.cn/problems/complement-of-base-10-integer/description/
 * 每个非负整数 N 都有其二进制表示。例如， 5 可以被表示为二进制 "101"，
 * 11 可以用二进制 "1011" 表示，依此类推。注意，除 N = 0 外，任何二进制表示中都不含前导零。
 * 二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。
 *
 * 给你一个十进制数 N，请你返回其二进制表示的反码所对应的十进制整数。
 *
 * 示例：
 * 输入1：5
 * 输出1：2
 *
 * 输入2：7
 * 输出2：0
 *
 * 输入3：10
 * 输出3：5
 */
public class T1009 {
    /**
     * 官方解法：位运算
     */
    public int bitwiseComplement(int n) {
        int mask = 1;
        // 生成和 n 长度一致的全为 1 的掩码
        while (mask < n) {
            mask = (mask << 1) + 1;
        }
        // 异或即可
        return n ^ mask;
    }
}
