package problems.c0easy;

/**
 * 867 转置矩阵 https://leetcode.cn/problems/transpose-matrix/
 * 给定一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 * 示例：
 * 输入1：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出1：[[1,4,7],[2,5,8],[3,6,9]]
 *
 * 输入2：matrix = [[1,2,3],[4,5,6]]
 * 输出2：[[1,4],[2,5],[3,6]]
 */
public class T867 {
    /**
     * 自己实现：根据定义模拟
     */
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] res = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = matrix[i][j];
            }
        }

        return res;
    }
}
