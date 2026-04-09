package problems.c0easy.t3001t3500;

import java.util.ArrayList;
import java.util.List;

/**
 * 3417 跳过交替单元格的之字形遍历 https://leetcode.cn/problems/zigzag-grid-traversal-with-skip/description/
 * 给你一个 m x n 的二维数组 grid，数组由 正整数 组成。
 * 你的任务是以 之字形 遍历 grid，同时跳过每个 交替 的单元格。
 * 之字形遍历的定义如下：
 * 从左上角的单元格 (0, 0) 开始。
 * 在当前行中向 右 移动，直到到达该行的末尾。
 * 下移到下一行，然后在该行中向 左 移动，直到到达该行的开头。
 * 继续在行间交替向右和向左移动，直到所有行都被遍历完。
 * 注意：在遍历过程中，必须跳过每个 交替 的单元格。
 * 返回一个整数数组 result，其中包含按 顺序 记录的、且跳过交替单元格后的之字形遍历中访问到的单元格值。
 *
 *
 * 示例：
 * 输入1：grid = [[1,2],[3,4]]
 * 输出1：[1,4]
 *
 * 输入2：grid = [[2,1],[2,1],[2,1]]
 * 输出2：[2,1,2]
 *
 * 输入3：grid = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出3：[1,3,5,7,9]
 */
public class T3417 {
    /**
     * 自己实现：根据题意模拟即可
     */
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> ans = new ArrayList<Integer>();
        int m = grid.length;
        int n = grid[0].length;
        // 先正序再反序
        boolean ok = true;
        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    if (ok) {
                        ans.add(grid[i][j]);
                    }
                    ok = !ok;
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    if (ok) {
                        ans.add(grid[i][j]);
                    }
                    ok = !ok;
                }
            }
        }
        return ans;
    }

    /**
     * 社区解法：前 2k 行一共有 2kn 个数，这必然是偶数。所以 0,2,4,⋯ 行必然是从第一个数开始选的。
     */
    public List<Integer> zigzagTraversal1(int[][] grid) {
        int n = grid[0].length;
        int end = n - 1 - n % 2;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            if (i % 2 > 0) {
                for (int j = end; j >= 0; j -= 2) {
                    ans.add(grid[i][j]);
                }
            } else {
                for (int j = 0; j < n; j += 2) {
                    ans.add(grid[i][j]);
                }
            }
        }
        return ans;
    }
}