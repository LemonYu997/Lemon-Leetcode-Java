package problems.c0easy.t3501t4000;

import java.util.Arrays;

/**
 * 3963 构造恰好一条路径的网格 https://leetcode.cn/problems/create-grid-with-exactly-one-path/description/
 *
 * 给你两个整数 m 和 n，分别表示网格的行数和列数。
 * 请你构造 任意 一个只包含字符 '.' 和 '#' 的 m x n 网格，其中：
 * '.' 表示空单元格。
 * '#' 表示障碍物单元格。
 * 有效路径 是满足以下条件的空单元格序列：
 * 从左上角单元格 (0, 0) 开始。
 * 在右下角单元格 (m - 1, n - 1) 结束。
 * 只能向：
 * 右移动，从 (i, j) 到 (i, j + 1)，或者
 * 下移动，从 (i, j) 到 (i + 1, j)。
 * 返回任意一个从左上角到右下角 恰好只有一条有效路径 的网格。
 *
 * 示例：
 * 输入1：m = 2, n = 3
 * 输出1：["..#","#.."]
 *
 * 输入2：m = 3, n = 3
 * 输出2：["..#","#..","##."]
 *
 * 输入3：m = 1, n = 4
 * 输出3：["...."]
 */
public class T3963 {
    /**
     * 社区解法：根据题意构造
     */
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        char[] firstRow = new char[n];
        Arrays.fill(firstRow, '.');
        ans[0] = new String(firstRow);

        char[] rowChars = new char[n];
        Arrays.fill(rowChars, '#');
        rowChars[n - 1] = '.';
        String row = new String(rowChars);

        for (int i = 1; i < m; i++) {
            ans[i] = row;
        }
        return ans;
    }
}
