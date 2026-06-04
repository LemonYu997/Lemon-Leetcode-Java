package problems.c0easy.t3501t4000;

/**
 * 3602 十六进制和三十六进制转化 https://leetcode.cn/problems/hexadecimal-and-hexatrigesimal-conversion/description/
 * 给你一个整数 n。
 * 返回 n2 的 十六进制表示 和 n3 的 三十六进制表示 拼接成的字符串。
 * 十六进制 数定义为使用数字 0 – 9 和大写字母 A - F 表示 0 到 15 的值。
 * 三十六进制 数定义为使用数字 0 – 9 和大写字母 A - Z 表示 0 到 35 的值。
 *
 * 示例：
 * 输入1：n = 13
 * 输出1："A91P1"
 *
 * 输入2：n = 36
 * 输出2："5101000"
 */
public class T3602 {
    /**
     * 社区解法：调包
     */
    public String concatHex36(int n) {
        String s = Integer.toHexString(n * n) + Integer.toString(n * n * n, 36);
        return s.toUpperCase();
    }
}
