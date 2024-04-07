package problems.c0easy.t501t1000;

/**
 * 883 三维形体投影面积 https://leetcode.cn/problems/projection-area-of-3d-shapes/
 * 在 n x n 的网格 grid 中，放置了一些与 x，y，z 三轴对齐的 1 x 1 x 1 立方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 * 现在，查看这些立方体在 xy 、yz 和 zx 平面上的投影。
 * 投影 就像影子，将 三维 形体映射到一个 二维 平面上。
 * 从顶部、前面和侧面看立方体时，我们会看到“影子”。
 * 返回 所有三个投影的总面积 。
 *
 * 示例：
 * 输入1：[[1,2],[3,4]]
 * 输出1：17
 *
 * 输入2：grid = [[2]]
 * 输出2：5
 *
 * 输入3：[[1,0],[0,2]]
 * 输出3：8
 */
public class T883 {
    /**
     * 官方解法：根据题意模拟
     * xy平面上的投影是 数组中非 0 数字之和
     * xz平面上的投影是 每一列最大值之和，即每个grid[i]中的最大值
     * yz平面上的投影是 每一行最大值之和，即指定每一个[j]的最大值
     */
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int xyArea = 0;
        int yzArea = 0;
        int zxArea = 0;
        for (int i = 0; i < n; i++) {
            int yzHeight = 0;
            int zxHeight = 0;
            for (int j = 0; j < n; j++) {
                xyArea += grid[i][j] > 0 ? 1 : 0;
                // 每一行最大值
                yzHeight = Math.max(yzHeight, grid[j][i]);
                // 每一列最大值
                zxHeight = Math.max(zxHeight, grid[i][j]);
            }
            yzArea += yzHeight;
            zxArea += zxHeight;
        }
        return xyArea + yzArea + zxArea;
    }
}
