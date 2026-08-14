package problems.c0easy.t3501t4000;

/**
 * 3898 统计每个顶点的度 https://leetcode.cn/problems/find-the-degree-of-each-vertex/description/
 * 给你一个大小为 n x n 的二维整数数组 matrix，以邻接矩阵形式表示一个 无向图。该图包含 n 个顶点，编号从 0 到 n - 1。
 * matrix[i][j] = 1 表示顶点 i 与顶点 j 之间存在一条边。
 * matrix[i][j] = 0 表示顶点 i 与顶点 j 之间不存在边。
 * 顶点的 度（degree）定义为与该顶点相连的边的数量。
 * 请返回一个长度为 n 的整数数组 ans，其中 ans[i] 表示顶点 i 的度。
 *
 * 示例：
 * 输入1：matrix = [[0,1,1],[1,0,1],[1,1,0]]
 * 输出1：[2,2,2]
 *
 * 输入2：matrix = [[0,1,0],[1,0,0],[0,0,0]]
 * 输出2：[1,1,0]
 *
 * 输入3：matrix = [[0]]
 * 输出3：[0]
 */
public class T3898 {
    /**
     * 社区解法：统计矩阵每一行的 1 的个数即可。
     */
    public int[] findDegrees(int[][] matrix) {
        int[] ans = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int x : matrix[i]) {
                ans[i] += x;
            }
        }
        return ans;
    }
}
