package problems.c0easy.t2001t2500;

/**
 * 2481 分割圆的最少切割次数 https://leetcode.cn/problems/minimum-cuts-to-divide-a-circle/description/
 * 圆内一个 有效切割 ，符合以下二者之一：
 *
 * 该切割是两个端点在圆上的线段，且该线段经过圆心。
 * 该切割是一端在圆心另一端在圆上的线段。
 * 一些有效和无效的切割如下图所示。
 *
 * 给你一个整数 n ，请你返回将圆切割成相等的 n 等分的 最少 切割次数。
 *
 * 示例：
 * 输入1：n = 4
 * 输出1：2
 *
 * 输入2：n = 3
 * 输出2：3
 */
public class T2481 {
    /**
     * 自己实现：偶数 / 2，奇数等于自身，1返回0
     */
    public int numberOfCuts(int n) {
        if (n == 1) {
            return 0;
        }

        return n % 2 == 0 ? n / 2 : n;
    }
}
