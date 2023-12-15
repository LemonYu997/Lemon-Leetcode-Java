package problems.c0easy;

/**
 * 521 最长特殊序列I https://leetcode.cn/problems/longest-uncommon-subsequence-i/
 * 给定两个字符串a和b，返回a和b的最长特殊序列的长度。如果不存在，返回-1
 * 最长特殊序列：某字符串独有的最长子序列（不能是其他字符串的子序列）
 *
 * 示例：
 * 输入1：a = "aba", b = "cdc"
 * 输出1:3
 *
 * 输入2：a = "aaa", b = "bbb"
 * 输出2:3
 *
 * 输入3：a = "aaa", b = "aaa"
 * 输出3：-1
 */
public class T521 {
    /**
     * 官方解法：
     * 不相等的字符串就取长的那一个
     * 相等就返回-1
     */
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
