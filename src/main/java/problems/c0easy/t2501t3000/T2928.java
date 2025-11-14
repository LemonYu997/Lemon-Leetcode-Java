package problems.c0easy.t2501t3000;

import java.util.Map;

/**
 * 2928 给小朋友们分糖果 I https://leetcode.cn/problems/distribute-candies-among-children-i/description/
 * 给你两个正整数 n 和 limit 。
 * 请你将 n 颗糖果分给 3 位小朋友，确保没有任何小朋友得到超过 limit 颗糖果，
 * 请你返回满足此条件下的 总方案数 。
 *
 * 示例：
 * 输入1：n = 5, limit = 2
 * 输出1：3
 *
 * 输入2：n = 3, limit = 3
 * 输出2：10
 */
public class T2928 {
    /**
     * 自己实现：根据题意遍历即可
     */
    public int distributeCandies(int n, int limit) {
        int ans = 0;

        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                if (i + j > n) {
                    break;
                }
                if (n - i - j <= limit) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 官方解法：优化遍历
     */
    public int distributeCandies1(int n, int limit) {
        int ans = 0;
        for (int i = 0; i <= Math.min(limit, n); i++) {
            if (n - i > 2 * limit) {
                continue;
            }
            ans += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
        }
        return ans;
    }
}