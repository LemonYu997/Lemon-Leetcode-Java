package problems.c0easy.t2001t2500;

/**
 * 2114 句子中的最多单词数 https://leetcode.cn/problems/maximum-number-of-words-found-in-sentences/description/
 * 一个 句子 由一些 单词 以及它们之间的单个空格组成，句子的开头和结尾不会有多余空格。
 * 给你一个字符串数组 sentences ，其中 sentences[i] 表示单个 句子 。
 * 请你返回单个句子里 单词的最多数目 。
 *
 * 示例：
 * 输入1：sentences = ["alice and bob love leetcode", "i think so too", "this is great thanks very much"]
 * 输出1：6
 *
 * 输入2：sentences = ["please wait", "continue to fight", "continue to win"]
 * 输出2：3
 */
public class T2114 {
    /**
     * 自己实现：遍历即可
     */
    public int mostWordsFound(String[] sentences) {
        int ans = 0;

        for (String sentence : sentences) {
            ans = Math.max(sentence.split(" ").length, ans);
        }

        return ans;
    }
}
