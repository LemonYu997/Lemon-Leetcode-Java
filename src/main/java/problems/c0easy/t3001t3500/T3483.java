package problems.c0easy.t3001t3500;

import java.util.HashSet;
import java.util.Set;

/**
 * 3483 不同三位偶数的数目 https://leetcode.cn/problems/unique-3-digit-even-numbers/description/
 * 给你一个数字数组 digits，你需要从中选择三个数字组成一个三位偶数，
 * 你的任务是求出 不同 三位偶数的数量。
 * 注意：每个数字在三位偶数中都只能使用 一次 ，并且 不能 有前导零。
 *
 * 示例：
 * 输入1：digits = [1,2,3,4]
 * 输出1：12
 *
 * 输入2：digits = [0,2,2]
 * 输出2：2
 *
 * 输入3：digits = [6,6,6]
 * 输出3：1
 *
 * 输入4：digits = [1,3,5]
 * 输出4：0
 */
public class T3483 {
    /**
     * 社区解法：暴力
     */
    public int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            int a = digits[i];
            if (a % 2 > 0) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    int c = digits[k];
                    if (c == 0 || k == i || k == j) {
                        continue;
                    }
                    set.add(c * 100 + digits[j] * 10 + a);
                }
            }
        }
        return set.size();
    }
}
