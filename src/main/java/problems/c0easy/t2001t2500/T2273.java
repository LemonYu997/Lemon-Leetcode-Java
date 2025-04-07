package problems.c0easy.t2001t2500;

import java.util.ArrayList;
import java.util.List;

/**
 * 2273 移除字母异位词后的结果数组 https://leetcode.cn/problems/find-resultant-array-after-removing-anagrams/description/
 * 给你一个下标从 0 开始的字符串 words ，其中 words[i] 由小写英文字符组成。
 *
 * 在一步操作中，需要选出任一下标 i ，从 words 中 删除 words[i] 。
 * 其中下标 i 需要同时满足下述两个条件：
 *
 * 0 < i < words.length
 * words[i - 1] 和 words[i] 是 字母异位词 。
 * 只要可以选出满足条件的下标，就一直执行这个操作。
 * 在执行所有操作后，返回 words 。可以证明，按任意顺序为每步操作选择下标都会得到相同的结果。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * 例如，"dacb" 是 "abdc" 的一个字母异位词。
 *
 * 示例：
 * 输入1：words = ["abba","baba","bbaa","cd","cd"]
 * 输出1：["abba","cd"]
 *
 * 输入2：words = ["a","b","c","d","e"]
 * 输出2：["a","b","c","d","e"]
 */
public class T2273 {
    /**
     * 自己实现：相当于只保留相邻字符串的首个字母异位词
     */
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        // 遍历每一个单词，判断是否与上个单词为字母异位词
        for (int i = 1; i < n; i++) {
            // 如果当前单词不为上个单词的字母异位词，就计入答案
            if (!checkWords(words[i], words[i - 1])) {
                ans.add(words[i]);
            }
        }

        return ans;
    }

    /**
     * 判断两个单词是否为字母异位词
     */
    private boolean checkWords(String w1, String w2) {
        if (w1.length() != w2.length()) {
            return false;
        }
        // 记录每个单词的字母出现个数
        int[] temp = new int[26];

        for (int i = 0; i < w1.length(); i++) {
            temp[w1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < w2.length(); i++) {
            temp[w2.charAt(i) - 'a']--;
        }

        for (int t : temp) {
            if (t != 0) {
                return false;
            }
        }
        return true;
    }

}
