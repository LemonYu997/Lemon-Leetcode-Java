package problems.c0easy.t2001t2500;

/**
 * 2413 最小偶倍数 https://leetcode.cn/problems/smallest-even-multiple/description/
 * 给你一个正整数 n ，返回 2 和 n 的最小公倍数（正整数）。
 *
 * 示例：
 * 输入1：n = 5
 * 输出1：10
 *
 * 输入2：n = 6
 * 输出2：6
 */
public class T2413 {
    /**
     * 自己实现：如果不是自身，则就是 2 * n
     */
    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : 2 * n;
    }
}
