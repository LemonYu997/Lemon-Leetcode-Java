package problems.c0easy.t3501t4000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 3697 计算十进制表示 https://leetcode.cn/problems/compute-decimal-representation/description/
 * 给你一个 正整数 n。
 * 如果一个正整数可以表示为 1 到 9 的单个数字和 10 的非负整数次幂的乘积，
 * 则称这个整数是一个 10 进制分量。例如，500、30 和 7 是 10 进制分量 ，而 537、102 和 11 则不是。
 * 请将 n 表示为若干 仅由 10 进制分量组成的和，且使用的 10 进制分量个数 最少 。
 * 返回一个包含这些 10 进制分量 的数组，并按分量大小 降序 排列。
 *
 * 示例：
 * 输入1：n = 537
 * 输出1：[500,30,7]
 *
 * 输入2：n = 102
 * 输出2：[100,2]
 *
 * 输入3：n = 6
 * 输出3：[6]
 */
public class T3697 {
    /**
     * 自己实现：根据题意模拟
     */
    public int[] decimalRepresentation(int n) {
        String num = String.valueOf(n);
        int len = num.length();
        int[] temp = new int[len];
        int countO = 0;
        for (int i = 0; i < len; i++) {
            temp[i] = (int) ((num.charAt(i) - '0') * Math.pow(10, len - i - 1));
            // 记录0的数
            if (temp[i] == 0) {
                countO++;
            }
        }
        int[] ans = new int[len - countO];
        int i = 0;
        // 去除 0
        for (int t : temp) {
            if (t != 0) {
                ans[i++] = t;
            }
        }

        return ans;
    }


    /**
     * 社区解法：优化写法
     */
    public int[] decimalRepresentation1(int n) {
        // 使用 list
        List<Integer> a = new ArrayList<>();
        int pow10 = 1;
        for (; n > 0; n /= 10) {
            int d = n % 10;
            // 只保留不为 0 的数
            if (d > 0) {
                a.add(d * pow10);
            }
            pow10 *= 10;
        }
        // 翻转
        Collections.reverse(a);

        int[] ans = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            ans[i] = a.get(i);
        }
        return ans;
    }
}
