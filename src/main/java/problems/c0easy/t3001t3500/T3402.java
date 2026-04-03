package problems.c0easy.t3001t3500;

/**
 * 3402 使每一列严格递增的最少操作次数 https://leetcode.cn/problems/minimum-operations-to-make-columns-strictly-increasing/description/
 * 给你一个由 非负 整数组成的 m x n 矩阵 grid。
 * 在一次操作中，你可以将任意元素 grid[i][j] 的值增加 1。
 * 返回使 grid 的所有列 严格递增 所需的 最少 操作次数。
 *
 * 示例：
 * 输入1：grid = [[3,2],[1,3],[3,4],[0,1]]
 * 输出1：15
 *
 * 输入2： grid = [[3,2,1],[2,1,0],[1,2,3]]
 * 输出2：12
 */
public class T3402 {
    public int minimumOperations(int[][] grid) {
        int ans = 0;
        for (int j = 0; j < grid[0].length; j++) {
            int pre = -1;
            for (int[] row : grid) {
                int x = row[j];
                ans += Math.max(pre + 1 - x, 0);
                pre = Math.max(pre + 1, x);
            }
        }
        return ans;
    }
}
