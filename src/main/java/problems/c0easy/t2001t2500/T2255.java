package problems.c0easy.t2001t2500;

/**
 * 2255 统计是给定字符串前缀的字符串数目 https://leetcode.cn/problems/count-prefixes-of-a-given-string/description/
 * 给你一个字符串数组 words 和一个字符串 s ，其中 words[i] 和 s 只包含 小写英文字母 。
 * 请你返回 words 中是字符串 s 前缀 的 字符串数目 。
 * 一个字符串的 前缀 是出现在字符串开头的子字符串。
 * 子字符串 是一个字符串中的连续一段字符序列。
 *
 * 示例：
 * 输入1：words = ["a","b","c","ab","bc","abc"], s = "abc"
 * 输出1：3
 *
 * 输入2：words = ["a","a"], s = "aa"
 * 输出2：2
 */
public class T2255 {
    /**
     * 自己实现：根据题意遍历即可
     */
    public int countPrefixes(String[] words, String s) {
        int ans = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                ans++;
            }
        }
        return ans;
    }
}
