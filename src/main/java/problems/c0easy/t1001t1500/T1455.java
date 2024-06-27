package problems.c0easy.t1001t1500;

/**
 * 1455 检查单词是否为句中其他单词的前缀 https://leetcode.cn/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/description/
 * 给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，
 * 其中句子由若干用 单个空格 分隔的单词组成。
 * 请你检查检索词 searchWord 是否为句子 sentence 中任意单词的前缀。
 *
 * 如果 searchWord 是某一个单词的前缀，
 * 则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。
 * 如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。
 * 如果 searchWord 不是任何单词的前缀，则返回 -1 。
 *
 * 字符串 s 的 前缀 是 s 的任何前导连续子字符串。
 *
 * 示例：
 * 输入1：sentence = "i love eating burger", searchWord = "burg"
 * 输出1：4
 *
 * 输入2：sentence = "this problem is an easy problem", searchWord = "pro"
 * 输出2：sentence = "i am tired", searchWord = "you"
 *
 * 输入3：sentence = "i am tired", searchWord = "you"
 * 输出3：-1
 */
public class T1455 {
    /**
     * 自己实现：先遍历每个单词，再去匹配 searchWord
     */
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
