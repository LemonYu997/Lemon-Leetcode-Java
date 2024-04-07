package problems.c0easy.t1001t1500;

/**
 * 1037 有效的回旋镖 https://leetcode.cn/problems/valid-boomerang/description/
 * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，
 * 如果这些点构成一个 回旋镖 则返回 true 。
 *
 * 回旋镖 定义为一组三个点，这些点 各不相同 且 不在一条直线上 。
 *
 * 示例：
 * 输入1：points = [[1,1],[2,3],[3,2]]
 * 输出1：true
 *
 * 输入2：points = [[1,1],[2,2],[3,3]]
 * 输出2：false
 */
public class T1037 {
    /**
     * 官方解法：判断三点是否同线，根据数学知识，使用向量叉乘
     * 如果三点不在一条线上，则两条线向量叉乘不为0
     */
    public boolean isBoomerang(int[][] points) {
        int[] v1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] v2 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }
}
