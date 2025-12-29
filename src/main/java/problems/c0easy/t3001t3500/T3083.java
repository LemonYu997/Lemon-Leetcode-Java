package problems.c0easy.t3001t3500;

/**
 * 3083 字符串及其反转中是否存在同一子字符串 https://leetcode.cn/problems/existence-of-a-substring-in-a-string-and-its-reverse/description/
 * 给你一个字符串 s ，请你判断字符串 s 是否存在一个长度为 2 的子字符串，
 * 在 s 反转后的字符串中也出现。
 * 如果存在这样的子字符串，返回 true；如果不存在，返回 false 。
 *
 * 示例：
 * 输入1：s = "leetcode"
 * 输出1：true
 *
 * 输入2：s = "abcba"
 * 输出2：true
 *
 * 输入3：s = "abcd"
 * 输出3：false
 */
public class T3083 {
    /**
     * 自己实现：根据题意模拟即可
     */
    public boolean isSubstringPresent(String s) {
        for (int i = 0; i + 1 < s.length(); i++) {
            String substr = new StringBuilder(s.substring(i, i + 2)).reverse().toString();
            if (s.contains(substr)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 官方解法：哈希表 + 位运算优化
     */
    public boolean isSubstringPresent1(String s) {
        int[] h = new int[26];
        for (int i = 0; i + 1 < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            int y = s.charAt(i + 1) - 'a';
            h[x] |= 1 << y;
            if ((h[y] >> x & 1) != 0) {
                return true;
            }
        }
        return false;
    }
}