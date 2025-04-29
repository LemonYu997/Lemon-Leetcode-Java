package problems.c0easy.t2001t2500;

/**
 * 2351 第一个出现两次的字母 https://leetcode.cn/problems/first-letter-to-appear-twice/description/
 * 给你一个由小写英文字母组成的字符串 s ，请你找出并返回第一个出现 两次 的字母。
 * 注意：
 * 如果 a 的 第二次 出现比 b 的 第二次 出现在字符串中的位置更靠前，
 * 则认为字母 a 在字母 b 之前出现两次。
 * s 包含至少一个出现两次的字母。
 *
 * 示例：
 * 输入1：s = "abccbaacz"
 * 输出1："c"
 *
 * 输入2：s = "abcdd"
 * 输出2："d"
 */
public class T2351 {
    /**
     * 自己实现：使用数组统计字母出现次数
     */
    public char repeatedCharacter(String s) {
        int[] temp = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (temp[c - 'a'] > 0) {
                return c;
            }
            temp[c - 'a']++;
        }

        return ' ';
    }
}
