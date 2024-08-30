package problems.c0easy.t1501t2000;

/**
 * 1582 二进制矩阵中的特殊位置 https://leetcode.cn/problems/special-positions-in-a-binary-matrix/description/
 * 给定一个 m x n 的二进制矩阵 mat，返回矩阵 mat 中特殊位置的数量。
 * 如果位置 (i, j) 满足 mat[i][j] == 1 并且行 i 与列 j 中的所有其他元素都是 0
 * （行和列的下标从 0 开始计数），那么它被称为 特殊 位置。
 *
 * 示例：
 * 输入1：mat = [[1,0,0],[0,0,1],[1,0,0]]
 * 输出1：1
 *
 * 输入2：mat = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出2：3
 */
public class T1582 {
    /**
     * 自己实现：根据题意暴力遍历
     * 如果 mat[i][j] == 1，则遍历行和列是否为 0
     */
    public int numSpecial(int[][] mat) {
        int ans = 0;
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果当前位置为 1
                if (mat[i][j] == 1) {
                    boolean flag = true;
                    // 遍历一整列 除自己以外必须是 0
                    for (int k = 0; k < m; k++) {
                        if (mat[k][j] != 0 && k != i) {
                            flag = false;
                            break;
                        }
                    }
                    // 遍历一整行 除自己以外必须是 0
                    for (int k = 0; k < n; k++) {
                        if (mat[i][k] != 0 && k != j) {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    /**
     * 官方解法：预处理每一行和每一列的和得到其中为 1 的个数
     */
    public int numSpecial1(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rowSum = new int[m];
        int[] colSum = new int[n];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 当前值为1 且 列的和 和 行的和 都为1
                if (mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
