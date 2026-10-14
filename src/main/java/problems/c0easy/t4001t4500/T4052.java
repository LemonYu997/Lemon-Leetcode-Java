package problems.c0easy.t4001t4500;

/**
 * 4052 行列循环移位 https://leetcode.cn/problems/cyclically-shift-rows-and-columns/description/
 * 给你一个整数 n、一个大小为 n x n 的二维整数数组 grid，以及两个长度均为 n 的整数数组 rowShift 和 colShift，其中：
 * rowShift[i] 表示将 grid 的第 i 行向左 循环移位 的位数。
 * colShift[j] 表示将 grid 的第 j 列向上 循环移位 的位数。
 * 首先按照 rowShift 对每一行进行循环移位，然后按照 colShift 对每一列进行循环移位。
 * 返回完成所有移位操作后的网格。
 * 将第 i 行向左 循环移位 k 位时，只移动该行。原本位于第 j 列的元素会移动到第 (j - k + n) % n 列，其余各行保持不变。
 * 将第 j 列向上 循环移位 k 位时，只移动该列。原本位于第 i 行的元素会移动到第 (i - k + n) % n 行，其余各列保持不变.
 *
 * 示例：
 * 输入1： n = 2, grid = [[1,2],[3,4]], rowShift = [1,0], colShift = [0,1]
 * 输出1：[[2,4],[3,1]]
 *
 * 输入2：n = 3, grid = [[1,2,3],[4,5,6],[7,8,9]], rowShift = [1,2,0], colShift = [2,2,1]
 * 输出2：[[7,8,5],[2,3,9],[6,4,1]]
 */
public class T4052 {
    /**
     * 社区解法：根据题意模拟
     */
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        for (int i = 0; i < grid.length; i++) {
            int shift = rowShift[i];
            int[] row = grid[i];
            int[] newRow = new int[n];
            System.arraycopy(row, shift, newRow, 0, n - shift);
            System.arraycopy(row, 0, newRow, n - shift, shift);
            grid[i] = newRow;
        }

        int[] col = new int[n];
        for (int j = 0; j < colShift.length; j++) {
            int shift = colShift[j];
            // 收集列元素
            int k = 0;
            for (int i = shift; i < n; i++) {
                col[k++] = grid[i][j];
            }
            for (int i = 0; i < shift; i++) {
                col[k++] = grid[i][j];
            }
            // 填入列
            for (int i = 0; i < n; i++) {
                grid[i][j] = col[i];
            }
        }

        return grid;
    }

    /**
     * 社区解法：直接计算
     */
    public int[][] cyclicShift1(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int row = (i + colShift[j]) % n;
                int col = (j + rowShift[row]) % n;
                ans[i][j] = grid[row][col];
            }
        }
        return ans;
    }
}
