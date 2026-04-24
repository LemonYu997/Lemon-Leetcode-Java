package problems.c0easy.t3001t3500;

/**
 * 3438 找到字符串中合法的相邻数字 https://leetcode.cn/problems/find-valid-pair-of-adjacent-digits-in-string/description/
 * 给你一个只包含数字的字符串 s 。如果 s 中两个 相邻 的数字满足以下条件，我们称它们是 合法的 ：
 * 前面的数字 不等于 第二个数字。
 * 两个数字在 s 中出现的次数 恰好 分别等于这个数字本身。
 * 请你从左到右遍历字符串 s ，并返回最先找到的 合法 相邻数字。如果这样的相邻数字不存在，请你返回一个空字符串。
 *
 * 示例：
 * 输入1：s = "2523533"
 * 输出1："23"
 *
 * 输入2：s = "221"
 * 输出2："21"
 *
 * 输入3：s = "22"
 * 输出3：""
 */
public class T3438 {
    /**
     * 社区解法：模拟
     */
    public String findValidPair(String s) {
        char[] chars = s.toCharArray();
        int[] cnt = new int[10];
        for (char c : chars) {
            cnt[c - '0']++;
        }

        for (int i = 1; i < s.length(); i++) {
            int x = chars[i - 1] - '0';
            int y = chars[i] - '0';
            if (x != y && cnt[x] == x && cnt[y] == y) {
                return s.substring(i - 1, i + 1);
            }
        }
        return "";
    }
}
