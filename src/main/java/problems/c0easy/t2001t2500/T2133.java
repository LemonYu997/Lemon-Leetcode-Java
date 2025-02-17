package problems.c0easy.t2001t2500;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2133 检查是否每一行每一列都包含全部整数 https://leetcode.cn/problems/check-if-every-row-and-column-contains-all-numbers/description/
 * 对一个大小为 n x n 的矩阵而言，如果其每一行和每一列都包含从 1 到 n 的 全部 整数（含 1 和 n），则认为该矩阵是一个 有效 矩阵。
 *
 * 给你一个大小为 n x n 的整数矩阵 matrix ，请你判断矩阵是否为一个有效矩阵：如果是，返回 true ；否则，返回 false 。
 *
 * 示例：
 * 输入1：matrix = [[1,2,3],[3,1,2],[2,3,1]]
 * 输出1：true
 *
 * 输入2：matrix = [[1,1,1],[1,2,3],[1,2,3]]
 * 输出2：false
 */
public class T2133 {
    /**
     * 官方解法：哈希表
     */
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        // 比较横轴
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                set.add(matrix[i][j]);
            }
            if (set.size() < n) {
                return false;
            }
        }

        // 比较纵轴
        for (int j = 0; j < n; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(matrix[i][j]);
            }
            if (set.size() < n) {
                return false;
            }
        }

        return true;
    }

    /**
     * 优化解法：一次遍历
     */
    public boolean checkValid1(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            Set<Integer> setRow = new HashSet<>();
            Set<Integer> setCol = new HashSet<>();

            for (int j = 0; j < n; j++) {
                // 如果出现重复即错误
                if (!setRow.add(matrix[i][j]) || !setCol.add(matrix[j][i])) {
                    return false;
                }
            }
        }

        return true;
    }
}