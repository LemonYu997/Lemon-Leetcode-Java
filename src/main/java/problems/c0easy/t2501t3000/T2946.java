package problems.c0easy.t2501t3000;

/**
 * 2946 循环移位后的矩阵相似检查 https://leetcode.cn/problems/matrix-similarity-after-cyclic-shifts/description/
 * 给你一个下标从 0 开始且大小为 m x n 的整数矩阵 mat 和一个整数 k 。
 * 请你将矩阵中的 奇数 行循环 右 移 k 次，偶数 行循环 左 移 k 次。
 * 如果初始矩阵和最终矩阵完全相同，则返回 true ，否则返回 false 。
 * <p>
 * 示例：
 * 输入1：mat = [[1,2,1,2],[5,5,5,5],[6,3,6,3]], k = 2
 * 输出1：true
 * <p>
 * 输入2：mat = [[2,2],[2,2]], k = 3
 * 输出2：true
 * <p>
 * 输入3：mat = [[1,2]], k = 1
 * 输出3：false
 */
public class T2946 {
    /**
     * 自己实现：根据题意模拟即可
     */
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        k %= n;
        if (k == 0) {
            return true;
        }
        for (int i = 0; i < m; i++) {
            // 当前行为奇数则右移，为偶数则左移
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != mat[i][(j + k) % n]) {
                    return false;
                }
            }
        }
        return true;
    }
}
