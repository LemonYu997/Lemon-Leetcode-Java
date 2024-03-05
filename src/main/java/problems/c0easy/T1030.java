package problems.c0easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 1030 距离顺序排列矩阵单元格 https://leetcode.cn/problems/matrix-cells-in-distance-order/description/
 * 给定四个整数 rows , cols , rCenter 和 cCenter 。
 * 有一个 rows x cols 的矩阵，你在单元格上的坐标是 (rCenter, cCenter) 。
 * 返回矩阵中的所有单元格的坐标，并按与 (rCenter, cCenter) 的 距离 从最小到最大的顺序排。
 * 你可以按 任何 满足此条件的顺序返回答案。
 * 单元格(r1, c1) 和 (r2, c2) 之间的距离为|r1 - r2| + |c1 - c2|。
 *
 * 示例：
 * 输入1：rows = 1, cols = 2, rCenter = 0, cCenter = 0
 * 输出1：[[0,0],[0,1]]
 *
 * 输入2：rows = 2, cols = 2, rCenter = 0, cCenter = 1
 * 输出2：[[0,1],[0,0],[1,1],[1,0]]
 *
 * 输入3：rows = 2, cols = 3, rCenter = 1, cCenter = 2
 * 输出3：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 */
public class T1030 {
    /**
     * 官方解法：直接排序
     */
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] ans = new int[rows * cols][];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans[i * cols + j] = new int[]{i, j};
            }
        }
        Arrays.sort(ans, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return (Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter))
                        - (Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter));
            }
        });

        return ans;
    }

    /**
     * 官方解法2：桶排序
     */
    public int[][] allCellsDistOrder1(int rows, int cols, int rCenter, int cCenter) {
        int maxDist = Math.max(rCenter, rows - 1 - rCenter) + Math.max(cCenter, cols - 1 - cCenter);
        List<List<int[]>> bucket = new ArrayList<>();
        for (int i = 0; i <= maxDist; i++) {
            bucket.add(new ArrayList<>());
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int d = dist(i, j, rCenter, cCenter);
                bucket.get(d).add(new int[]{i, j});
            }
        }

        int[][] ans = new int[rows * cols][];
        int index = 0;
        for (int i = 0; i <= maxDist; i++) {
            for (int[] it : bucket.get(i)) {
                ans[index++] = it;
            }
        }
        return ans;
    }

    public int dist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    /**
     * 官方解法3：几何法
     */
    int[] dr = {1, 1, -1, -1};
    int[] dc = {1, -1, -1, 1};
    public int[][] allCellsDistOrder2(int rows, int cols, int rCenter, int cCenter) {
        int maxDist = Math.max(rCenter, rows - 1 - rCenter) + Math.max(cCenter, cols - 1 - cCenter);
        int[][] ans = new int[rows * cols][];
        int row = rCenter;
        int col = cCenter;
        int index = 0;
        ans[index++] = new int[]{row, col};
        for (int dist = 1; dist <= maxDist; dist++) {
            row--;
            for (int i = 0; i < 4; i++) {
                while ((i % 2 == 0 && row != rCenter) || (i % 2 != 0 && col != cCenter)) {
                    if (row >= 0 && row < rows && col >= 0 && col < cols) {
                        ans[index++] = new int[]{row, col};
                    }
                    row += dr[i];
                    col += dc[i];
                }
            }
        }
        return ans;
    }
}
