package problems.c0easy.t2501t3000;

/**
 * 3000 对角线最长的矩形的面积 https://leetcode.cn/problems/maximum-area-of-longest-diagonal-rectangle/description/
 * 给你一个下标从 0 开始的二维整数数组 dimensions。
 * 对于所有下标 i（0 <= i < dimensions.length），
 * dimensions[i][0] 表示矩形 i 的长度，而 dimensions[i][1] 表示矩形 i 的宽度。
 * 返回对角线最 长 的矩形的 面积 。如果存在多个对角线长度相同的矩形，返回其中面积最 大 的矩形的面积。
 *
 * 示例：
 * 输入1：dimensions = [[9,3],[8,6]]
 * 输出1：48
 *
 * 输入2：dimensions = [[3,4],[4,3]]
 * 输出2：12
 */
public class T3000 {
    /**
     * 自己实现：根据题意模拟
     */
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxD = 0.0;
        int maxS = 0;
        for (int[] dimension : dimensions) {
            double now = Math.sqrt(dimension[0] * dimension[0] + dimension[1] * dimension[1]);
            if (now > maxD) {
                maxD = now;
                maxS = dimension[0] * dimension[1];
            } else if (now == maxD) {
                maxS = Math.max(maxS, dimension[0] * dimension[1]);
            }
        }
        return maxS;
    }

    /**
     * 官方解法：减少运算
     */
    public int areaOfMaxDiagonal1(int[][] dimensions) {
        int maxDiaSq = 0;
        int maxArea = 0;
        for (int[] dim : dimensions) {
            int l = dim[0];
            int w = dim[1];
            int diaSq = l * l + w * w;
            int area = l * w;
            if (diaSq > maxDiaSq) {
                maxDiaSq = diaSq;
                maxArea = area;
            } else if (diaSq == maxDiaSq) {
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}