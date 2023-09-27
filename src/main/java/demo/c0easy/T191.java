package demo.c0easy;

/**
 * 191 位1的个数 https://leetcode.cn/problems/number-of-1-bits/
 * 编写一个函数，输入一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为1的个数（也叫汉明重量）
 *
 * 示例：
 * 输入1：n = 00000000000000000000000000001011
 * 输出1:3
 *
 * 输入2：n = 00000000000000000000000010000000
 * 输出2:1
 *
 * 输入3：n = 11111111111111111111111111111101
 * 输出3:31
 */
public class T191 {
    /**
     * 自己实现：将其转为二进制字符串，获取1的个数即可
     */
    public int hammingWeight1(int n) {
        char[] chars = Integer.toBinaryString(n).toCharArray();
        int count = 0;

        for (char c : chars) {
            if (c == '1') {
                count++;
            }
        }

        return count;
    }

    /**
     * 官方解法1：位运算
     * 循环检查给定整数n的二进制位的每一位是否为1
     */
    public int hammingWeight2(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }

        return ret;
    }
}
