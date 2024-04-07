package problems.c0easy.t1t500;

/**
 * 463 岛屿的周长 https://leetcode.cn/problems/island-perimeter/
 * 给定一个row x col的二维网格地图grid，其中grid[i][j] = 1表示陆地，grid[i][j] = 0表示海洋
 * 岛屿陆地由边长为1的格子互相连接，求岛屿的周长
 *
 * 示例：
 * 输入1：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * 输出1:16
 *
 * 输入2：grid = [[1]]
 * 输出2:4
 *
 * 输入3：grid = [[1,0]]
 * 输出3：4
 */
public class T463 {
    /**
     * 官方解法1：迭代
     * 对于一个陆地格子的每个边，只有当这条边为网格的边界或者相邻的另一个格子为水域时才算周长
     */
    public int islandPerimeter1(int[][] grid) {
        // 下个格子的x轴与y轴加的值，右下左上
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        //n是高度 m是宽度
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        //tx < 0时是左边界 tx >= n时是右边界
                        //ty < 0时是上边界，ty >= m时是下边界
                        //grid[tx][ty] == 0,相邻格子为水域
                        if (tx < 0 || tx >= n || ty < 0 || ty >= m || grid[tx][ty] == 0) {
                            count++;
                        }
                    }
                    ans += count;
                }
            }
        }

        return ans;
    }
}
