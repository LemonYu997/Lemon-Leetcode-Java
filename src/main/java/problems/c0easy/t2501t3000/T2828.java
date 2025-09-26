package problems.c0easy.t2501t3000;

import java.util.List;

/**
 * 2828 判别首字母缩略词 https://leetcode.cn/problems/check-if-a-string-is-an-acronym-of-words/description/
 * 给你一个字符串数组 words 和一个字符串 s ，请你判断 s 是不是 words 的 首字母缩略词 。
 * 如果可以按顺序串联 words 中每个字符串的第一个字符形成字符串 s ，则认为 s 是 words 的首字母缩略词。
 * 例如，"ab" 可以由 ["apple", "banana"] 形成，但是无法从 ["bear", "aardvark"] 形成。
 * 如果 s 是 words 的首字母缩略词，返回 true ；否则，返回 false 。
 *
 * 示例：
 * 输入1：words = ["alice","bob","charlie"], s = "abc"
 * 输出1：true
 *
 * 输入2：words = ["an","apple"], s = "a"
 * 输出2：false
 *
 * 输入3：words = ["never","gonna","give","up","on","you"], s = "ngguoy"
 * 输出3：true
 */
public class T2828 {
    /**
     * 自己实现：根据题意判断即可
     */
    public boolean isAcronym(List<String> words, String s) {
        if (s.length() != words.size()) {
            return false;
        }
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).charAt(0) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
