package problems.c0easy.t501t1000;

/**
 * 812 最大三角形面积 https://leetcode.cn/problems/largest-triangle-area/
 * 给你一个由 X-Y 平面上的点组成的数组 points ，其中 points[i] = [xi, yi] 。
 * 从其中取任意三个不同的点组成三角形，返回能组成的最大三角形的面积。
 *
 * 示例：
 * 输入1：points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * 输出1：2.00000
 * 备注：输入中的 5 个点如上图所示，红色的三角形面积最大。
 *
 * 输入2：points = [[1,0],[0,0],[0,1]]
 * 输出2：0.50000
 * */
public class T812 {
    public static void main(String[] args) {
        int[][] points = {{0,0},{0,1},{1,0},{0,2},{2,0}};
        System.out.println(largestTriangleArea(points));
    }

    /**
     * 自己实现：暴力解法 三角形面积公式
     * 0.5 * |x1y2 + x2y3 + x3y1 - x1y3 - x2y1 - x3y2|
     */
    public static double largestTriangleArea(int[][] points) {
        int l = points.length;
        double max = 0.0;

        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                for (int k = j + 1; k < l; k++) {
                    //根据顶点坐标求面积公式 海伦公式
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int x3 = points[k][0];
                    int y3 = points[k][1];

                    double S = 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);

                    max = Math.max(max, S);
                }
            }
        }

        return max;
    }
}
