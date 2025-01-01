package problems.c0easy.t1501t2000;

/**
 * 1967 作为子字符串出现在单词中的字符串数目 https://leetcode.cn/problems/number-of-strings-that-appear-as-substrings-in-word/description/
 * 给你一个字符串数组 patterns 和一个字符串 word ，
 * 统计 patterns 中有多少个字符串是 word 的子字符串。返回字符串数目。
 *
 * 子字符串 是字符串中的一个连续字符序列。
 *
 * 示例：
 * 输入1：patterns = ["a","abc","bc","d"], word = "abc"
 * 输出1:3
 *
 * 输入2：patterns = ["a","b","c"], word = "aaaaabbbbb"
 * 输出2:2
 *
 * 输入3：patterns = ["a","a","a"], word = "ab"
 * 输出3:3
 */
public class T1967 {
    /**
     * 自己实现：遍历并统计
     */
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                ans++;
            }
        }

        return ans;
    }
}
