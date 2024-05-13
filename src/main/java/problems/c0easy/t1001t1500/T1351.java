package problems.c0easy.t1001t1500;

/**
 * 1351 统计有序矩阵中的负数 https://leetcode.cn/problems/count-negative-numbers-in-a-sorted-matrix/description/
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，
 * 都以非严格递减顺序排列。 请你统计并返回 grid 中 负数 的数目。
 *
 * 示例：
 * 输入1：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出1：8
 *
 * 输入2：grid = [[3,2],[1,0]]
 * 输出2：0
 */
public class T1351 {
    /**
     * 自己实现：按行遍历，遇到负数就停止
     */
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0) {
                    ans += n - j;
                    break;
                }
            }
        }

        return ans;
    }

    /**
     * 官方解法：二分查找
     */
    public int countNegatives1(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        // 按行遍历
        for (int i = 0; i < m; i++) {
            int[] row = grid[i];
            // 整行都不是负数，直接跳过
            if (row[n - 1] >= 0) {
                continue;
            }
            // 整行都是负数，全部统计，后边的行也可以计入
            if (row[0] < 0) {
                ans += (m - i) * n;
                break;
            }
            // 当前行二分查找第一个小于 0 的数的索引
            int first = binarySearch(row);
            ans += n - first;
        }
        return ans;
    }

    /**
     * 查找第一个小于 0 的数的索引
     */
    private int binarySearch(int[] row) {
        int begin = 0;
        int end = row.length;
        while (begin < end) {
            int mid = begin + ((end - begin) / 2);
            if (row[mid] >= 0) {
                begin = mid + 1;
            } else {
                // 负数之后，还要再判断前一个不是负数
                if (row[mid - 1] >= 0) {
                    return mid;
                }
                end = mid;
            }
        }
        return begin;
    }

}
