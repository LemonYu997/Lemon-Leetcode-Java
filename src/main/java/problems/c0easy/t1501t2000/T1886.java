package problems.c0easy.t1501t2000;

/**
 * 1886 判断矩阵经轮转后是否一致 https://leetcode.cn/problems/determine-whether-matrix-can-be-obtained-by-rotation/description/
 * 给你两个大小为 n x n 的二进制矩阵 mat 和 target 。
 * 现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，
 * 如果能够使 mat 与 target 一致，返回 true ；否则，返回 false 。
 *
 * 示例：
 * 输入1：mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
 * 输出1：true
 *
 * 输入2：mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
 * 输出2：false
 *
 * 输入3：mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
 * 输出3：true
 */
public class T1886 {
    /**
     * 官方解法：最多只能旋转4次，可以不断旋转去比较每种可能性
     */
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean b1 = true;
        boolean b2 = true;
        boolean b3 = true;
        boolean b4 = true;

        // 进行旋转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 旋转 90 度
                if (mat[j][n - i - 1] != target[i][j]) {
                    b1 = false;
                }
                // 旋转 180 度
                if (mat[n - i - 1][n - j - 1] != target[i][j]) {
                    b2 = false;
                }
                // 旋转 270 度
                if (mat[n - j - 1][i] != target[i][j]) {
                    b3 = false;
                }
                // 旋转 360 度
                if (mat[i][j] != target[i][j]) {
                    b4 = false;
                }
            }
        }

        return b1 || b2 || b3 || b4;
    }
}
