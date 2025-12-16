package problems.c0easy.t3001t3500;

/**
 * 3033 修改矩阵 https://leetcode.cn/problems/modify-the-matrix/description/
 * 给你一个下标从 0 开始、大小为 m x n 的整数矩阵 matrix ，新建一个下标从 0 开始、
 * 名为 answer 的矩阵。使 answer 与 matrix 相等，接着将其中每个值为 -1 的元素替换为所在列的 最大 元素。
 * 返回矩阵 answer 。
 *
 * 示例：
 * 输入1：matrix = [[1,2,-1],[4,-1,6],[7,8,9]]
 * 输出1：[[1,2,9],[4,8,6],[7,8,9]]
 *
 * 输入2：matrix = [[3,-1],[5,2]]
 * 输出2：[[3,2],[5,2]]
 */
public class T3033 {
    /**
     * 自己实现：根据题意模拟
     */
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 先找出每列最大元素
        int[] max = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max[j] = Math.max(max[j], matrix[i][j]);
            }
        }

        // 替换每个-1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = max[j];
                }
            }
        }

        return matrix;
    }

    /**
     * 官方解法：优化写法
     */
    public int[][] modifiedMatrix1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int j = 0; j < n; j++) {
            int max = -1;
            for (int i = 0; i < m; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = max;
                }
            }
        }

        return matrix;
    }
}