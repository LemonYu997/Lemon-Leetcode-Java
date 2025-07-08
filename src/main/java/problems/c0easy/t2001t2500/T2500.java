package problems.c0easy.t2001t2500;

import java.util.Arrays;

/**
 * 2500 删除每行中的最大值 https://leetcode.cn/problems/delete-greatest-value-in-each-row/description/
 * 给你一个 m x n 大小的矩阵 grid ，由若干正整数组成。
 *
 * 执行下述操作，直到 grid 变为空矩阵：
 *
 * 从每一行删除值最大的元素。如果存在多个这样的值，删除其中任何一个。
 * 将删除元素中的最大值与答案相加。
 * 注意 每执行一次操作，矩阵中列的数据就会减 1 。
 *
 * 返回执行上述操作后的答案。
 *
 * 示例：
 * 输入1：grid = [[1,2,4],[3,3,1]]
 * 输出1：8
 *
 * 输入2：grid = [[10]]
 * 输出2：10
 */
public class T2500 {
    /**
     * 自己实现：先排序后计算
     */
    public int deleteGreatestValue(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        // 先排序
        for (int[] ints : grid) {
            Arrays.sort(ints);
        }

        // 计算每列的最大值
        for (int i = 0; i < n; i++) {
            int temp = grid[0][i];
            for (int j = 1; j < m; j++) {
                temp = Math.max(temp, grid[j][i]);
            }
            ans += temp;
        }

        return ans;
    }
}
