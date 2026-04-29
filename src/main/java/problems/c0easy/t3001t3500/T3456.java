package problems.c0easy.t3001t3500;

/**
 * 3456 找出长度为 K 的特殊子字符串 https://leetcode.cn/problems/find-special-substring-of-length-k/description/
 * 给你一个字符串 s 和一个整数 k。
 * 判断是否存在一个长度 恰好 为 k 的子字符串，该子字符串需要满足以下条件：
 * 该子字符串 只包含一个唯一字符（例如，"aaa" 或 "bbb"）。
 * 如果该子字符串的 前面 有字符，则该字符必须与子字符串中的字符不同。
 * 如果该子字符串的 后面 有字符，则该字符也必须与子字符串中的字符不同。
 * 如果存在这样的子串，返回 true；否则，返回 false。
 * 子字符串 是字符串中的连续、非空字符序列。
 *
 * 示例：
 * 输入1：s = "aaabaaa", k = 3
 * 输出1：true
 *
 * 输入2：s = "abc", k = 2
 * 输出2：false
 */
public class T3456 {
    /**
     * 自己实现：根据题意模拟
     */
    public boolean hasSpecialSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt++;
            // 遇到不同的字符则结束这一批
            if (i == n - 1 || chars[i] != chars[i + 1]) {
                if (cnt == k) {
                    return true;
                }
                cnt = 0;
            }
        }

        return false;
    }
}
