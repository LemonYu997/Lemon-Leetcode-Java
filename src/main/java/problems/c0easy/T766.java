package problems.c0easy;

/**
 * 766 托普利茨矩阵 https://leetcode.cn/problems/toeplitz-matrix/
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 * 托普利茨矩阵: 矩阵上每一条由左上到右下的对角线上的元素都相同
 *
 * 示例：
 * 输入1：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * 输出1：true
 * 备注：在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是 True 。
 *
 * 输入2：matrix = [[1,2],[2,2]]
 * 输出2：false
 * 备注：对角线 "[1, 2]" 上的元素不同。
 */
public class T766 {
    /**
     * 自己实现：判断每一行的 0~n-2 和下一行的 1~n-1 是否完全相等
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        //比较每一行和下一行（除了最后一行）
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
