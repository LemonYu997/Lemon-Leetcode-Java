package problems.c0easy.t1001t1500;

/**
 * 1304 和为零的 N 个不同整数 https://leetcode.cn/problems/find-n-unique-integers-sum-up-to-zero/description/
 * 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，
 * 并且这 n 个数相加和为 0 。
 *
 * 示例：
 * 输入1：n = 5
 * 输出1：[-7,-1,1,3,4]
 *
 * 输入2：n = 3
 * 输出2：[-1,0,1]
 *
 * 输入3：n = 1
 * 输出3：[0]
 */
public class T1304 {
    /**
     * 自己实现：如果 n 是奇数，就 0, +1, -1, +2, -2 ...
     * 如果 n 是偶数，就 +1, -1, +2, -2 ...
     */
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int j = 0;  // 索引
        // 如果为奇数 初始为 0
        if (n % 2 == 1) {
            // 赋值完后自动向后推一位
            ans[j++] = 0;
        }
        for (int i = 1; i <= n / 2; i++) {
            ans[j++] = i;
            ans[j++] = -i;
        }

        return ans;
    }
}
