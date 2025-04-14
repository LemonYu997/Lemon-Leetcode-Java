package problems.c0easy.t2001t2500;

/**
 * 2287 重排字符形成目标字符串 https://leetcode.cn/problems/rearrange-characters-to-make-target-string/description/
 * 给你两个下标从 0 开始的字符串 s 和 target 。
 * 你可以从 s 取出一些字符并将其重排，得到若干新的字符串。
 * 从 s 中取出字符并重新排列，返回可以形成 target 的 最大 副本数。
 *
 * 示例：
 * 输入1：s = "ilovecodingonleetcode", target = "code"
 * 输出1：2
 *
 * 输入2：s = "abcba", target = "abc"
 * 输出2：1
 *
 * 输入3：s = "abbaccaddaeea", target = "aaaaa"
 * 输出3：1
 */
public class T2287 {
    /**
     * 自己实现：使用数组存储每个字符出现的字数
     */
    public int rearrangeCharacters(String s, String target) {
        int[] counts1 = new int[26];
        int[] counts2 = new int[26];

        // 统计原字符出现的
        for (int i = 0; i < s.length(); i++) {
            counts1[s.charAt(i) - 'a']++;
        }

        // 统计目标字符串各个字符出现的次数
        for (int i = 0; i < target.length(); i++) {
            counts2[target.charAt(i) - 'a']++;
        }

        // 找到所有字符满足 counts1 / counts2 的最小值即可
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < 26; i++) {
            if (counts2[i] != 0) {
                ans = Math.min(ans, counts1[i] / counts2[i]);
            }
        }

        return ans;
    }
}
