package problems.c0easy.t1001t1500;

/**
 * 1332 删除回文子序列 https://leetcode.cn/problems/remove-palindromic-subsequences/description/
 * 给你一个字符串 s，它仅由字母 'a' 和 'b' 组成。每一次删除操作都可以从 s 中删除一个回文 子序列。
 * 返回删除给定字符串中所有字符（字符串为空）的最小删除次数。
 * 「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，
 * 那么这个字符串就是原字符串的一个子序列。
 * 「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。
 *
 * 示例：
 * 输入1：s = "ababa"
 * 输出1：1
 *
 * 输入2：s = "abb"
 * 输出2：2
 *
 * 输入3：s = "baabb"
 * 输出3：2
 */
public class T1332 {
    /**
     * 官方解法：不一定非要删除连续子序列，因为只包含 a 和 b
     * 所以最多两次，一次全 a 一次全 b
     * 因此只用判断是否为回文子序列，是的话只删除 1 次
     */
    public int removePalindromeSub(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // 判断 s 是否为回文字符串
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return 2;
            }
        }
        return 1;
    }
}
