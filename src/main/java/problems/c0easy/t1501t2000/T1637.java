package problems.c0easy.t1501t2000;

import java.util.Arrays;

/**
 * 1637 两点之间不包含任何点的最宽垂直区域 https://leetcode.cn/problems/widest-vertical-area-between-two-points-containing-no-points/description/
 * 给你 n 个二维平面上的点 points ，其中 points[i] = [xi, yi] ，
 * 请你返回两点之间内部不包含任何点的 最宽垂直区域 的宽度。
 *
 * 垂直区域 的定义是固定宽度，而 y 轴上无限延伸的一块区域（也就是高度为无穷大）。
 * 最宽垂直区域 为宽度最大的一个垂直区域。
 *
 * 请注意，垂直区域 边上 的点 不在 区域内。
 *
 * 示例：
 * 输入1：points = [[8,7],[9,9],[7,4],[9,7]]
 * 输出1：1
 *
 * 输入2：points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
 * 输出2：3
 */
public class T1637 {
    /**
     * 官方解法：找到相邻两点横坐标的最大间距
     */
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int mx = 0;
        for (int i = 1; i < points.length; i++) {
            mx = Math.max(points[i][0] - points[i - 1][0], mx);
        }
        return mx;
    }
}
