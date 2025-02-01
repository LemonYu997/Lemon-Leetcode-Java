package problems.c0easy.t2001t2500;

/**
 * 2068 检查两个字符串是否几乎相等 https://leetcode.cn/problems/check-whether-two-strings-are-almost-equivalent/description/
 * 如果两个字符串 word1 和 word2 中从 'a' 到 'z' 每一个字母出现频率之差都 不超过 3 ，
 * 那么我们称这两个字符串 word1 和 word2 几乎相等 。
 * 给你两个长度都为 n 的字符串 word1 和 word2 ，如果 word1 和 word2 几乎相等 ，
 * 请你返回 true ，否则返回 false 。
 * 一个字母 x 的出现 频率 指的是它在字符串中出现的次数。
 *
 * 示例：
 * 输入1：word1 = "aaaa", word2 = "bccb"
 * 输出1：false
 *
 * 输入2：word1 = "abcdeef", word2 = "abaaacc"
 * 输出2：true
 *
 * 输入3：word1 = "cccddabba", word2 = "babababab"
 * 输出3：true
 */
public class T2068 {
    /**
     * 自己实现：用数组统计每个字符出现的个数
     */
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] ch1 = new int[26];
        int[] ch2 = new int[26];
        int n = word1.length();

        for (int i = 0; i < n; i++) {
            ch1[word1.charAt(i) - 'a']++;
            ch2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (Math.abs(ch1[i] - ch2[i]) > 3) {
                return false;
            }
        }

        return true;
    }

    /**
     * 优化解法：只用一个数组统计
     */
    public boolean checkAlmostEquivalent1(String word1, String word2) {
        int[] chs = new int[26];
        int n = word1.length();

        for (int i = 0; i < n; i++) {
            chs[word1.charAt(i) - 'a']++;
            chs[word2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (Math.abs(chs[i]) > 3) {
                return false;
            }
        }

        return true;
    }
}
