package problems.c0easy.t1t500;

import java.util.ArrayList;
import java.util.List;

/**
 * 118 杨辉三角 https://leetcode.cn/problems/pascals-triangle/
 * 给定一个非负整数numRows，生成杨辉三角的前 numRows行
 *
 * 示例：
 * 输入1：numRows = 5
 * 输出1：[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * 输入2：numRows = 5
 * 输出2：[[1]]
 */
public class T118 {
    /**
     * 官方解法1：数学计算
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                //每一行的头尾都是1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }

            ret.add(row);
        }

        return ret;
    }
}
