package problems.c0easy.t2001t2500;

/**
 * 2269 找到一个数字的 K 美丽值 https://leetcode.cn/problems/find-the-k-beauty-of-a-number/
 * 一个整数 num 的 k 美丽值定义为 num 中符合以下条件的 子字符串 数目：
 *
 * 子字符串长度为 k 。
 * 子字符串能整除 num 。
 * 给你整数 num 和 k ，请你返回 num 的 k 美丽值。
 *
 * 注意：
 *
 * 允许有 前缀 0 。
 * 0 不能整除任何值。
 * 一个 子字符串 是一个字符串里的连续一段字符序列。
 *
 * 示例：
 * 输入1：num = 240, k = 2
 * 输出1：2
 *
 * 输入2：num = 430043, k = 2
 * 输出2：2
 */
public class T2269 {
    /**
     * 自己实现：遍历即可
     */
    public int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        int ans = 0;
        int n = s.length();

        for (int i = 0; i + k <= n; i++) {
            int temp = Integer.parseInt(s.substring(i, i + k));
            if (temp != 0 && num % temp == 0) {
                ans++;
            }
        }

        return ans;
    }
}
