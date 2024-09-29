package problems.c0easy.t1501t2000;

import java.util.Arrays;

/**
 * 1668 最大重复子字符串 https://leetcode.cn/problems/maximum-repeating-substring/description/
 * 给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，
 * 那么单词 word 的 重复值为 k 。单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。
 * 如果 word 不是 sequence 的子串，那么重复值 k 为 0 。
 *
 * 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。
 *
 * 示例：
 * 输入1：sequence = "ababc", word = "ab"
 * 输出1：2
 *
 * 输入2：sequence = "ababc", word = "ba"
 * 输出2：1
 *
 * 输入3：sequence = "ababc", word = "ac"
 * 输出3：0
 */
public class T1668 {
    /**
     * 自己实现：每一个字母都尝试
     * 错误解法：在 sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba", word = "aaaba" 时
     * 因为刚开始满足条件会向后跳过 word，导致分割不正确
     * 如 aaaba aaaba aaba aaaba aaaba aaaba aaaba ，最大连续长度为 4
     * 但是 aaabaaaab aaaba aaaba aaaba aaaba aaaba ，最大连续长度为 5
     */
    public int maxRepeating(String sequence, String word) {
        int m = sequence.length();
        int n = word.length();
        int ans = 0;
        int temp = 0;

        // 如果最后剩余的长度不足 word 长度，可以直接放弃
        for (int i = 0; i < m - n + 1; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                // 如果存在不相等的 直接跳过
                if (word.charAt(j) != sequence.charAt(i + j)) {
                    // 因为需要连续重复的最大值，这里可以判断
                    ans = Math.max(temp, ans);
                    temp = 0;   // 重置 temp
                    flag = false;
                    break;
                }
            }
            // 如果有符合条件的，需要完全跳过当前重复的 word
            if (flag) {
                i += n - 1;
                temp++;
            }
        }

        return ans;
    }

    /**
     * 官方解法：枚举加动态规划
     */
    public int maxRepeating1(String sequence, String word) {
        int m = sequence.length();
        int n = word.length();
        if (m < n) {
            return 0;
        }

        // 以 sequence 的每个字符作为结束位置，若前方几个字符为 word 则为 1，否则为 0
        // 连续重复时就在之前的基础上 + 1
        int[] f = new int[m];
        // 统计每个位置成立的可能性，前边 n - 1 个位置因为不满足单词长度条件，直接跳过
        for (int i = n - 1; i < m; i++) {
            boolean valid = true;
            // 判断前 n 个字符是否满足
            for (int j = 0; j < n; j++) {
                if (sequence.charAt(i - n + j + 1) != word.charAt(j)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                // 初始为 0，如果连续重复时，会不断累加
                f[i] = (i == n - 1 ? 0 : f[i - n]) + 1;
            }
        }

        // 返回统计的最大值
        return Arrays.stream(f).max().getAsInt();
    }
}
