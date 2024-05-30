package problems.c0easy.t1001t1500;

import java.util.ArrayList;
import java.util.List;

/**
 * 1380 矩阵中的幸运数 https://leetcode.cn/problems/lucky-numbers-in-a-matrix/description/
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。
 * 请你按 任意 顺序返回矩阵中的所有幸运数。
 * 幸运数 是指矩阵中满足同时下列两个条件的元素：
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 *
 * 示例：
 * 输入1：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * 输出1：[15]
 *
 * 输入2：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * 输出2：[12]
 *
 * 输入3：matrix = [[7,8],[1,2]]
 * 输出3：[7]
 */
public class T1380 {
    /**
     * 自己实现：先找到每行最小的数，再判断其是否为该列最大数，是的话加入结果
     */
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> ans = new ArrayList<>();

        // 遍历每一行找到最小值
        for (int i = 0; i < m; i++) {
            int num = Integer.MAX_VALUE;
            int raw = 0;  // 记录那一列
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < num) {
                    num = matrix[i][j];
                    raw = j;
                }
            }
            // 在判断是否为当前列的最大值
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (matrix[j][raw] > num) {
                    flag = false;
                    break;
                }
            }
            // 如果该数为当前行的最小值且为当前列的最大值
            if (flag) {
               ans.add(num);
            }
        }
        return ans;
    }
}
