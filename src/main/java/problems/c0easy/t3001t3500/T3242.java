package problems.c0easy.t3001t3500;

import java.util.HashMap;
import java.util.Map;

/**
 * 3242 设计相邻元素求和服务 https://leetcode.cn/problems/design-neighbor-sum-service/description/
 * 给你一个 n x n 的二维数组 grid，它包含范围 [0, n2 - 1] 内的不重复元素。
 * 实现 neighborSum 类：
 * neighborSum(int [][]grid) 初始化对象。
 * int adjacentSum(int value) 返回在 grid 中与 value 相邻的元素之和，
 * 相邻指的是与 value 在上、左、右或下的元素。
 * int diagonalSum(int value) 返回在 grid 中与 value 对角线相邻的元素之和，
 * 对角线相邻指的是与 value 在左上、右上、左下或右下的元素。
 *
 * 示例：
 * 输入1：["neighborSum", "adjacentSum", "adjacentSum", "diagonalSum", "diagonalSum"]
 * [[[[0, 1, 2], [3, 4, 5], [6, 7, 8]]], [1], [4], [4], [8]]
 * 输出1：[null, 6, 16, 16, 4]
 *
 * 输入2：["neighborSum", "adjacentSum", "diagonalSum"]
 * [[[[1, 2, 0, 3], [4, 7, 15, 6], [8, 9, 10, 11], [12, 13, 14, 5]]], [15], [9]]
 * 输出2： [null, 23, 45]
 */
public class T3242 {
    /**
     * 官方解法：使用Map，记录每一个值及其位置
     */
    class NeighborSum {
        private int[][] grid;
        private Map<Integer, int[]> pos;
        // dirs[0]表示相邻的索引位置，dirs[1]表示对角相邻的索引位置
        private final int[][][] dirs = {
                {{-1, 0}, {1, 0}, {0, -1}, {0, 1}},
                {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}}
        };
        public NeighborSum(int[][] grid) {
            this.grid = grid;
            this.pos = new HashMap<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    // 记录当前值及其所处的位置
                    pos.put(grid[i][j], new int[]{i, j});
                }
            }
        }

        public int adjacentSum(int value) {
            return getSum(value, 0);
        }

        public int diagonalSum(int value) {
            return getSum(value, 1);
        }

        // 工具函数，idx = 0表示相邻，idx = 1 表示对角线相邻
        public int getSum(int value, int idx) {
            int[] p = pos.get(value);
            int x = p[0], y = p[1];
            int sum = 0;
            for (int[] dir : dirs[idx]) {
                // 计算实际坐标值
                int nx = x + dir[0];
                int ny = y + dir[1];
                // 边界判断
                if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
                    sum += grid[nx][ny];
                }
            }
            return sum;
        }
    }
}
