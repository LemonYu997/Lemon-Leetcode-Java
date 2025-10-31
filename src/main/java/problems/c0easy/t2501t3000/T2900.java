package problems.c0easy.t2501t3000;

import java.util.ArrayList;
import java.util.List;

/**
 * 2900 最长相邻不相等子序列 I https://leetcode.cn/problems/longest-unequal-adjacent-groups-subsequence-i/description/
 * 给定一个字符串数组 words ，和一个 二进制 数组 groups ，两个数组长度都是 n 。
 * 如果 words 的一个 子序列 是交替的，那么对于序列中的任意两个连续字符串，
 * 它们在 groups 中相同索引的对应元素是 不同 的（也就是说，不能有连续的 0 或 1），
 * 你需要从 words 中选出 最长交替子序列。
 * 返回选出的子序列。如果有多个答案，返回 任意 一个。
 * 注意：words 中的元素是不同的 。
 *
 * 示例：
 * 输入1：words = ["e","a","b"], groups = [0,0,1]
 * 输出1：["e","b"]
 *
 * 输入2：words = ["a","b","c","d"], groups = [1,0,1,1]
 * 输出2：["a","b","c"]
 */
public class T2900 {
    /**
     * 官方解法：贪心，根据题意模拟
     */
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<String>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (i == 0 || groups[i] != groups[i - 1]) {
                ans.add(words[i]);
            }
        }
        return ans;
    }
}
