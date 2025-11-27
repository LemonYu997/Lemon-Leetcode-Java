package problems.c0easy.t2501t3000;

/**
 * 2965 找出缺失和重复的数字 https://leetcode.cn/problems/find-missing-and-repeated-values/description/
 * 给你一个下标从 0 开始的二维整数矩阵 grid，大小为 n * n ，其中的值在 [1, n2] 范围内。
 * 除了 a 出现 两次，b 缺失 之外，每个整数都 恰好出现一次 。
 * 任务是找出重复的数字a 和缺失的数字 b 。
 * 返回一个下标从 0 开始、长度为 2 的整数数组 ans ，其中 ans[0] 等于 a ，ans[1] 等于 b 。
 *
 * 示例：
 * 输入1：grid = [[1,3],[2,2]]
 * 输出1：[2,4]
 *
 * 输入2：grid = [[9,1,7],[8,9,2],[3,4,6]]
 * 输出2：[9,5]
 */
public class T2965 {
    /**
     * 自己实现：根据题意模拟即可
     */
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];
        int n = grid.length;
        int[] temp = new int[n * n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int now = grid[i][j];
                if (temp[now] == 1) {
                    ans[0] = now;
                }
                temp[now] = 1;
            }
        }

        int m = temp.length;
        for (int i = 1; i < m; i++) {
            if (temp[i] == 0) {
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}
