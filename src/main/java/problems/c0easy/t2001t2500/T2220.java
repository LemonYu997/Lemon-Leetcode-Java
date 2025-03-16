package problems.c0easy.t2001t2500;

/**
 * 2220 转换数字的最少位翻转次数 https://leetcode.cn/problems/minimum-bit-flips-to-convert-number/description/
 * 一次 位翻转 定义为将数字 x 二进制中的一个位进行 翻转 操作，即将 0 变成 1 ，或者将 1 变成 0 。
 * 比方说，x = 7 ，二进制表示为 111 ，我们可以选择任意一个位（包含没有显示的前导 0 ）并进行翻转。
 * 比方说我们可以翻转最右边一位得到 110 ，或者翻转右边起第二位得到 101 ，或者翻转右边起第五位（这一位是前导 0 ）得到 10111 等等。
 * 给你两个整数 start 和 goal ，请你返回将 start 转变成 goal 的 最少位翻转 次数。
 *
 * 示例：
 * 输入1：start = 10, goal = 7
 * 输出1：3
 *
 * 输入2：start = 3, goal = 4
 * 输出2：3
 */
public class T2220 {
    /**
     * 自己实现：只需要找到两个二进制数 不同的位 的个数即可
     * 因此可以异或后再判断位值为 1 的个数
     */
    public int minBitFlips(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }
}
