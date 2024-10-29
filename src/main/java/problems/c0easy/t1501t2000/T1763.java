package problems.c0easy.t1501t2000;

/**
 * 1763 最长的美好子字符串 https://leetcode.cn/problems/longest-nice-substring/description/
 * 当一个字符串 s 包含的每一种字母的大写和小写形式 同时 出现在 s 中，
 * 就称这个字符串 s 是 美好 字符串。比方说，"abABB" 是美好字符串，
 * 因为 'A' 和 'a' 同时出现了，且 'B' 和 'b' 也同时出现了。
 * 然而，"abA" 不是美好字符串因为 'b' 出现了，而 'B' 没有出现。
 *
 * 给你一个字符串 s ，请你返回 s 最长的 美好子字符串 。如果有多个答案，
 * 请你返回 最早 出现的一个。如果不存在美好子字符串，请你返回一个空字符串。
 *
 * 示例：
 * 输入1：s = "YazaAay"
 * 输出1："aAa"
 *
 * 输入2：s = "Bb"
 * 输出2："Bb"
 *
 * 输入3：s = "c"
 * 输出3：""
 *
 * 输入4：s = "dDzeE"
 * 输出4："dD"
 */
public class T1763 {
    /**
     * 官方解法1：枚举
     * 用二进制表示每个字母是否出现，lower表示小写，upper表示大写
     */
    public String longestNiceSubstring(String s) {
        int n = s.length();
        int maxPos = 0;
        int maxLen = 0;

        // 遍历所有可能的子字符串
        for (int i = 0; i < n; i++) {
            // 出现的小写字母
            int lower = 0;
            int upper = 0;
            for (int j = i; j < n; j++) {
                if (Character.isLowerCase(s.charAt(j))) {
                    // 将对应位置为1
                    lower |= 1 << (s.charAt(j) - 'a');
                } else {
                    upper |= 1 << (s.charAt(j) - 'A');
                }
                // 更新最长子字符串的初始索引位置及其长度
                if (lower == upper && j - i + 1 > maxLen) {
                    maxPos = i;
                    maxLen = j - i + 1;
                }
            }
        }

        return s.substring(maxPos, maxPos + maxLen);
    }

    /**
     * 官方解法2：分治策略
     */
    class Solution {
        private int maxPos;
        private int maxLen;

        public String longestNiceSubstring(String s) {
            this.maxLen = 0;
            this.maxPos = 0;
            dfs(s, 0, s.length() - 1);
            return s.substring(maxPos, maxPos + maxLen);
        }

        /**
         * 分治方法
         */
        public void dfs(String s, int start, int end) {
            if (start >= end) {
                return;
            }

            int lower = 0;
            int upper = 0;

            for (int i = start; i <= end; i++) {
                if (Character.isLowerCase(s.charAt(i))) {
                    lower |= 1 << (s.charAt(i) - 'a');
                } else {
                    upper |= 1 << (s.charAt(i) - 'A');
                }
            }

            if (lower == upper) {
                if (end - start + 1 > maxLen) {
                    maxPos = start;
                    maxLen = end - start + 1;
                }
                return;
            }
            int valid = lower & upper;
            int pos = start;
            while (pos <= end) {
                start = pos;
                while (pos <= end && (valid & (1 << Character.toLowerCase(s.charAt(pos)) - 'a')) != 0) {
                    pos++;
                }
                dfs(s, start, pos - 1);
                pos++;
            }
        }
    }
}
