package problems.c0easy.t1501t2000;

import java.util.Arrays;

/**
 * 1624 两个相同字符之间的最长子字符串 https://leetcode.cn/problems/largest-substring-between-two-equal-characters/description/
 * 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，
 * 计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
 * 子字符串 是字符串中的一个连续字符序列。
 *
 * 示例：
 * 输入1：s = "aa"
 * 输出1：0
 *
 * 输入2：s = "abca"
 * 输出2：2
 *
 * 输入3：s = "cbzxy"
 * 输出3：-1
 *
 * 输入4：s = "cabbac"
 * 输出4：4
 */
public class T1624 {
    /**
     * 自己实现：遍历每一个字符，找到其下一个相同字符
     * 找相同字符时需要倒序找，这样才能保证长度最长
     */
    public int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length();
        int ans = -1;

        // 初步遍历
        for (int i = 0; i < n; i++) {
            // 如果从 i 开始剩下的可遍历长度已经不足 ans 时，可直接结束
            if (ans >= 0 && i + ans >= n) {
                break;
            }
            for (int j = n - 1; j >= i; j--) {
                // 如果从 j 开始剩下的可遍历例长度不足 ans 时，可以直接结束
                if (ans >= 0 && i + ans > j) {
                    break;
                }
                if (s.charAt(j) == s.charAt(i)) {
                    ans = Math.max(ans, j - i - 1);
                }
            }
        }

        return ans;
    }

    /**
     * 官方解法：计算所有子字符长度最大值
     */
    public int maxLengthBetweenEqualCharacters1(String s) {
        int[] firstIndex = new int[26];
        Arrays.fill(firstIndex, -1);
        int maxLength = -1;
        for (int i = 0; i < s.length(); i++) {
            if (firstIndex[s.charAt(i) - 'a'] < 0) {
                firstIndex[s.charAt(i) - 'a'] = i;
            } else {
                maxLength = Math.max(maxLength, i - firstIndex[s.charAt(i) - 'a'] - 1);
            }
        }

        return maxLength;
    }
}
