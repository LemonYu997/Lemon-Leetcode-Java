package problems.c0easy.t3501t4000;

/**
 * 3884 双端字符匹配 https://leetcode.cn/problems/first-matching-character-from-both-ends/description/
 * 给你一个长度为 n 的字符串 s，其中只包含小写英文字母。
 * 返回最小的下标 i，使得 s[i] == s[n - i - 1]。
 * 如果不存在这样的下标，返回 -1。
 *
 * 示例：
 * 输入1：s = "abcacbd"
 * 输出1：1
 *
 * 输入2：s = "abc"
 * 输出2：1
 *
 * 输入3：s = "abcdab"
 * 输出3：-1
 */
public class T3884 {
    /**
     * 自己实现：根据题意遍历
     */
    public int firstMatchingIndex(String s) {
        int n = s.length();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(n - i - 1)) {
                return i;
            }
        }
        return -1;
    }
}
