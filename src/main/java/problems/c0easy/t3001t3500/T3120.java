package problems.c0easy.t3001t3500;

/**
 * 3120 统计特殊字母的数量 I https://leetcode.cn/problems/count-the-number-of-special-characters-i/description/
 * 给你一个字符串 word。如果 word 中同时存在某个字母的小写形式和大写形式，
 * 则称这个字母为 特殊字母 。
 * 返回 word 中 特殊字母 的数量。
 *
 * 示例：
 * 输入1：word = "aaAbcBC"
 * 输出1：3
 *
 * 输入2：word = "abc"
 * 输出2：0
 *
 * 输入3：word = "abBCab"
 * 输出3：1
 */
public class T3120 {
    /**
     * 自己实现：根据题意遍历即可
     */
    public int numberOfSpecialChars(String word) {
        // 统计大小写字符是否出现
        int[] low = new int[26];
        int[] high = new int[26];
        int ans = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                low[c - 'a']++;
            }
            if (c >= 'A' && c <= 'Z') {
                high[c - 'A']++;
            }
        }

        // 判断大小写是否同时出现
        for (int i = 0; i < 26; i++) {
            if (low[i] > 0 && high[i] > 0) {
                ans++;
            }
        }
        return ans;
    }


    /**
     * 社区解法：位运算
     */
    public int numberOfSpecialChars1(String word) {
        int[] mask = new int[2];
        for (char c : word.toCharArray()) {
            mask[c >> 5 & 1] |= 1 << (c & 31);
        }
        return Integer.bitCount(mask[0] & mask[1]);
    }
}
