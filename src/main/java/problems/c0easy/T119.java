package problems.c0easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 119 杨辉三角2 https://leetcode.cn/problems/pascals-triangle-ii/
 * 给定一个非负索引rowIndex，返回杨辉三角的第rowIndex行
 * <p>
 * 示例：
 * 输入1：rowIndex = 3
 * 输出1：[1,3,3,1]
 * <p>
 * 输入2：rowIndex = 0
 * 输出2：[1]
 * <p>
 * 输入3：rowIndex = 1
 * 输出3：[1,1]
 */
public class T119 {
    /**
     * 官方解法1：递推
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add(0);
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }

        return row;
    }
}
