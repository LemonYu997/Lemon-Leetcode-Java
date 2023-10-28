package demo.c0easy;

/**
 * 461 汉明距离 https://leetcode.cn/problems/hamming-distance/
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同位置的数目
 *
 * 示例：
 * 输入1：x = 1, y = 4
 * 输出1:2
 * 备注：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *
 * 输入2：x = 3, y = 1
 * 输出2:1
 */
public class T461 {
    /**
     * 官方解法1：内置位计数
     * x ^ y 异或运算后，1的个数即为之间的距离
     */
    public int hammingDistance1(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
