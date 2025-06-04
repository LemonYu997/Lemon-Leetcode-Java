package problems.c0easy.t2001t2500;

import java.util.Arrays;

/**
 * 2423 删除字符使频率相同 https://leetcode.cn/problems/remove-letter-to-equalize-frequency/description/
 * 给你一个下标从 0 开始的字符串 word ，字符串只包含小写英文字母。你需要选择 一个 下标并 删除 下标处的字符，
 * 使得 word 中剩余每个字母出现 频率 相同。
 *
 * 如果删除一个字母后，word 中剩余所有字母的出现频率都相同，那么返回 true ，否则返回 false 。
 *
 * 注意：
 *
 * 字母 x 的 频率 是这个字母在字符串中出现的次数。
 * 你 必须 恰好删除一个字母，不能一个字母都不删除。
 *
 * 示例：
 * 输入1：word = "abcc"
 * 输出1：true
 *
 * 输入2：word = "aazz"
 * 输出2：false
 */
public class T2423 {
    /**
     * 自己实现：统计所有字母出现个数，看是否某个字母次数恰好多一次
     */
    public boolean equalFrequency(String word) {
        int[] counts = new int[26];

        for (int i = 0; i < word.length(); i++) {
            counts[word.charAt(i) - 'a']++;
        }

        Arrays.sort(counts);
        // 找到起始字母
        int start = 0;
        while (counts[start] == 0) start++;

        // 遍历每一个字母，假设将当前字母数量减少一个，判断是否与其他所有字母数量都相等
        for (int i = start; i < 26; i++) {
            counts[i]--;
            if (same(counts, start)) return true;
            counts[i]++;
        }

        return false;
    }


    private boolean same(int[] counts, int start) {
        while (counts[start] == 0) {
            start++;
        }

        int count = counts[start];
        for (int i = start; i < counts.length; i++) {
            if (count != counts[i]) {
                return false;
            }
        }

        return true;
    }
}
