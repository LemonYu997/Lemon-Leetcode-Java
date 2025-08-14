package problems.c0easy.t2501t3000;

/**
 * 2643 一最多的行 https://leetcode.cn/problems/row-with-maximum-ones/description/
 * 给你一个大小为 m x n 的二进制矩阵 mat ，
 * 请你找出包含最多 1 的行的下标（从 0 开始）以及这一行中 1 的数目。
 * 如果有多行包含最多的 1 ，只需要选择 行下标最小 的那一行。
 * 返回一个由行下标和该行中 1 的数量组成的数组。
 *
 * 示例：
 * 输入1：mat = [[0,1],[1,0]]
 * 输出1：[0,1]
 *
 * 输入2：mat = [[0,0,0],[0,1,1]]
 * 输出2：[1,2]
 *
 * 输入3：mat = [[0,0],[1,1],[0,0]]
 * 输出3：[1,2]
 */
public class T2643 {
    /**
     * 自己实现：根据题意模拟
     */
    public int[] rowAndMaximumOnes(int[][] mat) {
        int max = 0;
        int maxIndex = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            // 当前行 1 的数量
            int temp = 0;
            for (int num : mat[i]) {
                if (num == 1) {
                    temp++;
                }
            }
            if (temp > max) {
                max = temp;
                maxIndex = i;
            }
        }

        return new int[]{maxIndex, max};
    }
}
