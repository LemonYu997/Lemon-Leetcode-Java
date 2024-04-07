package problems.c0easy.t501t1000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 989 数组形式的整数加法 https://leetcode.cn/problems/add-to-array-form-of-integer/
 * 整数的数组形式 num 是按照从左到右的顺序表示其数字的数组。
 * 对于 num = 1321 ，数组形式是 [1,3,2,1]
 * 给定 num ，整数的 数组形式 ，和整数 k ，返回 整数 num + k 的 数组形式 。
 *
 * 示例：
 * 输入1：num = [1,2,0,0], k = 34
 * 输出1：[1,2,3,4]
 * 备注：1200 + 34 = 1234
 *
 * 输入2：num = [2,7,4], k = 181
 * 输出2：[4,5,5]
 *
 * 输入3：num = [2,1,5], k = 806
 * 输出3：[1,0,2,1]
 */
public class T989 {
    /**
     * 自己实现：模拟数列式加法
     */
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        // 倒序遍历数组每一位，和 k 的每一位相加
        for (int i = num.length - 1; i >= 0; i--) {
            // 得到 k 的当前位
            int n = k % 10;
            // k 移动到下一位
            k /= 10;
            // 如果 num[i] + n 大于等于 10，需要进位
            if (num[i] + n >= 10) {
                num[i] = num[i] + n - 10;
                // 记录进位
                k++;
            } else {
                num[i] = num[i] + n;
            }

            ans.add(num[i]);
        }
        // 如果 k 没加完，补上
        while (k > 0) {
            ans.add(k % 10);
            k /= 10;
        }

        // 反转
        Collections.reverse(ans);
        return ans;
    }
}
