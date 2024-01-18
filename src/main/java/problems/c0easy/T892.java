package problems.c0easy;

/**
 * 892 三维形体的表面积 https://leetcode.cn/problems/surface-area-of-3d-shapes/
 * 给定一个 n * n 的网格 grid，上面放置一些 1 * 1 * 1 的正方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * 放置好正方体后，任何直接相邻的正方体都会互相粘在一起，形成一些不规则的三维形体。
 * 返回最终这些形体的总表面积。
 * 注意：每个形体的底面也需要计入表面积中。
 *
 * 示例：
 * 输入1：grid = [[1,2],[3,4]]
 * 输出1：34
 *
 * 输入2：grid = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出2：32
 *
 * 输入3：grid = [[2,2,2],[2,1,2],[2,2,2]]
 * 输出3：46
 */
public class T892 {
    /**
     * 官方解法：单独计算每一个 v = grid[i][j] 所贡献的表面积。
     * 再将所有的 v 值相加就能得到最终形体的表面积：
     * 1、顶面和底面表面积：v > 0时，总共贡献 2
     * 2、四侧表面积：只有在相邻位置的高度小于 v 时，对应的侧面才会贡献表面积
     *  贡献数量为 v - nv，nv是相邻位置的高度，可以将其写为 max(v - nv, 0)
     */
    public int surfaceArea(int[][] grid) {
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};

        int N = grid.length;
        int ans = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] > 0) {
                    // 计算顶面和底面
                    ans += 2;
                    // 判断四侧
                    for (int k = 0; k < 4; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        // 初始相邻高度为 0
                        int nv = 0;
                        // 如果相邻坐标存在且存在高度，就给相邻高度赋值
                        if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                            nv = grid[nr][nc];
                        }
                        ans += Math.max(grid[r][c] - nv, 0);
                    }
                }
            }
        }
        return ans;
    }
}
