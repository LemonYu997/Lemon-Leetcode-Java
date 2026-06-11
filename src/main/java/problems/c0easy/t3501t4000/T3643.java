package problems.c0easy.t3501t4000;

/**
 * 3643 垂直翻转子矩阵 https://leetcode.cn/problems/flip-square-submatrix-vertically/description/
 * 给你一个 m x n 的整数矩阵 grid，以及三个整数 x、y 和 k。
 * 整数 x 和 y 表示一个 正方形子矩阵 的左上角下标，整数 k 表示该正方形子矩阵的边长。
 * 你的任务是垂直翻转子矩阵的行顺序。
 * 返回更新后的矩阵。
 *
 * 示例：
 * 输入1：grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], x = 1, y = 0, k = 3
 * 输出1：[[1,2,3,4],[13,14,15,8],[9,10,11,12],[5,6,7,16]]
 *
 * 输入2：grid = [[3,4,2,3],[2,3,4,2]], x = 0, y = 2, k = 2
 * 输出2：[[3,4,4,2],[2,3,2,3]]
 */
public class T3643 {
    /**
     * 官方解法：根据题意模拟
     */
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i0 = x, i1 = x + k - 1; i0 < i1; i0++, i1--) {
            for (int j = y; j < y + k; j++) {
                int temp = grid[i0][j];
                grid[i0][j] = grid[i1][j];
                grid[i1][j] = temp;
            }
        }
        return grid;
    }
}
