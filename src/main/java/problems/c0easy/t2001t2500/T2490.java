package problems.c0easy.t2001t2500;

/**
 * 2490 回环句 https://leetcode.cn/problems/circular-sentence/description/
 * 句子 是由单个空格分隔的一组单词，且不含前导或尾随空格。
 *
 * 例如，"Hello World"、"HELLO"、"hello world hello world" 都是符合要求的句子。
 * 单词 仅 由大写和小写英文字母组成。且大写和小写字母会视作不同字符。
 *
 * 如果句子满足下述全部条件，则认为它是一个 回环句 ：
 *
 * 句子中每个单词的最后一个字符等于下一个单词的第一个字符。
 * 最后一个单词的最后一个字符和第一个单词的第一个字符相等。
 * 例如，"leetcode exercises sound delightful"、"eetcode"、"leetcode eats soul" 都是回环句。
 * 然而，"Leetcode is cool"、"happy Leetcode"、"Leetcode" 和 "I like Leetcode" 都 不 是回环句。
 *
 * 给你一个字符串 sentence ，请你判断它是不是一个回环句。如果是，返回 true ；否则，返回 false 。
 *
 * 示例：
 * 输入1：sentence = "leetcode exercises sound delightful"
 * 输出1：true
 *
 * 输入2：sentence = "eetcode"
 * 输出2：true
 *
 * 输入3：sentence = "Leetcode is cool"
 * 输出3：false
 */
public class T2490 {
    /**
     * 自己实现：跟具体以模拟
     */
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        int n = words.length;

        for (int i = 0; i < n; i++) {
            // 当前单词尾部
            char last = words[i].charAt(words[i].length() - 1);
            // 判断首尾单词是否相连
            if (i == n - 1) {
                if (last != words[0].charAt(0)) {
                    return false;
                }
            } else {
                if (last != words[i + 1].charAt(0)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 官方解法：优化写法
     */
    public boolean isCircularSentence1(String sentence) {
        if (sentence.charAt(sentence.length() - 1) != sentence.charAt(0)) {
            return false;
        }
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ' && sentence.charAt(i + 1) != sentence.charAt(i - 1)) {
                return false;
            }
        }

        return true;
    }
}