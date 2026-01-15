package problems.c0easy.t3001t3500;

/**
 * 3146 两个字符串的排列差两个字符串的排列差 https://leetcode.cn/problems/permutation-difference-between-two-strings/description/
 * 给你两个字符串 s 和 t，每个字符串中的字符都不重复，且 t 是 s 的一个排列。
 * 排列差 定义为 s 和 t 中每个字符在两个字符串中位置的绝对差值之和。
 * 返回 s 和 t 之间的 排列差 。
 *
 * 示例：
 * 输入1：s = "abc", t = "bac"
 * 输出1：2
 *
 * 输入2：s = "abcde", t = "edbac"
 * 输出2：12
 */
public class T3146 {
    /**
     * 自己实现：根据题意模拟
     */
    public int findPermutationDifference(String s, String t) {
        // 记录每个字符的位置
        int[] si = new int[26];
        int[] ti = new int[26];

        for (int i = 0; i < s.length(); i++) {
            si[s.charAt(i) - 'a'] = i;
            ti[t.charAt(i) - 'a'] = i;
        }

        // 计算排列差
        int ans = 0;

        for (int i = 0; i < 26; i++) {
            ans += Math.abs(si[i] - ti[i]);
        }
        return ans;
    }

    /**
     * 社区解法：优化实现
     */
    public int findPermutationDifference1(String s, String t) {
        // 可以只创建一个数组记录
        int[] range = new int[26];
        for (int i = 0; i < s.length(); i++) {
            range[s.charAt(i) - 'a'] = i;
        }
        int ans = 0;
        for (int i = 0; i < t.length(); i++) {
            ans += Math.abs(i - range[t.charAt(i) - 'a']);
        }
        return ans;
    }
}