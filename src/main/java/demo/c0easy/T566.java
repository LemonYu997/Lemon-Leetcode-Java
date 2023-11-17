package demo.c0easy;

/**
 * 566 重塑矩阵 https://leetcode.cn/problems/reshape-the-matrix/
 * 在Matlab中，有一个非常有用的函数reshape，可以将一个m x n矩阵重塑为另一个大小不同的r x c矩阵，但保留其原始数据
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 * 判断给定参数是否合理，合理时输出新的矩阵，否则输出原始矩阵
 *
 * 示例：
 * 输入1：mat = [[1,2],[3,4]], r = 1, c = 4
 * 输出1：[[1,2,3,4]]
 *
 * 输入2：mat = [[1,2],[3,4]], r = 2, c = 4
 * 输出2：[[1,2],[3,4]]
 */
public class T566 {
    /**
     * 自己实现：先将原矩阵放入一个一维数组中去，再重新赋值
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        //先判断是否合理
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }

        //存放结果
        int[][] ans = new int[r][c];
        //存放临时数据
        int[] temp = new int[m * n];
        int count1 = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[count1++] = mat[i][j];
            }
        }

        int count2 = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = temp[count2++];
            }
        }

        return ans;
    }

    /**
     * 官方解法：直接赋值
     */
    public int[][] matrixReshape1(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }

        int[][] ans = new int[r][c];
        for (int i = 0; i < m * n; i++) {
            ans[i / c][i % c] = mat[i / n][i % n];
        }

        return ans;
    }
}
