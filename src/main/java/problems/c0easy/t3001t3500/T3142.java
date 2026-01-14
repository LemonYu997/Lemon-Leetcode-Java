package problems.c0easy.t3001t3500;

/***
 * 3142 判断矩阵是否满足条件 https://leetcode.cn/problems/check-if-grid-satisfies-conditions/description/
 * 给你一个大小为 m x n 的二维矩阵 grid 。你需要判断每一个格子 grid[i][j] 是否满足：
 * 如果它下面的格子存在，那么它需要等于它下面的格子，也就是 grid[i][j] == grid[i + 1][j] 。
 * 如果它右边的格子存在，那么它需要不等于它右边的格子，也就是 grid[i][j] != grid[i][j + 1] 。
 * 如果 所有 格子都满足以上条件，那么返回 true ，否则返回 false 。
 *
 * 示例：
 * 输入1：grid = [[1,0,2],[1,0,2]]
 * 输出1：true
 *
 * 输入2：grid = [[1,1,1],[0,0,0]]
 * 输出2：false
 *
 * 输入3：grid = [[1],[2],[3]]
 * 输出3：false
 */
public class T3142 {
    /***
     * 自己实现：根据题意模拟
     */
    public boolean satisfiesConditions(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 必须等于下边的格子
                if (i < m - 1 && grid[i][j] != grid[i + 1][j]) {
                    return false;
                }
                // 必须不等于右边的格子
                if (j < n - 1 && grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
