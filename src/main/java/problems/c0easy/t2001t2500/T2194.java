package problems.c0easy.t2001t2500;

import java.util.ArrayList;
import java.util.List;

/**
 * 2194 Excel 表中某个范围内的单元格 https://leetcode.cn/problems/cells-in-a-range-on-an-excel-sheet/description/
 * Excel 表中的一个单元格 (r, c) 会以字符串 "<col><row>" 的形式进行表示，其中：
 * <col> 即单元格的列号 c 。用英文字母表中的 字母 标识。
 * 例如，第 1 列用 'A' 表示，第 2 列用 'B' 表示，第 3 列用 'C' 表示，以此类推。
 * <row> 即单元格的行号 r 。第 r 行就用 整数 r 标识。
 * 给你一个格式为 "<col1><row1>:<col2><row2>" 的字符串 s ，
 * 其中 <col1> 表示 c1 列，<row1> 表示 r1 行，<col2> 表示 c2 列，<row2> 表示 r2 行，并满足 r1 <= r2 且 c1 <= c2 。
 * 找出所有满足 r1 <= x <= r2 且 c1 <= y <= c2 的单元格，并以列表形式返回。
 * 单元格应该按前面描述的格式用 字符串 表示，并以 非递减 顺序排列（先按列排，再按行排）。
 *
 * 示例：
 * 输入1：s = "K1:L2"
 * 输出1：["K1","K2","L1","L2"]
 *
 * 输入2：s = "A1:F1"
 * 输出2：["A1","B1","C1","D1","E1","F1"]
 */
public class T2194 {
    /**
     * 根据题意模拟：计算所需要输出的矩阵数
     */
    public List<String> cellsInRange(String s) {
        // 列的起始位和终止位
        char colL = s.charAt(0);
        char colR = s.charAt(3);
        // 行的起始位和终止位
        char rowL = s.charAt(1);
        char rowR = s.charAt(4);

        // 计算所需要的数量
        int m = colR - colL + 1;
        int n = rowR - rowL + 1;

        List<String> ans = new ArrayList<>();
        // 用来存储两个新字符，方便组成字符串
        char[] temp = new char[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[0] = (char) (colL + i);
                temp[1] = (char) (rowL + j);

                ans.add(String.copyValueOf(temp));
            }
        }

        return ans;
    }
}
