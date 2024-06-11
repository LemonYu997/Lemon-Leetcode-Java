package problems.c0easy.t1001t1500;

import java.util.ArrayList;
import java.util.List;

/**
 * 1408 数组中的字符串匹配 https://leetcode.cn/problems/string-matching-in-an-array/description/
 * 给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。
 * 请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
 *
 * 如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 words[i] ，
 * 那么字符串 words[i] 就是 words[j] 的一个子字符串。
 *
 * 示例：
 * 输入1：words = ["mass","as","hero","superhero"]
 * 输出1：["as","hero"]
 *
 * 输入2：words = ["leetcode","et","code"]
 * 输出2：["et","code"]
 *
 * 输入3：words = ["blue","green","bu"]
 * 输出3：[]
 */
public class T1408 {
    /**
     * 自己实现：双重遍历，如果长度不匹配直接跳过
     */
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && words[i].length() < words[j].length()) {
                    if (words[j].contains(words[i])) {
                        ans.add(words[i]);
                        // 当前字符串统计过一次之后就可以统计下一个
                        break;
                    }
                }
            }
        }

        return ans;
    }
}
