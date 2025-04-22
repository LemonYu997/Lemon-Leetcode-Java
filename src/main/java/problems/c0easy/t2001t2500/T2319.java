package problems.c0easy.t2001t2500;

/**
 * 2319 判断矩阵是否是一个 X 矩阵 https://leetcode.cn/problems/check-if-matrix-is-x-matrix/description/
 * 如果一个正方形矩阵满足下述 全部 条件，则称之为一个 X 矩阵 ：
 *
 * 矩阵对角线上的所有元素都 不是 0
 * 矩阵中所有其他元素都是 0
 * 给你一个大小为 n x n 的二维整数数组 grid ，表示一个正方形矩阵。
 * 如果 grid 是一个 X 矩阵 ，返回 true ；否则，返回 false 。
 *
 * 示例：
 * 输入1：grid = [[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]
 * 输出1：true
 *
 * 输入2：grid = [[5,7,0],[0,3,1],[0,5,0]]
 * 输出2：false
 */
public class T2319 {
    /**
     * 自己实现：根据题意模拟
     */
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 找到对角线的坐标 其值不为零
                if (i == j || i == n - 1 - j) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    // 非对角线坐标其值应为 0
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
