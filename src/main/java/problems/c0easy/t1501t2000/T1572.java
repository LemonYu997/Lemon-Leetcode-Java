package problems.c0easy.t1501t2000;

/**
 * 1572 矩阵对角线元素的和 https://leetcode.cn/problems/matrix-diagonal-sum/description/
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 *
 * 示例：
 * 输入1：mat = [[1,2,3],
 *             [4,5,6],
 *             [7,8,9]]
 * 输出1:25
 *
 * 输入2：mat = [[1,1,1,1],
 *             [1,1,1,1],
 *             [1,1,1,1],
 *             [1,1,1,1]]
 * 输出2:8
 *
 * 输入3：mat = [[5]]
 * 输出3:8
 */
public class T1572 {
    /**
     * 自己实现：根据题意模拟，遍历整个矩阵
     */
    public int diagonalSum(int[][] mat) {
        int ans = 0;
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) {
                    ans += mat[i][j];
                }
            }
        }
        return ans;
    }

    /**
     * 官方解法：只遍历对角线元素
     */
    public int diagonalSum1(int[][] mat) {
        int n = mat.length;
        int ans = 0;
        int mid = n / 2;

        for (int i = 0; i < n; i++) {
            ans += mat[i][i] + mat[i][n - 1 - i];
        }

        // 如果 n 为奇数，则会重复计算交点
        if (n % 2 == 1) {
            ans -= mat[mid][mid];
        }
        return ans;
    }
}
