package problems.c0easy.t2501t3000;

/**
 * 2639 查询网格图中每一列的宽度 https://leetcode.cn/problems/find-the-width-of-columns-of-a-grid/description/
 * 给你一个下标从 0 开始的 m x n 整数矩阵 grid 。
 * 矩阵中某一列的宽度是这一列数字的最大 字符串长度 。
 * 比方说，如果 grid = [[-10], [3], [12]] ，
 * 那么唯一一列的宽度是 3 ，因为 -10 的字符串长度为 3 。
 * 请你返回一个大小为 n 的整数数组 ans ，其中 ans[i] 是第 i 列的宽度。
 * 一个有 len 个数位的整数 x ，如果是非负数，那么 字符串长度 为 len ，否则为 len + 1 。
 *
 * 示例：
 * 输入1：grid = [[1],[22],[333]]
 * 输出1：[3]
 *
 * 输入2：grid = [[-15,1,3],[15,7,12],[5,6,-2]]
 * 输出2：[3,1,2]
 */
public class T2639 {
    /**
     * 自己实现：根据题意模拟
     */
    public int[] findColumnWidth(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] ans = new int[m];

        for (int j = 0; j < m; j++) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                int num = grid[i][j];
                int len = 0;
                if (num <= 0) {
                    len++;
                }
                while (num != 0) {
                    num /= 10;
                    len++;
                }
                max = Math.max(max, len);
            }
            ans[j] = max;
        }

        return ans;
    }
}
