package problems.c0easy.t3001t3500;

/**
 * 3090 每个字符最多出现两次的最长子字符串 https://leetcode.cn/problems/maximum-length-substring-with-two-occurrences/description/
 * 给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，
 * 并返回该子字符串的 最大 长度。
 *
 * 示例：
 * 输入1：s = "bcbbbcba"
 * 输出1：4
 *
 * 输入2：s = "aaaa"
 * 输出2：2
 */
public class T3090 {
    /**
     * 官方解法：滑动窗口
     */
    public int maximumLengthSubstring(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        int left = 0;
        int[] cnt = new int[26];
        for (int i = 0; i < chars.length; i++) {
            int b = chars[i] - 'a';
            cnt[b]++;
            while (cnt[b] > 2) {
                cnt[chars[left] - 'a']--;
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
