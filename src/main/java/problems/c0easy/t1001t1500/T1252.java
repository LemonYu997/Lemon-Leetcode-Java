package problems.c0easy.t1001t1500;

/**
 * 1252 奇数值单元格的数目 https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix/description/
 * 给你一个 m x n 的矩阵，最开始的时候，每个单元格中的值都是 0。
 * 另有一个二维索引数组 indices，indices[i] = [ri, ci] 指向矩阵中的某个位置，
 * 其中 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 * 对 indices[i] 所指向的每个位置，应同时执行下述增量操作：
 * ri 行上的所有单元格，加 1 。
 * ci 列上的所有单元格，加 1 。
 * 给你 m、n 和 indices 。请你在执行完所有 indices 指定的增量操作后，
 * 返回矩阵中 奇数值单元格 的数目。
 *
 * 示例：
 * 输入1：m = 2, n = 3, indices = [[0,1],[1,1]]
 * 输出1：6
 *
 * 输入2：m = 2, n = 2, indices = [[1,1],[0,0]]
 * 输出2：0
 */
public class T1252 {
    /**
     * 自己实现：根据题意模拟
     */
    public int oddCells(int m, int n, int[][] indices) {
        // 先生成对应矩阵
        int[][] arr = new int[m][n];

        int x = indices.length;
        int y = indices[0].length;

        for (int[] index : indices) {
            // ri 行上的所有单元格，加 1
            for (int i = 0; i < n; i++) {
                arr[index[0]][i]++;
            }
            // ci 列上的所有单元格，加 1
            for (int i = 0; i < m; i++) {
                arr[i][index[1]]++;
            }
        }

        // 统计 arr 中有多少个奇数
        int ans = 0;
        for (int[] nums : arr) {
            for (int num : nums) {
                if (num % 2 != 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 官方解法：优化实现
     * 空间优化：使用一维数组存储每行每列的 ++ 次数
     */
    public int oddCells1(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (((rows[i] + cols[j]) & 1) != 0) {
                    res++;
                }
            }
        }
        return res;
    }
}